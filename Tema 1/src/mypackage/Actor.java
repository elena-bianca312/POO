package mypackage;

import actor.ActorsAwards;
import fileio.ActionInputData;
import fileio.ActorInputData;
import fileio.MovieInputData;
import fileio.SerialInputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type Actor.
 */
public final class Actor {

    private List<ActorInputData> actors;

    /**
     * Instantiates a new Actor.
     *
     * @param actors the actors
     */
    public Actor(final List<ActorInputData> actors) {
        this.actors = actors;
    }

    /**
     * Gets actors.
     *
     * @return the actors
     */
    public List<ActorInputData> getActors() {
        return actors;
    }

    /**
     * Sets actors.
     *
     * @param actors the actors
     */
    public void setActors(final List<ActorInputData> actors) {
        this.actors = actors;
    }

    /**
     * Sets average film ratings.
     *
     * Iterates through actors:
     * -> iterates through filmography for every actor
     * -> iterates through serials and movies
     * -> if we find a match that was rated, we add its rating
     *      to the sum and increment the totalReviews cnt
     * -> computes average rating for every actor
     *
     * @param serial the serial
     * @param movie  the movie
     */
    public void setAverageFilmRatings(final Serial serial, final Movie movie) {
        double averageRating;
        Integer totalReviews;
        for (ActorInputData actor : actors) {
            averageRating = 0;
            totalReviews = 0;
            for (String name : actor.getFilmography()) {
                if (serial != null) {
                    for (SerialInputData findSerial : serial.getSerials()) {
                        if (findSerial.getTitle().equals(name)) {
                            if (findSerial.getRating() != 0) {
                                averageRating += findSerial.getRating();
                                totalReviews++;
                            }
                        }
                    }
                }
                if (movie != null) {
                    for (MovieInputData findMovie : movie.getMovies()) {
                        if (findMovie.getTitle().equals(name)) {
                            if (findMovie.getRating() != 0) {
                                averageRating += findMovie.getRating();
                                totalReviews++;
                            }
                        }
                    }
                }
            }
            if (totalReviews != 0) {
                actor.setRating(averageRating / totalReviews);
            } else {
                actor.setRating(averageRating);
            }
        }
    }

    /**
     * Gets actors with non zero ratings.
     *
     * Iterates through actors and returns a list with the actors
     * whose ratings are != 0
     *
     * @return the actors with non zero ratings
     */
    public List<ActorInputData> getActorsWithNonZeroRatings() {
        List<ActorInputData> actorsWithNonZeroRatings = new ArrayList<>();
        for (ActorInputData actor : actors) {
            if (actor.getRating() != 0) {
                actorsWithNonZeroRatings.add(actor);
            }
        }
        return actorsWithNonZeroRatings;
    }

    /**
     * Compare by rating int.
     *
     * Compares actors by rating
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @return the int
     */
    public int compareByRating(final ActorInputData a1, final ActorInputData a2) {
        return a1.getRating().compareTo(a2.getRating());
    }

    /**
     * Compare rating chain list.
     *
     * Rating chain to have actors sorted by rating (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<ActorInputData>> compareRatingChain() {
        List<Comparator<ActorInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByRating);
        return chainList;
    }

    /**
     * Sort by rating.
     *
     * Sorts actors by rating using the rating chain
     *
     * @param type the type
     */
    public void sortByRating(final String type) {
        for (Comparator<ActorInputData> comparator : this.compareRatingChain()) {
            if (type.equals("asc")) {
                Collections.sort(actors, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(actors, comparator.reversed());
            }
        }
    }

    /**
     * Sets awards no.
     *
     * Iterates through actors:
     * For every actors it computes and sets the total number of awards received
     */
    public void setAwardsNo() {
        for (ActorInputData actor : actors) {
            int number = 0;
            for (ActorsAwards award : actor.getAwards().keySet()) {
                number += actor.getAwards().get(award);
            }
            actor.setAwardsNo(number);
        }
    }

    /**
     * Gets actors with awards.
     *
     * Iterates through actors and returns a list with the actors
     * who received the awards mentioned in the filters
     *
     * @param query the query
     * @return the actors with awards
     */
    public List<ActorInputData> getActorsWithAwards(final ActionInputData query) {
        List<ActorInputData> actorsWithAwards = new ArrayList<>();
        for (ActorInputData actor : actors) {
            boolean ok1 = true;
            for (String award : query.getFilters().get(query.getFilters().size() - 1)) {
                boolean ok2 = false;
                for (ActorsAwards actAward : actor.getAwards().keySet()) {
                    if (actAward.name().equals(award)) {
                        ok2 = true;
                    }
                }
                ok1 = ok1 && ok2;
            }
            if (ok1) {
                actorsWithAwards.add(actor);
            }
        }
        return actorsWithAwards;
    }

    /**
     * Compare alphabetically int.
     *
     * Compares actors alphabetically
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @return the int
     */
    public int compareAlphabetically(final ActorInputData a1, final ActorInputData a2) {
        return a1.getName().compareTo(a2.getName());
    }

    /**
     * Compare by awards int.
     *
     * Compares actors by the total number of awards received
     *
     * @param a1 the a 1
     * @param a2 the a 2
     * @return the int
     */
    public int compareByAwards(final ActorInputData a1, final ActorInputData a2) {
        return a1.getAwardsNo().compareTo(a2.getAwardsNo());
    }

    /**
     * Compare award chain list.
     *
     * Award chain to have actors sorted by the number of awards received
     * (if equal: sorted alphabetically)
     *
     * @return the list
     */
    public List<Comparator<ActorInputData>> compareAwardChain() {
        List<Comparator<ActorInputData>> chainList = new ArrayList<>();
        chainList.add(this::compareAlphabetically);
        chainList.add(this::compareByAwards);
        return chainList;
    }

    /**
     * Sort by awards.
     *
     * Sorts actors by the total number of received awards using the award chain
     *
     * @param type the type
     */
    public void sortByAwards(final String type) {
        for (Comparator<ActorInputData> comparator : this.compareAwardChain()) {
            if (type.equals("asc")) {
                Collections.sort(actors, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(actors, comparator.reversed());
            }
        }
    }

    /**
     * Gets actors with filter description.
     *
     * Iterates through actors and returns a list with the actors
     * whose career descriptions include the key words from the filter description
     *
     * @param query the query
     * @return the actors with filter description
     */
    public List<ActorInputData> getActorsWithFilterDescription(final ActionInputData query) {
        List<ActorInputData> actorsWithFilterDescription = new ArrayList<>();
        for (ActorInputData actor : actors) {
            boolean ok1 = true;
            for (String filter : query.getFilters().get(2)) {
                boolean ok2 = false;
                String message = " " + filter.toLowerCase() + " ";
                String message1 = "-" + filter.toLowerCase();
                String message2 = filter.toLowerCase() + ".";
                String message3 = filter.toLowerCase() + ",";
                if ((actor.getCareerDescription().toLowerCase().contains(message))
                        || (actor.getCareerDescription().toLowerCase().contains(message1))
                        || (actor.getCareerDescription().toLowerCase().contains(message2))
                        || (actor.getCareerDescription().toLowerCase().contains(message3))) {
                    ok2 = true;
                }
                ok1 = ok1 && ok2;
            }
            if (ok1) {
                actorsWithFilterDescription.add(actor);
            }
        }
        return actorsWithFilterDescription;
    }

    /**
     * Sort alphabetically.
     *
     * @param type the type
     */
    public void sortAlphabetically(final String type) {
        Comparator<ActorInputData> compareAlpabetically = (ActorInputData a1, ActorInputData a2) ->
                a1.getName().compareTo(a2.getName());
        if (type.equals("asc")) {
            Collections.sort(actors, compareAlpabetically);
        } else if (type.equals("desc")) {
            Collections.sort(actors, compareAlpabetically.reversed());
        }
    }
}
