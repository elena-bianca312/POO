package fileio;

import entertainment.Season;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Information about an user, retrieved from parsing the input test files
 * <p>
 * DO NOT MODIFY
 */
public final class UserInputData {
    /**
     * User's username
     */
    private final String username;
    /**
     * Subscription Type
     */
    private final String subscriptionType;
    /**
     * The history of the movies seen
     */
    private final Map<String, Integer> history;
    /**
     * Movies added to favorites
     */
    private final ArrayList<String> favoriteMovies;

    /////////////////////////////////////////////

    // hashmap with show name and show season number -> add rating
    // to rating field in season
    private HashMap<String, List<Season>> ratedShows = new HashMap<>();

    private HashMap<String, Double> ratedMovies = new HashMap<>();

    private Integer noGivenRatings = 0;

    private Integer premium = 0;

    public UserInputData(final String username, final String subscriptionType,
                         final Map<String, Integer> history,
                         final ArrayList<String> favoriteMovies) {
        this.username = username;
        this.subscriptionType = subscriptionType;
        this.favoriteMovies = favoriteMovies;
        this.history = history;
    }

    public HashMap<String, List<Season>> getRatedShows() {
        return ratedShows;
    }

    public void setRatedShows(final HashMap<String, List<Season>> ratedShows) {
        this.ratedShows = ratedShows;
    }

    public HashMap<String, Double> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(final HashMap<String, Double> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public Integer getNoGivenRatings() {
        return noGivenRatings;
    }

    public void setNoGivenRatings(final Integer noGivenRatings) {
        this.noGivenRatings = noGivenRatings;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(final Integer premium) {
        this.premium = premium;
    }

    /////////////////////////////////////////////

    public String getUsername() {
        return username;
    }

    public Map<String, Integer> getHistory() {
        return history;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public ArrayList<String> getFavoriteMovies() {
        return favoriteMovies;
    }

    @Override
    public String toString() {
        return "UserInputData{" + "username='"
                + username + '\'' + ", subscriptionType='"
                + subscriptionType + '\'' + ", history="
                + history + ", favoriteMovies="
                + favoriteMovies + '}';
    }
}
