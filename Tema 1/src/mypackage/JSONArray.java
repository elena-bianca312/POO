package mypackage;

import fileio.ActionInputData;
import fileio.MovieInputData;
import fileio.UserInputData;
import fileio.Writer;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Json array.
 *
 * Class that writes the output in an JSONObject type -> to be added to the array in main
 */
public final class JSONArray {

    private final List<JSONObject> objectArray;

    /**
     * Instantiates a new Json array.
     */
    public JSONArray() {
        this.objectArray = new ArrayList<>();
    }

    /**
     * Gets object array.
     *
     * @return the object array
     */
    public List<JSONObject> getObjectArray() {
        return objectArray;
    }

    /**
     * Add favorite success array.
     *
     * Command - Favorite
     * Writes output if the favorite command was successful
     *
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void addFavoriteSuccessArray(final ActionInputData command, final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "add to favourites",
                    "success -> " + command.getTitle() + " was added as favourite"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Not seen.
     *
     * Command - Favorite
     * Writes output if the video from the favorite command has not been seen by the user
     *
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void notSeen(final ActionInputData command, final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "add to favourites",
                    "error -> " + command.getTitle() + " is not seen"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Already in favourites.
     *
     * Command - Favorite
     * Writes output if the video from the favorite is already in the favorite's list
     *
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void alreadyInFavourites(final ActionInputData command, final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "already favourites",
                    "error -> " + command.getTitle() + " is already in favourite list"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add viewed array.
     *
     * Command - View
     * Writes output if the video is viewed
     *
     * @param user       the user
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void addViewedArray(final UserInputData user, final ActionInputData command,
                               final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "add to viewed",
                    "success -> " + command.getTitle() + " was viewed with total views of "
                            + user.getHistory().get(command.getTitle())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Already rated.
     *
     * Command - Rating
     * Writes output if the video from the rating command has already been rated by the user
     *
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void alreadyRated(final ActionInputData command, final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "already rated",
                    "error -> " + command.getTitle() + " has been already rated"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add success rated.
     *
     * Command - Rating
     * Writes output if the rating command is successful
     *
     * @param command    the command
     * @param fileWriter the file writer
     */
    public void addSuccessRated(final ActionInputData command, final Writer fileWriter) {
        try {
            objectArray.add(fileWriter.writeFile(command.getActionId(), "already rated",
                    "success -> " + command.getTitle() + " was rated with "
                            + command.getGrade() + " by " + command.getUsername()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return average actors.
     *
     * Query - Actors - Average
     * Prints the first "number" actors sorted by the average of the videos in their filmography
     * (only for rated videos)
     *
     * @param actors     the actors
     * @param number     the number
     * @param query      the query
     * @param fileWriter the file writer
     */
    public void returnAverageActors(final Actor actors, final Integer number,
                                    final ActionInputData query, final Writer fileWriter) {
        String message = "Query result: [";
        Integer iterator;
        for (iterator = 0; iterator < number; iterator++) {
            if (iterator > actors.getActors().size() - 1) {
                break;
            }
            message += actors.getActors().get(iterator).getName();
            if (number > actors.getActors().size()) {
                if (iterator != actors.getActors().size() - 1) {
                    message += ", ";
                }
            } else {
                if (iterator != number - 1) {
                    message += ", ";
                }
            }
        }
        message += "]";
        try {
            objectArray.add(fileWriter.writeFile(query.getActionId(), "average actors", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print actors.
     *
     * Query - Actors - Awards
     * Query - Actors - Filter Description
     * Prints all the actors with the specified awards or
     * Prints all the actors who match the filter description parameters
     *
     * @param query      the query
     * @param actors     the actors
     * @param fileWriter the file writer
     */
    public void printActors(final ActionInputData query, final Actor actors,
                            final Writer fileWriter) {
        String message = "Query result: [";
        Integer iterator;
        for (iterator = 0; iterator < actors.getActors().size(); iterator++) {
            message += actors.getActors().get(iterator).getName();
            if (iterator != actors.getActors().size() - 1) {
                message += ", ";
            }
        }
        message += "]";
        try {
            objectArray.add(fileWriter.writeFile(query.getActionId(), "print actors", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print movies.
     *
     * Query - Videos - Rating (Movies)
     * Query - Videos - Favorite (Movies)
     * Query - Videos - Longest (Movies)
     * Query - Videos - Most Viewed (Movies)
     *
     * Prints the first "number" of movies sorted accordingly who match the key words in the
     * filter description
     *
     * @param query      the query
     * @param movies     the movies
     * @param number     the number
     * @param fileWriter the file writer
     */
    public void printMovies(final ActionInputData query, final Movie movies, final Integer number,
                            final Writer fileWriter) {
        String message = "Query result: [";
        Integer iterator;
        for (iterator = 0; iterator < number; iterator++) {
            if (iterator > movies.getMovies().size() - 1) {
                break;
            }
            message += movies.getMovies().get(iterator).getTitle();
            if (number > movies.getMovies().size()) {
                if (iterator != movies.getMovies().size() - 1) {
                    message += ", ";
                }
            } else {
                if (iterator != number - 1) {
                    message += ", ";
                }
            }
        }
        message += "]";
        try {
            objectArray.add(fileWriter.writeFile(query.getActionId(), "printMovie", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print serials.
     *
     * Query - Videos - Rating (Serials)
     * Query - Videos - Favorite (Serials)
     * Query - Videos - Longest (Serials)
     * Query - Videos - Most Viewed (Serials)
     *
     * Prints the first "number" of serials sorted accordingly who match the key words in the
     * filter description
     *
     * @param query      the query
     * @param serials    the serials
     * @param number     the number
     * @param fileWriter the file writer
     */
    public void printSerials(final ActionInputData query, final Serial serials,
                             final Integer number, final Writer fileWriter) {
        String message = "Query result: [";
        Integer iterator;
        for (iterator = 0; iterator < number; iterator++) {
            if (iterator > serials.getSerials().size() - 1) {
                break;
            }
            message += serials.getSerials().get(iterator).getTitle();
            if (number > serials.getSerials().size()) {
                if (iterator != serials.getSerials().size() - 1) {
                    message += ", ";
                }
            } else {
                if (iterator != number - 1) {
                    message += ", ";
                }
            }
        }
        message += "]";
        try {
            objectArray.add(fileWriter.writeFile(query.getActionId(), "printSerial", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print users.
     *
     * Query - Users - Number of Ratings
     *
     * Prints the first "number" of users sorted by the number of given ratings
     *
     * @param query      the query
     * @param users      the users
     * @param number     the number
     * @param fileWriter the file writer
     */
    public void printUsers(final ActionInputData query, final PremiumUser users,
                           final Integer number, final Writer fileWriter) {
        String message = "Query result: [";
        Integer iterator;
        for (iterator = 0; iterator < number; iterator++) {
            if (iterator > users.getUsers().size() - 1) {
                break;
            }
            message += users.getUsers().get(iterator).getUsername();
            if (number > users.getUsers().size()) {
                if (iterator != users.getUsers().size() - 1) {
                    message += ", ";
                }
            } else {
                if (iterator != number - 1) {
                    message += ", ";
                }
            }
        }
        message += "]";
        try {
            objectArray.add(fileWriter.writeFile(query.getActionId(), "print users", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print standard recommendations.
     *
     * Recommendation - Standard
     *
     * Prints the video -> standard recommendation
     *
     * @param recommendation the recommendation
     * @param name           the name
     * @param fileWriter     the file writer
     */
    public void printStandardRecommendations(final ActionInputData recommendation,
                                             final String name, final Writer fileWriter) {
        String message;
        if (name.equals("")) {
            message = "StandardRecommendation cannot be applied!";
        } else {
            message = "StandardRecommendation result: " + name;
        }
        try {
            objectArray.add(fileWriter
                    .writeFile(recommendation.getActionId(), "print standard recommendation",
                            message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print best unseen recommendations.
     *
     * Recommendation - Best Unseen
     *
     * Prints the video -> best unseen recommendation
     *
     * @param recommendation the recommendation
     * @param name           the name
     * @param fileWriter     the file writer
     */
    public void printBestUnseenRecommendations(final ActionInputData recommendation,
                                               final String name, final Writer fileWriter) {
        String message;
        if (name.equals("")) {
            message = "BestRatedUnseenRecommendation cannot be applied!";
        } else {
            message = "BestRatedUnseenRecommendation result: " + name;
        }
        try {
            objectArray.add(fileWriter
                    .writeFile(recommendation.getActionId(), "print best unseen recommendation",
                            message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print favorite recommendations.
     *
     * Recommendation - Favorite (Premium Users Only)
     *
     * Prints the video -> favorite recommendation
     *
     * @param recommendation the recommendation
     * @param name           the name
     * @param fileWriter     the file writer
     */
    public void printFavoriteRecommendations(final ActionInputData recommendation,
                                             final String name, final Writer fileWriter) {
        String message;
        if (name.equals("")) {
            message = "FavoriteRecommendation cannot be applied!";
        } else {
            message = "FavoriteRecommendation result: " + name;
        }
        try {
            objectArray.add(fileWriter
                    .writeFile(recommendation.getActionId(), "print favorite recommendation",
                            message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print popular recommendations.
     *
     * Recommendation - Popular (Premium Users Only)
     *
     * Prints the video -> popular recommendation
     *
     * @param recommendation the recommendation
     * @param name           the name
     * @param fileWriter     the file writer
     */
    public void printPopularRecommendations(final ActionInputData recommendation,
                                            final String name, final Writer fileWriter) {
        String message;
        if (name.equals("")) {
            message = "PopularRecommendation cannot be applied!";
        } else {
            message = "PopularRecommendation result: " + name;
        }
        try {
            objectArray.add(fileWriter
                    .writeFile(recommendation.getActionId(), "print popular recommendation",
                            message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print search recommendations.
     *
     * Recommendation - Search (Premium Users Only)
     *
     * Prints the video -> search recommendation
     *
     * @param recommendation the recommendation
     * @param videos         the videos
     * @param fileWriter     the file writer
     */
    public void printSearchRecommendations(final ActionInputData recommendation,
                                           final List<MovieInputData> videos,
                                           final Writer fileWriter) {
        String message;
        if (!videos.isEmpty()) {
            message = "SearchRecommendation result: [";
            Integer iterator;
            for (iterator = 0; iterator < videos.size(); iterator++) {
                message += videos.get(iterator).getTitle();
                if (iterator != videos.size() - 1) {
                    message += ", ";
                }
            }
            message += "]";
        } else {
            message = "SearchRecommendation cannot be applied!";
        }

        try {
            objectArray.add(fileWriter
                    .writeFile(recommendation.getActionId(), "print search recommendation",
                            message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
