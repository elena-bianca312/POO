package mypackage;

import fileio.UserInputData;

import java.util.List;

/**
 * The type Basic user.
 */
public final class BasicUser extends User {

    private List<UserInputData> users;

    /**
     * Instantiates a new Basic user.
     *
     * @param users the users
     */
    public BasicUser(final List<UserInputData> users) {
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
