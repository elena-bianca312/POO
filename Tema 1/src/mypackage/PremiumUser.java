package mypackage;

import fileio.UserInputData;

import java.util.List;

/**
 * The type Premium user.
 */
public final class PremiumUser extends User {

    private List<UserInputData> users;

    /**
     * Instantiates a new Premium user.
     *
     * @param users the users
     */
    public PremiumUser(final List<UserInputData> users) {
        this.users = users;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<UserInputData> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(final List<UserInputData> users) {
        this.users = users;
    }

}
