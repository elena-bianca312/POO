package mypackage;

import entertainment.Season;
import fileio.ActionInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type Serial.
 */
public final class Serial {

    private List<SerialInputData> serials;

    /**
     * Instantiates a new Serial.
     *
     * @param serials the serials
     */
    public Serial(final List<SerialInputData> serials) {
        this.serials = serials;
    }

    /**
     * Gets serials.
     *
     * @return the serials
     */
    public List<SerialInputData> getSerials() {
        return serials;
    }

    /**
     * Sets serials.
     *
     * @param serials the serials
     */
    public void setSerials(final List<SerialInputData> serials) {
        this.serials = serials;
    }

    /**
     * Sets serial order.
     *
     * Iterates through serials and sets their order in the database
     *
     * @param index the index
     */
    public void setSerialOrder(final Integer index) {
        int myIndex = index;
        for (SerialInputData serial : serials) {
            serial.setOrder(myIndex);
            myIndex++;
        }
    }

    /**
     * Compare by order int.
     *
     * Compares serials by their order in the database
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareByOrder(final SerialInputData s1, final SerialInputData s2) {
        return s1.getOrder().compareTo(s2.getOrder());
    }

    /**
     * Compare rating order chain list.
     *
     * Rating chain to have serials sorted by rating (if equal: sorted by order in database)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareRatingOrderChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareByOrder);
        chainList.add(this::compareByRating);
        return chainList;
    }

    /**
     * Sort by order.
     *
     * Sorts serials by order only
     *
     */
    public void sortByOrder() {
        Comparator<SerialInputData> compareByOrder = (SerialInputData s1, SerialInputData s2) ->
                s1.getOrder().compareTo(s2.getOrder());
        Collections.sort(serials, compareByOrder);
    }

    /**
     * Sort by order 2.
     *
     * Sorts serials by rating using the rating-order chain
     *
     */
    public void sortByOrder2() {
        int index = 0;
        for (Comparator<SerialInputData> comparator : this.compareRatingOrderChain()) {
            if (index == 0) {
                Collections.sort(serials, comparator);
                index++;
            } else {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }

    /**
     * Compare favorite order chain list.
     *
     * Favorite chain to have serials sorted by the number of occurrences in user's favorite lists
     * (if equal: sorted by order in database)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareFavoriteOrderChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareByOrder);
        chainList.add(this::compareByFavoriteOccurrence);
        return chainList;
    }

    /**
     * Sort by order 3.
     *
     * Sorts serials by rating using the favorite-order chain
     */
    public void sortByOrder3() {
        int index = 0;
        for (Comparator<SerialInputData> comparator : this.compareFavoriteOrderChain()) {
            if (index == 0) {
                Collections.sort(serials, comparator);
                index++;
            } else {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }

    /**
     * Gets serials with filter description.
     *
     * Iterates through serials and returns a list with the serials
     * who match the key words from the filter description
     *
     * @param query the query
     * @return the serials with filter description
     */
    public List<SerialInputData> getSerialsWithFilterDescription(final ActionInputData query) {
        List<SerialInputData> serialsWithFilterDescription = new ArrayList<>();
        for (SerialInputData serial : serials) {
            boolean ok1 = true;
            boolean ok2 = true;
            if (query.getFilters().get(0) != null) {
                for (String stringYear : query.getFilters().get(0)) {
                    if (stringYear != null) {
                        if (!stringYear.equals(String.valueOf(serial.getYear()))) {
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
                        for (String serialGenre : serial.getGenres()) {
                            if (stringGenre.equals(serialGenre)) {
                                ok3 = true;
                                break;
                            }
                        }
                        ok2 = ok2 && ok3;
                    }

                }
            }
            if (ok1 && ok2) {
                serialsWithFilterDescription.add(serial);
            }
        }
        return serialsWithFilterDescription;
    }

    /**
     * Average season rating double.
     *
     * Sets average rating for a season of a serial
     *
     * -> iterates through all the users
     * -> iterates through the rates shows/serials of all users
     * -> iterates through the seasons of the rated serials
     * -> computes the rating for the season (given as parameter -> findSeason)
     *
     * @param findSeason  the find season
     * @param serial      the serial
     * @param index       the index
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     * @return the double
     */
    public double averageSeasonRating(final Season findSeason, final SerialInputData serial,
                                      final Integer index, final PremiumUser premiumUser,
                                      final BasicUser basicUser) {
        double seasonRating = 0;
        int seasonNumberOfRatings = 0;
        if (premiumUser != null) {
            for (UserInputData user : premiumUser.getUsers()) {
                for (String premiumUserSerial : user.getRatedShows().keySet()) {
                    if (premiumUserSerial.equals(serial.getTitle())) {
                        for (Season season : user.getRatedShows().get(premiumUserSerial)) {
                            if (season.getCurrentSeason() == findSeason.getCurrentSeason()) {
                                seasonRating += season.getRating();
                                seasonNumberOfRatings++;
                            }
                        }
                    }
                }
            }
        }
        if (basicUser != null) {
            for (UserInputData user : basicUser.getUsers()) {
                for (String basicUserSerial : user.getRatedShows().keySet()) {
                    if (basicUserSerial.equals(serial.getTitle())) {
                        for (Season season : user.getRatedShows().get(basicUserSerial)) {
                            if (season.getCurrentSeason() == findSeason.getCurrentSeason()) {
                                seasonRating += season.getRating();
                                seasonNumberOfRatings++;
                            }
                        }
                    }
                }
            }
        }
        if (seasonNumberOfRatings != 0) {
            serial.getSeasons().get(index).setRating(seasonRating / seasonNumberOfRatings);
            return seasonRating / seasonNumberOfRatings;
        } else {
            serial.getSeasons().get(index).setRating(0);
            return 0;
        }
    }

    /**
     * Sets serial ratings.
     *
     * Iterates through serials:
     * -> iterates through seasons for every serial
     * -> computes the serial rating using the rating of its seasons
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setSerialRatings(final PremiumUser premiumUser, final BasicUser basicUser) {
        for (SerialInputData serial : serials) {
            double rating = 0;
            int numberOfRatings = serial.getNumberSeason();
            Integer index = 0;
            for (Season season : serial.getSeasons()) {
                rating += averageSeasonRating(season, serial, index, premiumUser, basicUser);
                index++;
            }
            if (rating != 0) {
                serial.setRating(rating / numberOfRatings);
            } else {
                serial.setRating(rating);
            }
        }
    }

    /**
     * Eliminate non rated list.
     *
     * Returns a list with all the serials that received at least one rating
     *
     * @return the list
     */
    public List<SerialInputData> eliminateNonRated() {
        List<SerialInputData> serialsRated = new ArrayList<>();
        for (SerialInputData serial : serials) {
            if (serial.getRating() != 0) {
                serialsRated.add(serial);
            }
        }
        return serialsRated;
    }

    /**
     * Compare alphabetically int.
     *
     * Compares serials alphabetically
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareAlphabetically(final SerialInputData s1, final SerialInputData s2) {
        return s1.getTitle().compareTo(s2.getTitle());
    }

    /**
     * Compare by rating int.
     *
     * Compares serials by rating
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareByRating(final SerialInputData s1, final SerialInputData s2) {
        return s1.getRating().compareTo(s2.getRating());
    }

    /**
     * Compare rating chain list.
     *
     * Rating chain to have serials sorted by rating (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareRatingChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByRating);
        return chainList;
    }

    /**
     * Sort by rating.
     *
     * Sorts serials by rating using the rating chain
     *
     * @param type the type
     */
    public void sortByRating(final String type) {
        for (Comparator<SerialInputData> comparator : this.compareRatingChain()) {
            if (type.equals("asc")) {
                Collections.sort(serials, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }

    /**
     * Sets serial favorite occurrence.
     *
     * Iterates through serials:
     * -> iterates through all users
     * -> iterates through the favorite lists of all users
     * -> computes the number of occurrences in favorite lists for every serial
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setSerialFavoriteOccurrence(final PremiumUser premiumUser,
                                            final BasicUser basicUser) {
        for (SerialInputData serial : serials) {
            int occurrences = 0;
            if (premiumUser != null) {
                for (UserInputData user : premiumUser.getUsers()) {
                    for (String premiumUserMovie : user.getFavoriteMovies()) {
                        if (premiumUserMovie.equals(serial.getTitle())) {
                            occurrences++;
                        }
                    }
                }
            }
            if (basicUser != null) {
                for (UserInputData user : basicUser.getUsers()) {
                    for (String basicUserMovie : user.getFavoriteMovies()) {
                        if (basicUserMovie.equals(serial.getTitle())) {
                            occurrences++;
                        }
                    }
                }
            }
            serial.setFavoriteOccurrence(occurrences);
        }
    }

    /**
     * Eliminate non favorites list.
     *
     * Returns a list with all the serials that appear at least once in users' favorite lists
     *
     * @return the list
     */
    public List<SerialInputData> eliminateNonFavorites() {
        List<SerialInputData> serialsFavorite = new ArrayList<>();
        for (SerialInputData serial : serials) {
            if (serial.getFavoriteOccurrence() != 0) {
                serialsFavorite.add(serial);
            }
        }
        return serialsFavorite;
    }

    /**
     * Compare by favorite occurrence int.
     *
     * Compares serials by the number of occurrences in users' favorite lists
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareByFavoriteOccurrence(final SerialInputData s1,
                                           final SerialInputData s2) {
        return s1.getFavoriteOccurrence().compareTo(s2.getFavoriteOccurrence());
    }

    /**
     * Compare favorite occurrence chain list.
     *
     * Favorite chain to have serials sorted by favorite occurrences
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareFavoriteOccurrenceChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByFavoriteOccurrence);
        return chainList;
    }

    /**
     * Sort by favorite occurrence.
     *
     * Sorts serials by favorite occurrence using the favorite occurrence chain
     *
     * @param type the type
     */
    public void sortByFavoriteOccurrence(final String type) {
        for (Comparator<SerialInputData> comparator : this.compareFavoriteOccurrenceChain()) {
            if (type.equals("asc")) {
                Collections.sort(serials, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }

    /**
     * Sets serial duration.
     *
     * Iterates through serials:
     * -> iterates through seasons of the serial
     * -> computes the duration of the serial as the sum of the seasons' durations
     */
    public void setSerialDuration() {
        for (SerialInputData serial : serials) {
            int duration = 0;
            for (Season season : serial.getSeasons()) {
                duration += season.getDuration();
            }
            serial.setDuration(duration);
        }
    }

    /**
     * Compare by duration int.
     *
     * Compares serials by duration
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareByDuration(final SerialInputData s1, final SerialInputData s2) {
        return s1.getDuration().compareTo(s2.getDuration());
    }

    /**
     * Compare duration chain list.
     *
     * Duration chain to have serials sorted by duration (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareDurationChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByDuration);
        return chainList;
    }

    /**
     * Sort by duration.
     *
     * Sorts serials by duration using the duration chain
     *
     * @param type the type
     */
    public void sortByDuration(final String type) {
        for (Comparator<SerialInputData> comparator : this.compareDurationChain()) {
            if (type.equals("asc")) {
                Collections.sort(serials, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }

    /**
     * Sets serial views.
     *
     * Iterates through serials:
     * -> iterates through all users
     * -> iterates through the history of all users
     * -> computes the number of views for every serial
     *
     * @param premiumUser the premium user
     * @param basicUser   the basic user
     */
    public void setSerialViews(final PremiumUser premiumUser, final BasicUser basicUser) {
        for (SerialInputData serial : serials) {
            int views = 0;
            if (premiumUser != null) {
                for (UserInputData user : premiumUser.getUsers()) {
                    for (String premiumUserMovie : user.getHistory().keySet()) {
                        if (premiumUserMovie.equals(serial.getTitle())) {
                            views += user.getHistory().get(premiumUserMovie);
                        }
                    }
                }
            }
            if (basicUser != null) {
                for (UserInputData user : basicUser.getUsers()) {
                    for (String basicUserMovie : user.getHistory().keySet()) {
                        if (basicUserMovie.equals(serial.getTitle())) {
                            views += user.getHistory().get(basicUserMovie);
                        }
                    }
                }
            }
            serial.setViews(views);
        }
    }

    /**
     * Eliminate non viewed list.
     *
     * Returns a list with all the serials that have been viewed at least once
     *
     * @return the list
     */
    public List<SerialInputData> eliminateNonViewed() {
        List<SerialInputData> serialsWithViews = new ArrayList<>();
        for (SerialInputData serial : serials) {
            if (serial.getViews() != 0) {
                serialsWithViews.add(serial);
            }
        }
        return serialsWithViews;
    }

    /**
     * Compare by views int.
     *
     * Compares serials by the number of views
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public int compareByViews(final SerialInputData s1, final SerialInputData s2) {
        return s1.getViews().compareTo(s2.getViews());
    }

    /**
     * Compare views chain list.
     *
     * Views chain to have serials sorted by the number of views
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<SerialInputData>> compareViewsChain() {
        List<Comparator<SerialInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByViews);
        return chainList;
    }

    /**
     * Sort by views.
     *
     * Sorts serials by the number of views
     *
     * @param type the type
     */
    public void sortByViews(final String type) {
        for (Comparator<SerialInputData> comparator : this.compareViewsChain()) {
            if (type.equals("asc")) {
                Collections.sort(serials, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(serials, comparator.reversed());
            }
        }
    }
}
