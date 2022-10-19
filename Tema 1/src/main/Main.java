package main;

import checker.Checker;
import checker.Checkstyle;
import common.Constants;
import fileio.ActionInputData;
import fileio.Input;
import fileio.InputLoader;
import fileio.Writer;
import mypackage.Action;
import mypackage.Actions;
import mypackage.Actor;
import mypackage.Actors;
import mypackage.BasicUser;
import mypackage.Command;
import mypackage.Movie;
import mypackage.Movies;
import mypackage.PremiumUser;
import mypackage.Query;
import mypackage.Recommendation;
import mypackage.Serial;
import mypackage.Serials;
import mypackage.Users;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * The entry point to this homework. It runs the checker that tests your implentation.
 */
public final class Main {
    /**
     * for coding style
     */
    private Main() {
    }

    /**
     * Call the main checker and the coding style checker
     *
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT_PATH);

        Checker checker = new Checker();
        checker.deleteFiles(outputDirectory.listFiles());

        for (File file : Objects.requireNonNull(directory.listFiles())) {

            String filepath = Constants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }

        checker.iterateFiles(Constants.RESULT_PATH, Constants.REF_PATH, Constants.TESTS_PATH);
        Checkstyle test = new Checkstyle();
        test.testCheckstyle();
    }

    /**
     * Action.
     *
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        Input input = inputLoader.readData();

        Writer fileWriter = new Writer(filePath2);
        JSONArray arrayResult = new JSONArray();

        //TODO add here the entry point to your implementation


        Users mainUsers = new Users(input);
        mainUsers.categorize();
        PremiumUser mainPremiumUsers = mainUsers.initializePremiumUsers();
        BasicUser mainBasicUsers = mainUsers.initializeBasicUsers();

        Actions mainActions = new Actions(input);
        mainActions.categorize();
        Command mainCommands = mainActions.initializeCommand();
        Query mainQueries = mainActions.initializeQuery();
        Recommendation mainRecommendations = mainActions.initializeRecommendation();
        Action allMainActions = mainActions.initializeAction();

        Actors mainActors = new Actors(input);
        Actor mainActor = mainActors.initializeActors();
        Movies mainMovies = new Movies(input);
        Movie mainMovie = mainMovies.initializeMovies();
        mainMovie.setMovieRatings(mainPremiumUsers, mainBasicUsers);
        Serials mainSerials = new Serials(input);
        Serial mainSerial = mainSerials.initializeSerials();
        mainSerial.setSerialRatings(mainPremiumUsers, mainBasicUsers);

        Integer index = mainMovie.setMovieOrder();
        mainSerial.setSerialOrder(index);

        for (ActionInputData action : mainActions.getActions()) {
            mypackage.JSONArray mainJSONObject;
            if (action.getActionType().equals("command")) {
                mainJSONObject = mainCommands
                        .applyCommandType(action, mainPremiumUsers, mainBasicUsers, fileWriter);
                for (JSONObject object : mainJSONObject.getObjectArray()) {
                    arrayResult.add(object);
                }
            } else if (action.getActionType().equals("query")) {
                mainJSONObject = mainQueries
                        .applyQueryType(action, mainPremiumUsers, mainBasicUsers, mainSerial,
                                mainMovie, mainActor, fileWriter);
                for (JSONObject object : mainJSONObject.getObjectArray()) {
                    arrayResult.add(object);
                }
            } else if (action.getActionType().equals("recommendation")) {
                if (mainRecommendations != null) {
                    mainMovie.sortByOrder();
                    mainSerial.sortByOrder();
                    mainJSONObject = mainRecommendations
                            .applyRecommendationType(action, mainPremiumUsers, mainBasicUsers,
                                    mainSerial, mainMovie, fileWriter);
                    for (JSONObject object : mainJSONObject.getObjectArray()) {
                        arrayResult.add(object);
                    }
                }
            }
        }

        fileWriter.closeJSON(arrayResult);
    }
}
