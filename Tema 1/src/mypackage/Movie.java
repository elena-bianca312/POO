package mypackage;

import fileio.ActionInputData;
import fileio.MovieInputData;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type Movie.
 */
public final class Movie {

    private List<MovieInputData> movies;

    /**
     * Instantiates a new Movie.
     *
     * @param movies the movies
     */
    public Movie(final List<MovieInputData> movies) {
        this.movies = movies;
    }

    /**
     * Gets movies.
     *
     * @return the movies
     */
    public List<MovieInputData> getMovies() {
        return movies;
    }

    /**
     * Sets movies.
     *
     * @param movies the movies
     */
    public void setMovies(final List<MovieInputData> movies) {
        this.movies = movies;
    }

    /**
     * Sets movie order.
     *
     * Iterates through movies and sets their order in the database
     *
     * @return the movie order
     */
    public Integer setMovieOrder() {
        Integer index = 0;
        for (MovieInputData movie : movies) {
            movie.setOrder(index);
            index++;
        }
        return index;
    }

    /**
     * Compare by order int.
     *
     * Compares movies by their order in the database
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareByOrder(final MovieInputData m1, final MovieInputData m2) {
        return m1.getOrder().compareTo(m2.getOrder());
    }

    /**
     * Compare rating order chain list.
     *
     * Rating chain to have movies sorted by rating (if equal: sorted by order in database)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareRatingOrderChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareByOrder);
        chainList.add(this::compareByRating);
        return chainList;
    }

    /**
     * Sort by order.
     *
     * Sorts movies by order only
     *
     */
    public void sortByOrder() {
        Comparator<MovieInputData> compareByOrder = (MovieInputData m1, MovieInputData m2) ->
                m1.getOrder().compareTo(m2.getOrder());
        Collections.sort(movies, compareByOrder);
    }

    /**
     * Sort by order 2.
     *
     * Sorts movies by rating using the rating-order chain
     *
     */
    public void sortByOrder2() {
        int index = 0;
        for (Comparator<MovieInputData> comparator : this.compareRatingOrderChain()) {
            if (index == 0) {
                Collections.sort(movies, comparator);
                index++;
            } else {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

    /**
     * Compare favorite order chain list.
     *
     * Favorite chain to have movies sorted by the number of occurrences in user's favorite lists
     * (if equal: sorted by order in database)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareFavoriteOrderChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareByOrder);
        chainList.add(this::compareByFavoriteOccurrence);
        return chainList;
    }

    /**
     * Sort by order 3.
     *
     * Sorts movies by rating using the favorite-order chain
     */
    public void sortByOrder3() {
        int index = 0;
        for (Comparator<MovieInputData> comparator : this.compareFavoriteOrderChain()) {
            if (index == 0) {
                Collections.sort(movies, comparator);
                index++;
            } else {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

    /**
     * Gets movies with filter description.
     *
     * Iterates through movies and returns a list with the movies
     * who match the key words from the filter description
     *
     * @param query the query
     * @return the movies with filter description
     */
    public List<MovieInputData> getMoviesWithFilterDescription(final ActionInputData query) {
        List<MovieInputData> moviesWithFilterDescription = new ArrayList<>();
        for (MovieInputData movie : movies) {
            boolean ok1 = true;
            boolean ok2 = true;
            if (query.getFilters().get(0) != null) {
                for (String stringYear : query.getFilters().get(0)) {
                    if (stringYear != null) {
                        if (!stringYear.equals(String.valueOf(movie.getYear()))) {
                            ok1 = false;
                            break;
                        }
                    }
                }
            }
            boolean ok3;
            if (query.getFilters().get(1) != null) {
                for (String stringGenre : query.getFilters().get(1)) {
                    if (stringGenre != null) {
                        ok3 = false;
                        for (String movieGenre : movie.getGenres()) {
                            if (stringGenre.equals(movieGenre)) {
                                ok3 = true;
                                break;
                            }
                        }
                        ok2 = ok2 && ok3;
                    }
                }
            }
            if (ok1 && ok2) {
                moviesWithFilterDescription.add(movie);
            }
        }
        return moviesWithFilterDescription;
    }


    /**
     * Sets movie ratings.
     *
     * Iterates through movies:
     * -> iterates through all users
     * -> iterates through the rated movies of all users
     * -> computes the rating for every movie
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setMovieRatings(final PremiumUser premiumUser, final BasicUser basicUser) {
        for (MovieInputData movie : movies) {
            double rating = 0;
            int numberOfRatings = 0;
            if (premiumUser != null) {
                for (UserInputData user : premiumUser.getUsers()) {
                    for (String premiumUserMovie : user.getRatedMovies().keySet()) {
                        if (premiumUserMovie.equals(movie.getTitle())) {
                            rating += user.getRatedMovies().get(premiumUserMovie);
                            numberOfRatings++;
                        }
                    }
                }
            }
            if (basicUser != null) {
                for (UserInputData user : basicUser.getUsers()) {
                    for (String basicUserMovie : user.getRatedMovies().keySet()) {
                        if (basicUserMovie.equals(movie.getTitle())) {
                            rating += user.getRatedMovies().get(basicUserMovie);
                            numberOfRatings++;
                        }
                    }
                }
            }
            if (numberOfRatings != 0) {
                movie.setRating(rating / numberOfRatings);
            } else {
                movie.setRating(rating);
            }
        }
    }

    /**
     * Eliminate non rated list.
     *
     * Returns a list with all the movies that received at least one rating
     *
     * @return the list
     */
    public List<MovieInputData> eliminateNonRated() {
        List<MovieInputData> moviesRated = new ArrayList<>();
        for (MovieInputData movie : movies) {
            if (movie.getRating() != 0) {
                moviesRated.add(movie);
            }
        }
        return moviesRated;
    }

    /**
     * Compare alphabetically int.
     *
     * Compares movies alphabetically
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareAlphabetically(final MovieInputData m1, final MovieInputData m2) {
        return m1.getTitle().compareTo(m2.getTitle());
    }

    /**
     * Compare by rating int.
     *
     * Compares movies by rating
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareByRating(final MovieInputData m1, final MovieInputData m2) {
        return m1.getRating().compareTo(m2.getRating());
    }

    /**
     * Compare rating chain list.
     *
     * Rating chain to have movies sorted by rating (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareRatingChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByRating);
        return chainList;
    }

    /**
     * Sort by rating.
     *
     * Sorts movies by rating using the rating chain
     *
     * @param type the type
     */
    public void sortByRating(final String type) {
        for (Comparator<MovieInputData> comparator : this.compareRatingChain()) {
            if (type.equals("asc")) {
                Collections.sort(movies, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

    /**
     * Sets movie favorite occurrence.
     *
     * Iterates through movies:
     * -> iterates through all users
     * -> iterates through the favorite lists of all users
     * -> computes the number of occurrences in favorite lists for every movie
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setMovieFavoriteOccurrence(final PremiumUser premiumUser,
                                           final BasicUser basicUser) {
        for (MovieInputData movie : movies) {
            int occurrences = 0;
            if (premiumUser != null) {
                for (UserInputData user : premiumUser.getUsers()) {
                    for (String premiumUserMovie : user.getFavoriteMovies()) {
                        if (premiumUserMovie.equals(movie.getTitle())) {
                            occurrences++;
                        }
                    }
                }
            }
            if (basicUser != null) {
                for (UserInputData user : basicUser.getUsers()) {
                    for (String basicUserMovie : user.getFavoriteMovies()) {
                        if (basicUserMovie.equals(movie.getTitle())) {
                            occurrences++;
                        }
                    }
                }
            }
            movie.setFavoriteOccurrence(occurrences);
        }
    }

    /**
     * Eliminate non favorites list.
     *
     * Returns a list with all the movies that appear at least once in users' favorite lists
     *
     * @return the list
     */
    public List<MovieInputData> eliminateNonFavorites() {
        List<MovieInputData> moviesFavorite = new ArrayList<>();
        for (MovieInputData movie : movies) {
            if (movie.getFavoriteOccurrence() != 0) {
                moviesFavorite.add(movie);
            }
        }
        return moviesFavorite;
    }

    /**
     * Compare by favorite occurrence int.
     *
     * Compares movies by the number of occurrences in users' favorite lists
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareByFavoriteOccurrence(final MovieInputData m1, final MovieInputData m2) {
        return m1.getFavoriteOccurrence().compareTo(m2.getFavoriteOccurrence());
    }

    /**
     * Compare favorite occurrence chain list.
     *
     * Favorite chain to have movies sorted by favorite occurrences
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareFavoriteOccurrenceChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByFavoriteOccurrence);
        return chainList;
    }

    /**
     * Sort by favorite occurrence.
     *
     * Sorts movies by favorite occurrence using the favorite occurrence chain
     *
     * @param type the type
     */
    public void sortByFavoriteOccurrence(final String type) {
        for (Comparator<MovieInputData> comparator : this.compareFavoriteOccurrenceChain()) {
            if (type.equals("asc")) {
                Collections.sort(movies, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

    /**
     * Compare by duration int.
     *
     * Compares movies by duration
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareByDuration(final MovieInputData m1, final MovieInputData m2) {
        return m1.getDuration().compareTo(m2.getDuration());
    }

    /**
     * Compare duration chain list.
     *
     * Duration chain to have movies sorted by duration (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareDurationChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByDuration);
        return chainList;
    }

    /**
     * Sort by duration.
     *
     * Sorts movies by duration using the duration chain
     *
     * @param type the type
     */
    public void sortByDuration(final String type) {
        for (Comparator<MovieInputData> comparator : this.compareDurationChain()) {
            if (type.equals("asc")) {
                Collections.sort(movies, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

    /**
     * Sets movie views.
     *
     * Iterates through movies:
     * -> iterates through all users
     * -> iterates through the history of all users
     * -> computes the number of views for every movie
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setMovieViews(final PremiumUser premiumUser, final BasicUser basicUser) {
        for (MovieInputData movie : movies) {
            int views = 0;
            if (premiumUser != null) {
                for (UserInputData user : premiumUser.getUsers()) {
                    for (String premiumUserMovie : user.getHistory().keySet()) {
                        if (premiumUserMovie.equals(movie.getTitle())) {
                            views += user.getHistory().get(premiumUserMovie);
                        }
                    }
                }
            }
            if (basicUser != null) {
                for (UserInputData user : basicUser.getUsers()) {
                    for (String basicUserMovie : user.getHistory().keySet()) {
                        if (basicUserMovie.equals(movie.getTitle())) {
                            views += user.getHistory().get(basicUserMovie);
                        }
                    }
                }
            }
            movie.setViews(views);
        }
    }

    /**
     * Eliminate non viewed list.
     *
     * Returns a list with all the movies that have been viewed at least once
     *
     * @return the list
     */
    public List<MovieInputData> eliminateNonViewed() {
        List<MovieInputData> moviesWithViews = new ArrayList<>();
        for (MovieInputData movie : movies) {
            if (movie.getViews() != 0) {
                moviesWithViews.add(movie);
            }
        }
        return moviesWithViews;
    }

    /**
     * Compare by views int.
     *
     * Compares movies by the number of views
     *
     * @param m1 the m 1
     * @param m2 the m 2
     * @return the int
     */
    public int compareByViews(final MovieInputData m1, final MovieInputData m2) {
        return m1.getViews().compareTo(m2.getViews());
    }

    /**
     * Compare views chain list.
     *
     * Views chain to have movies sorted by the number of views
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<MovieInputData>> compareViewsChain() {
        List<Comparator<MovieInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByViews);
        return chainList;
    }

    /**
     * Sort by views.
     *
     * Sorts movies by the number of views
     *
     * @param type the type
     */
    public void sortByViews(final String type) {
        for (Comparator<MovieInputData> comparator : this.compareViewsChain()) {
            if (type.equals("asc")) {
                Collections.sort(movies, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(movies, comparator.reversed());
            }
        }
    }

}
