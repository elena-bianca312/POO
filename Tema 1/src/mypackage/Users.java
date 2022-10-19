package mypackage;

import fileio.Input;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Users.
 */
public final class Users {

    private Input userInput;
    private List<UserInputData> premiumUsers = new ArrayList<>();
    private List<UserInputData> basicUsers = new ArrayList<>();

    /**
     * Instantiates a new Users.
     *
     * @param userInput the user input
     */
    public Users(final Input userInput) {
        this.userInput = userInput;
    }

    /**
     * Gets user input.
     *
     * @return the user input
     */
    public Input getUserInput() {
        return userInput;
    }

    /**
     * Sets user input.
     *
     * @param userInput the user input
     */
    public void setUserInput(final Input userInput) {
        this.userInput = userInput;
    }

    /**
     * Gets premium users.
     *
     * @return the premium users
     */
    public List<UserInputData> getPremiumUsers() {
        return premiumUsers;
    }

    /**
     * Sets premium users.
     *
     * @param premiumUsers the premium users
     */
    public void setPremiumUsers(final List<UserInputData> premiumUsers) {
        this.premiumUsers = premiumUsers;
    }

    /**
     * Gets basic users.
     *
     * @return the basic users
     */
    public List<UserInputData> getBasicUsers() {
        return basicUsers;
    }

    /**
     * Sets basic users.
     *
     * @param basicUsers the basic users
     */
    public void setBasicUsers(final List<UserInputData> basicUsers) {
        this.basicUsers = basicUsers;
    }

    /**
     * Categorize.
     */
    public void categorize() {
        for (UserInputData user : userInput.getUsers()) {
            if (user.getSubscriptionType().equals("PREMIUM")) {
                premiumUsers.add(user);
            } else if (user.getSubscriptionType().equals("BASIC")) {
                basicUsers.add(user);
            }
        }
    }

    /**
     * Initialize premium users premium user.
     *
     * @return the premium user
     */
    public PremiumUser initializePremiumUsers() {
        if (!premiumUsers.isEmpty()) {
            return new PremiumUser(premiumUsers);
        }
        return null;
    }

    /**
     * Initialize basic users basic user.
     *
     * @return the basic user
     */
    public BasicUser initializeBasicUsers() {
        if (!basicUsers.isEmpty()) {
            return new BasicUser(basicUsers);
        }
        return null;
    }
}
