package mypackage;

import fileio.ActionInputData;
import fileio.ActorInputData;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;
import fileio.Writer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Query.
 */
public final class Query {

    private List<ActionInputData> queries;

    /**
     * Instantiates a new Query.
     *
     * @param queries the queries
     */
    public Query(final List<ActionInputData> queries) {
        this.queries = queries;
    }

    /**
     * Gets queries.
     *
     * @return the queries
     */
    public List<ActionInputData> getQueries() {
        return queries;
    }

    /**
     * Sets queries.
     *
     * @param queries the queries
     */
    public void setQueries(final List<ActionInputData> queries) {
        this.queries = queries;
    }

    /**
     * Apply query type json array.
     *
     * Applies the query type by using the input given by the parameters
     * For every query it uses functions from other classes to compute the output
     *
     * @param query       the query
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     * @param serial      the serial
     * @param movie       the movie
     * @param actor       the actor
     * @param fileWriter  the file writer
     * @return the json array
     */
    public JSONArray applyQueryType(final ActionInputData query, final PremiumUser premiumUser,
                                    final BasicUser basicUser, final Serial serial,
                                    final Movie movie, final Actor actor, final Writer fileWriter) {

        JSONArray objectArray = new JSONArray();

        if (query.getObjectType() != null) {
            if (query.getObjectType().equals("actors")) {
                if (query.getCriteria().equals("average")) {
                    movie.setMovieRatings(premiumUser, basicUser);
                    serial.setSerialRatings(premiumUser, basicUser);
                    actor.setAverageFilmRatings(serial, movie);
                    List<ActorInputData> searchedActors = actor.getActorsWithNonZeroRatings();
                    Actor actorsWithNonZeroRatings = new Actor(searchedActors);
                    actorsWithNonZeroRatings.sortByRating(query.getSortType());
                    objectArray
                            .returnAverageActors(actorsWithNonZeroRatings, query.getNumber(), query,
                                    fileWriter);
                } else if (query.getCriteria().equals("awards")) {
                    actor.setAwardsNo();
                    List<ActorInputData> searchedActors = actor.getActorsWithAwards(query);
                    Actor actorsWithAwards = new Actor(searchedActors);
                    actorsWithAwards.sortByAwards(query.getSortType());
                    objectArray.printActors(query, actorsWithAwards, fileWriter);
                } else if (query.getCriteria().equals("filter_description")) {
                    List<ActorInputData> searchedActors =
                            actor.getActorsWithFilterDescription(query);
                    Actor actorsWithFilterDescription = new Actor(searchedActors);
                    actorsWithFilterDescription.sortAlphabetically(query.getSortType());
                    objectArray.printActors(query, actorsWithFilterDescription, fileWriter);
                }
            } else if (query.getObjectType().equals("movies")) {
                if (query.getCriteria().equals("ratings")) {
                    movie.setMovieRatings(premiumUser, basicUser);
                    List<MovieInputData> searchedMovies =
                            movie.getMoviesWithFilterDescription(query);
                    Movie moviesWithFilteredDescription = new Movie(searchedMovies);
                    List<MovieInputData> searchedFavoriteMovies =
                            moviesWithFilteredDescription.eliminateNonRated();
                    Movie ratedMovies = new Movie(searchedFavoriteMovies);
                    ratedMovies.sortByRating(query.getSortType());
                    objectArray.printMovies(query, ratedMovies, query.getNumber(), fileWriter);
                } else if (query.getCriteria().equals("favorite")) {
                    movie.setMovieFavoriteOccurrence(premiumUser, basicUser);
                    List<MovieInputData> searchedMovies =
                            movie.getMoviesWithFilterDescription(query);
                    Movie moviesWithFilteredDescription = new Movie(searchedMovies);
                    List<MovieInputData> searchedFavoriteMovies =
                            moviesWithFilteredDescription.eliminateNonFavorites();
                    Movie favoriteMovies = new Movie(searchedFavoriteMovies);
                    favoriteMovies.sortByFavoriteOccurrence(query.getSortType());
                    objectArray.printMovies(query, favoriteMovies, query.getNumber(), fileWriter);
                } else if (query.getCriteria().equals("longest")) {
                    List<MovieInputData> searchedMovies =
                            movie.getMoviesWithFilterDescription(query);
                    Movie moviesWithFilteredDescription = new Movie(searchedMovies);
                    moviesWithFilteredDescription.sortByDuration(query.getSortType());
                    objectArray.printMovies(query, moviesWithFilteredDescription, query.getNumber(),
                            fileWriter);
                } else if (query.getCriteria().equals("most_viewed")) {
                    movie.setMovieViews(premiumUser, basicUser);
                    List<MovieInputData> searchedMovies =
                            movie.getMoviesWithFilterDescription(query);
                    Movie moviesWithFilteredDescription = new Movie(searchedMovies);
                    List<MovieInputData> searchedViewedMovies =
                            moviesWithFilteredDescription.eliminateNonViewed();
                    Movie viewedMovies = new Movie(searchedViewedMovies);
                    viewedMovies.sortByViews(query.getSortType());
                    objectArray.printMovies(query, viewedMovies, query.getNumber(), fileWriter);
                }
            } else if (query.getObjectType().equals("shows")) {
                if (query.getCriteria().equals("ratings")) {
                    serial.setSerialRatings(premiumUser, basicUser);
                    List<SerialInputData> searchedSerials =
                            serial.getSerialsWithFilterDescription(query);
                    Serial serialsWithFilteredDescription = new Serial(searchedSerials);
                    List<SerialInputData> searchedFavoriteSerials =
                            serialsWithFilteredDescription.eliminateNonRated();
                    Serial ratedSerials = new Serial(searchedFavoriteSerials);
                    ratedSerials.sortByRating(query.getSortType());
                    objectArray.printSerials(query, ratedSerials, query.getNumber(), fileWriter);
                } else if (query.getCriteria().equals("favorite")) {
                    serial.setSerialFavoriteOccurrence(premiumUser, basicUser);
                    List<SerialInputData> searchedSerials =
                            serial.getSerialsWithFilterDescription(query);
                    Serial serialsWithFilteredDescription = new Serial(searchedSerials);
                    List<SerialInputData> searchedFavoriteSerials =
                            serialsWithFilteredDescription.eliminateNonFavorites();
                    Serial favoriteSerials = new Serial(searchedFavoriteSerials);
                    favoriteSerials.sortByFavoriteOccurrence(query.getSortType());
                    objectArray.printSerials(query, favoriteSerials, query.getNumber(), fileWriter);
                } else if (query.getCriteria().equals("longest")) {
                    serial.setSerialDuration();
                    List<SerialInputData> searchedSerials =
                            serial.getSerialsWithFilterDescription(query);
                    Serial serialsWithFilteredDescription = new Serial(searchedSerials);
                    serialsWithFilteredDescription.sortByDuration(query.getSortType());
                    objectArray
                            .printSerials(query, serialsWithFilteredDescription, query.getNumber(),
                                    fileWriter);
                } else if (query.getCriteria().equals("most_viewed")) {
                    serial.setSerialViews(premiumUser, basicUser);
                    List<SerialInputData> searchedSerials =
                            serial.getSerialsWithFilterDescription(query);
                    Serial serialsWithFilteredDescription = new Serial(searchedSerials);
                    List<SerialInputData> searchedViewedSerials =
                            serialsWithFilteredDescription.eliminateNonViewed();
                    Serial viewedSerials = new Serial(searchedViewedSerials);
                    viewedSerials.sortByViews(query.getSortType());
                    objectArray.printSerials(query, viewedSerials, query.getNumber(), fileWriter);
                }
            } else if (query.getObjectType().equals("users")) {
                if (query.getCriteria().equals("num_ratings")) {
                    Set<UserInputData> users = new HashSet<>();
                    users.addAll(premiumUser.getUsers());
                    users.addAll(basicUser.getUsers());
                    PremiumUser allUsers = new PremiumUser(new ArrayList<>(users));
                    List<UserInputData> users2 = allUsers.eliminateNonRaters(allUsers.getUsers());
                    PremiumUser allUsers2 = new PremiumUser(users2);
                    List<UserInputData> users3 =
                            allUsers2.sortByNoGivenRatings(query.getSortType(), users2);
                    PremiumUser allUsers3 = new PremiumUser(users3);
                    objectArray.printUsers(query, allUsers3, query.getNumber(), fileWriter);
                }
            }
        }
        return objectArray;
    }
}
