package mypackage;

import entertainment.Season;
import fileio.ActionInputData;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type User.
 */
public abstract class User {

    /**
     * Add to favourites boolean.
     *
     * If a video was viewed, it adds it to favorite list
     *
     * @param user  the user
     * @param movie the movie
     * @return the boolean
     */
    public boolean addToFavourites(final UserInputData user, final String movie) {
        if (user.getHistory().containsKey(movie)) {
            user.getFavoriteMovies().add(movie);
            return true;
        }
        return false;
    }

    /**
     * Already in favourites boolean.
     *
     * Checks if a video is already in the favorite list
     *
     * @param user  the user
     * @param movie the movie
     * @return the boolean
     */
    public boolean alreadyInFavourites(final UserInputData user, final String movie) {
        return user.getFavoriteMovies().contains(movie);
    }

    /**
     * Add to viewed.
     *
     * Adds a video to the viewed list
     *
     * @param user  the user
     * @param movie the movie
     */
    public void addToViewed(final UserInputData user, final String movie) {
        for (String key : user.getHistory().keySet()) {
            if (key.equals(movie)) {
                int number = user.getHistory().get(key);
                user.getHistory().put(key, number + 1);
                return;
            }
        }
        user.getHistory().put(movie, 1);
    }

    /**
     * Is in history boolean.
     *
     * Checks if a movie is in the history/is viewed
     *
     * @param user  the user
     * @param movie the movie
     * @return the boolean
     */
    public boolean isInHistory(final UserInputData user, final String movie) {
        return user.getHistory().containsKey(movie);
    }

    /**
     * Eliminate non raters list.
     *
     * Returns a list of all the users who have given at least one rating
     *
     * @param list the list
     * @return the list
     */
    public List<UserInputData> eliminateNonRaters(final List<UserInputData> list) {
        List<UserInputData> newList = new ArrayList<>();
        for (UserInputData user : list) {
            if (user.getNoGivenRatings() != 0) {
                newList.add(user);
            }
        }
        return newList;
    }

    /**
     * Rate video boolean.
     *
     * Rates a video
     * Serial:
     * -> iterates through all the rated serials
     *      -> iterates through all the seasons of the serial
     *           -> if the season was already rated -> fail, else rate season
     *           -> season not found -> adds season with given rating field initialized
     *           -> serial not found -> adds serial with season initialized (see above)
     * -> iterates through all the rated movies
     *          -> if the movie was already rated -> fail, else rate movie
     *
     * @param user         the user
     * @param command      the command
     * @param movie        the movie
     * @param seasonNumber the season number
     * @return the boolean
     */
    public boolean rateVideo(final UserInputData user, final ActionInputData command,
                             final String movie, final Integer seasonNumber) {
        if (command.getSeasonNumber() != 0) {
            for (String name : user.getRatedShows().keySet()) {
                if (name.equals(movie)) {
                    for (Season season : user.getRatedShows().get(name)) {
                        if (season.getCurrentSeason() == seasonNumber) {
                            if (season.getRating() == 0) {
                                season.setRating(command.getGrade());
                                user.setNoGivenRatings(user.getNoGivenRatings() + 1);
                                return true;
                            }
                            return false; //already rated
                        }
                    }
                    //season not found
                    Season newSeason = new Season(seasonNumber, 0);
                    newSeason.setRating(command.getGrade());
                    user.getRatedShows().get(movie).add(newSeason);
                    user.setNoGivenRatings(user.getNoGivenRatings() + 1);
                    return true;
                }
            }
            //serial not found
            Season newSeason = new Season(seasonNumber, 0);
            newSeason.setRating(command.getGrade());
            List<Season> newShow = new ArrayList<>();
            newShow.add(newSeason);
            user.getRatedShows().put(movie, newShow);
            user.setNoGivenRatings(user.getNoGivenRatings() + 1);
            return true;
        }
        //film
        if (!user.getRatedMovies().containsKey(movie)) {
            user.getRatedMovies().put(movie, command.getGrade());
            user.setNoGivenRatings(user.getNoGivenRatings() + 1);
            return true;
        }
        return false;
    }

    /**
     * Compare by no given ratings int.
     *
     * Compares users by the number of given ratings
     *
     * @param u1 the u 1
     * @param u2 the u 2
     * @return the int
     */
    public int compareByNoGivenRatings(final UserInputData u1, final UserInputData u2) {
        return u1.getNoGivenRatings().compareTo(u2.getNoGivenRatings());
    }

    /**
     * Compare alphabetically int.
     *
     * Compares users alphabetically
     *
     * @param u1 the u 1
     * @param u2 the u 2
     * @return the int
     */
    public int compareAlphabetically(final UserInputData u1, final UserInputData u2) {
        return u1.getUsername().compareTo(u2.getUsername());
    }

    /**
     * Compare no given ratings list.
     *
     * Rating chain to have users sorted by the number of ratings given
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<UserInputData>> compareNoGivenRatings() {
        List<Comparator<UserInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByNoGivenRatings);
        return chainList;
    }

    /**
     * Sort by no given ratings list.
     *
     * Sorts users by the number of given ratings
     *
     * @param type  the type
     * @param users the users
     * @return the list
     */
    public List<UserInputData> sortByNoGivenRatings(final String type,
                                                    final List<UserInputData> users) {
        for (Comparator<UserInputData> comparator : this.compareNoGivenRatings()) {
            if (type.equals("asc")) {
                Collections.sort(users, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(users, comparator.reversed());
            }
        }
        return users;
    }

    /**
     * Gets basic recommendation.
     *
     * Iterates through all movies, then through all serials
     * -> iterates through the user's history
     * -> if we find a movie/serial not viewed -> save it
     * -> compare the ratings of the 2
     * -> return the title
     *
     * @param user    the user
     * @param movies  the movies
     * @param serials the serials
     * @param type    the type
     * @return the basic recommendation
     */
    public String getStandardRecommendation(final UserInputData user,
                                            final List<MovieInputData> movies,
                                            final List<SerialInputData> serials,
                                            final String type) {
        String nameMovie = "";
        String nameSerial = "";
        MovieInputData recMovie = null;
        SerialInputData recSerial = null;
        for (MovieInputData movie : movies) {
            boolean seen = false;
            for (String film : user.getHistory().keySet()) {
                if (film.equals(movie.getTitle())) {
                    seen = true;
                }
            }
            if (!seen) {
                nameMovie = movie.getTitle();
                recMovie = movie;
                break;
            }
        }
        for (SerialInputData serial : serials) {
            boolean seen = false;
            for (String film : user.getHistory().keySet()) {
                if (film.equals(serial.getTitle())) {
                    seen = true;
                }
            }
            if (!seen) {
                nameSerial = serial.getTitle();
                recSerial = serial;
                break;
            }
        }
        if (type.equals("best_unseen") || type.equals("favorite")) {
            if (recSerial != null) {
                if (recMovie != null) {
                    if (recSerial.getRating() > recMovie.getRating()) {
                        return nameSerial;
                    }
                    return nameMovie;
                }
                return nameSerial;
            }
            return nameMovie;
        }
        if (recMovie != null) {
            return nameMovie;
        }
        return nameSerial;
    }


    /**
     * Gets standard recommendation 2.
     *
     * Iterates through all movies, then through all serials
     * -> iterates through the user's history
     * -> if we find a movie/serial not viewed -> return the title
     *
     * @param user    the user
     * @param movies  the movies
     * @param serials the serials
     * @return the standard recommendation 2
     */
    public String getStandardRecommendation2(final UserInputData user,
                                             final List<MovieInputData> movies,
                                             final List<SerialInputData> serials) {
        boolean seen;
        for (MovieInputData movie : movies) {
            seen = false;
            for (String film : user.getHistory().keySet()) {
                if (film.equals(movie.getTitle())) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                return movie.getTitle();
            }
        }
        for (SerialInputData serial : serials) {
            seen = false;
            for (String film : user.getHistory().keySet()) {
                if (film.equals(serial.getTitle())) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                return serial.getTitle();
            }
        }
        return "";
    }

    /**
     * Sets order.
     *
     * Sets order of movies and serials in the database
     *
     * @param movies  the movies
     * @param serials the serials
     */
    public void setOrder(final List<MovieInputData> movies, final List<SerialInputData> serials) {
        Integer index = 0;
        for (MovieInputData movie : movies) {
            movie.setOrder(index);
            index++;
        }
        for (SerialInputData serial : serials) {
            serial.setOrder(index);
            index++;
        }
    }

    /**
     * Gets popular recommendation.
     *
     * Generates a hashmap of the most popular genres sorted in descending order
     * (popular criteria: the number of viewed videos from that genre)
     *      -> iterates through all movies and all serials
     *      -> increment number of views for that genre
     * Iterates through genre hashmap
     *      -> iterates through the user's history
     *      -> find a not viewed video
     *      -> return video title
     *
     * @param user    the user
     * @param movies  the movies
     * @param serials the serials
     * @return the popular recommendation
     */
    public String getPopularRecommendation(final UserInputData user,
                                           final List<MovieInputData> movies,
                                           final List<SerialInputData> serials) {
        String message = "";
        HashMap<String, Integer> popularGenres = new HashMap<>();
        for (MovieInputData movie : movies) {
            for (String genres : movie.getGenres()) {
                Integer count = 0;
                if (popularGenres.get(genres) != null) {
                    count = popularGenres.get(genres);
                }
                popularGenres.put(genres, count + movie.getViews());
            }
        }
        for (SerialInputData serial : serials) {
            for (String genres : serial.getGenres()) {
                Integer count = 0;
                if (popularGenres.get(genres) != null) {
                    count = popularGenres.get(genres);
                }
                popularGenres.put(genres, count + serial.getViews());
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(popularGenres.entrySet());

        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return (o2.getKey()).compareTo(o1.getKey());
            }
            return (o2.getValue()).compareTo(o1.getValue());
        });

        HashMap<String, Integer> aux = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> cnt : list) {
            aux.put(cnt.getKey(), cnt.getValue());
        }
        popularGenres = aux;

        for (String genre : popularGenres.keySet()) {
            for (MovieInputData movie : movies) {
                boolean match = false;
                for (String genres : movie.getGenres()) {
                    if (genres.equals(genre)) {
                        match = true;
                        break;
                    }
                }
                if (match) {
                    boolean match2 = false;
                    for (String film : user.getHistory().keySet()) {
                        if (film.equals(movie.getTitle())) {
                            match2 = true;
                        }
                    }
                    if (!match2) {
                        return movie.getTitle();
                    }
                }
            }
            for (SerialInputData serial : serials) {
                boolean match = false;
                for (String genres : serial.getGenres()) {
                    if (genres.equals(genre)) {
                        match = true;
                        break;
                    }
                }
                if (match) {
                    boolean match2 = false;
                    for (String film : user.getHistory().keySet()) {
                        if (film.equals(serial.getTitle())) {
                            match2 = true;
                        }
                    }
                    if (!match2) {
                        return serial.getTitle();
                    }
                }
            }
        }
        return message;
    }

    /**
     * Gets search recommendation.
     *
     * Computes a list with all the videos from a genre given as parameter
     * Sort found videos and return
     *
     * @param user    the user
     * @param movies  the movies
     * @param serials the serials
     * @param genre   the genre
     * @return the search recommendation
     */
    public List<MovieInputData> getSearchRecommendation(final UserInputData user,
                                                        final List<MovieInputData> movies,
                                                        final List<SerialInputData> serials,
                                                        final String genre) {
        List<MovieInputData> videos = new ArrayList<>();
        for (MovieInputData movie : movies) {
            for (String movieGenre : movie.getGenres()) {
                if (movieGenre.equals(genre)) {
                    videos.add(movie);
                    break;
                }
            }
        }
        for (SerialInputData serial : serials) {
            for (String serialGenre : serial.getGenres()) {
                if (serialGenre.equals(genre)) {
                    MovieInputData newVideo = new MovieInputData(serial.getTitle(),
                            serial.getCast(), serial.getGenres(), serial.getYear(), 0);
                    newVideo.setRating(serial.getRating());
                    videos.add(newVideo);
                    break;
                }
            }
        }

        List<MovieInputData> videosNotViewed = new ArrayList<>();
        for (MovieInputData movie : videos) {
            boolean seen = false;
            for (String name : user.getHistory().keySet()) {
                if (name.equals(movie.getTitle())) {
                    seen = true;
                }
            }
            if (!seen) {
                videosNotViewed.add(movie);
            }
        }

        Movie searchedMovies = new Movie(videosNotViewed);
        searchedMovies.sortByRating("asc");
        return searchedMovies.getMovies();
    }

}
