package mypackage;

import fileio.ActionInputData;
import fileio.MovieInputData;
import fileio.UserInputData;
import fileio.Writer;

import java.util.List;

/**
 * The type Recommendation.
 */
public final class Recommendation {

    private List<ActionInputData> recommendations;

    /**
     * Instantiates a new Recommendation.
     *
     * @param recommendations the recommendations
     */
    public Recommendation(final List<ActionInputData> recommendations) {
        this.recommendations = recommendations;
    }

    /**
     * Gets recommendations.
     *
     * @return the recommendations
     */
    public List<ActionInputData> getRecommendations() {
        return recommendations;
    }

    /**
     * Sets recommendations.
     *
     * @param recommendations the recommendations
     */
    public void setRecommendations(final List<ActionInputData> recommendations) {
        this.recommendations = recommendations;
    }

    /**
     * Apply recommendation type json array.
     *
     * Applies the recommendation type by using the input given by the parameters.
     * For every recommendation,
     * it identifies the user who requested the recommendation -> searchUser
     * For every recommendation it uses functions from other classes to compute the output
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     * @param serial      the serial
     * @param movie       the movie
     * @param fileWriter  the file writer
     * @return the json array
     */
    public JSONArray applyRecommendationType(final ActionInputData recommendation,
                                             final PremiumUser premiumUser,
                                             final BasicUser basicUser, final Serial serial,
                                             final Movie movie, final Writer fileWriter) {

        JSONArray objectArray = new JSONArray();

        UserInputData searchUser = new UserInputData("", "", null, null);
        if (premiumUser != null) {
            for (UserInputData user : premiumUser.getUsers()) {
                if (user.getUsername().equals(recommendation.getUsername())) {
                    searchUser = user;
                    searchUser.setPremium(1);
                }
            }
        }
        if (basicUser != null) {
            for (UserInputData user : basicUser.getUsers()) {
                if (user.getUsername().equals(recommendation.getUsername())) {
                    searchUser = user;
                }
            }
        }

        if (recommendation.getType() != null) {
            if (recommendation.getType().equals("standard")) {
                String message = "";
                if (premiumUser != null) {
                    message = premiumUser.getStandardRecommendation2(searchUser, movie.getMovies(),
                            serial.getSerials());
                } else if (basicUser != null) {
                    message = basicUser.getStandardRecommendation2(searchUser, movie.getMovies(),
                            serial.getSerials());
                }
                objectArray.printStandardRecommendations(recommendation, message,
                        fileWriter);
            } else if (recommendation.getType().equals("best_unseen")) {
                movie.setMovieRatings(premiumUser, basicUser);
                serial.setSerialRatings(premiumUser, basicUser);
                movie.sortByOrder2();
                serial.sortByOrder2();
                String message = "";
                if (premiumUser != null) {
                    message = premiumUser.getStandardRecommendation(searchUser, movie.getMovies(),
                            serial.getSerials(), "best_unseen");
                } else if (basicUser != null) {
                    message = basicUser.getStandardRecommendation(searchUser, movie.getMovies(),
                            serial.getSerials(), "best_unseen");
                }
                objectArray.printBestUnseenRecommendations(recommendation, message, fileWriter);
            } else if (recommendation.getType().equals("popular")) {
                String message = "";
                movie.setMovieViews(premiumUser, basicUser);
                serial.setSerialViews(premiumUser, basicUser);
                if (premiumUser != null && (searchUser.getPremium() == 1)) {
                    message = premiumUser
                            .getPopularRecommendation(searchUser, movie.getMovies(),
                                    serial.getSerials());
                }
                objectArray.printPopularRecommendations(recommendation, message, fileWriter);
            } else if (recommendation.getType().equals("favorite")) {
                movie.setMovieFavoriteOccurrence(premiumUser, basicUser);
                serial.setSerialFavoriteOccurrence(premiumUser, basicUser);
                movie.sortByOrder3();
                serial.sortByOrder3();
                String message = "";
                if (premiumUser != null && (searchUser.getPremium() == 1)) {
                    message = premiumUser.getStandardRecommendation(searchUser, movie.getMovies(),
                            serial.getSerials(), "favorite");
                }
                objectArray.printFavoriteRecommendations(recommendation, message, fileWriter);
            } else if (recommendation.getType().equals("search")) {
                if (premiumUser != null && (searchUser.getPremium() == 1)) {
                    List<MovieInputData> videos =
                            premiumUser.getSearchRecommendation(searchUser, movie.getMovies(),
                                    serial.getSerials(), recommendation.getGenre());
                    objectArray.printSearchRecommendations(recommendation, videos, fileWriter);
                }
            }
        }
        return objectArray;
    }
}
