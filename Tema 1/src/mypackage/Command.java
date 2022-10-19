package mypackage;

import fileio.ActionInputData;
import fileio.UserInputData;
import fileio.Writer;

import java.util.List;

/**
 * The type Command.
 */
public final class Command {

    private List<ActionInputData> commands;

    /**
     * Instantiates a new Command.
     *
     * @param commands the commands
     */
    public Command(final List<ActionInputData> commands) {
        this.commands = commands;
    }

    /**
     * Gets commands.
     *
     * @return the commands
     */
    public List<ActionInputData> getCommands() {
        return commands;
    }

    /**
     * Sets commands.
     *
     * @param commands the commands
     */
    public void setCommands(final List<ActionInputData> commands) {
        this.commands = commands;
    }

    /**
     * Apply command type json array.
     *
     * Applies the command type by using the input given by the parameters.
     * For every command, it identifies the user who gave the command -> searchUser
     * For every command it uses functions from other classes to compute the output
     *
     * @param command     the command
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     * @param fileWriter  the file writer
     * @return the json array
     */
    public JSONArray applyCommandType(final ActionInputData command, final PremiumUser premiumUser,
                                      final BasicUser basicUser, final Writer fileWriter) {

        JSONArray objectArray = new JSONArray();

        UserInputData searchUser = new UserInputData("", "", null, null);
        if (premiumUser != null) {
            for (UserInputData user : premiumUser.getUsers()) {
                if (user.getUsername().equals(command.getUsername())) {
                    searchUser = user;
                }
            }
        }
        if (basicUser != null) {
            for (UserInputData user : basicUser.getUsers()) {
                if (user.getUsername().equals(command.getUsername())) {
                    searchUser = user;
                }
            }
        }

        if (command.getType().equals("favorite")) {
            if (searchUser.getSubscriptionType().equals("PREMIUM")) {
                if (premiumUser != null) {
                    if (premiumUser.alreadyInFavourites(searchUser, command.getTitle())) {
                        objectArray.alreadyInFavourites(command, fileWriter);
                    } else if (premiumUser.addToFavourites(searchUser, command.getTitle())) {
                        objectArray.addFavoriteSuccessArray(command, fileWriter);
                    } else {
                        objectArray.notSeen(command, fileWriter);
                    }
                }

            } else if (searchUser.getSubscriptionType().equals("BASIC")) {
                if (basicUser != null) {
                    if (basicUser.alreadyInFavourites(searchUser, command.getTitle())) {
                        objectArray.alreadyInFavourites(command, fileWriter);
                    } else if (basicUser.addToFavourites(searchUser, command.getTitle())) {
                        objectArray.addFavoriteSuccessArray(command, fileWriter);
                    } else {
                        objectArray.notSeen(command, fileWriter);
                    }
                }
            }
        }

        if (command.getType().equals("view")) {
            if (searchUser.getSubscriptionType().equals("PREMIUM")) {
                if (premiumUser != null) {
                    premiumUser.addToViewed(searchUser, command.getTitle());
                    objectArray.addViewedArray(searchUser, command, fileWriter);
                }
            } else if (searchUser.getSubscriptionType().equals("BASIC")) {
                if (basicUser != null) {
                    basicUser.addToViewed(searchUser, command.getTitle());
                    objectArray.addViewedArray(searchUser, command, fileWriter);
                }

            }
        }
        if (command.getType().equals("rating")) {

            if (searchUser.getSubscriptionType().equals("PREMIUM")) {
                if (premiumUser != null) {
                    if (!premiumUser.isInHistory(searchUser, command.getTitle())) {
                        objectArray.notSeen(command, fileWriter);
                    } else if (premiumUser.rateVideo(searchUser, command, command.getTitle(),
                            command.getSeasonNumber())) {
                        objectArray.addSuccessRated(command, fileWriter);
                    } else {
                        objectArray.alreadyRated(command, fileWriter);
                    }
                }
            } else if (searchUser.getSubscriptionType().equals("BASIC")) {
                if (basicUser != null) {
                    if (!basicUser.isInHistory(searchUser, command.getTitle())) {
                        objectArray.notSeen(command, fileWriter);
                    } else if (basicUser.rateVideo(searchUser, command, command.getTitle(),
                            command.getSeasonNumber())) {
                        objectArray.addSuccessRated(command, fileWriter);
                    } else {
                        objectArray.alreadyRated(command, fileWriter);
                    }
                }
            }
        }
        return objectArray;
    }
}
