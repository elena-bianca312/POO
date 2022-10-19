package fileio;

import java.util.ArrayList;

/**
 * Information about a movie, retrieved from parsing the input test files
 * <p>
 * DO NOT MODIFY
 */
public final class MovieInputData extends ShowInput {
    /**
     * Duration in minutes of a season
     */
    private final Integer duration;

    //////////////////////////////////////////////////

    private Double rating = Double.valueOf(0);
    private Integer favoriteOccurrence = 0;
    private Integer views;
    private Integer order;

    public MovieInputData(final String title, final ArrayList<String> cast,
                          final ArrayList<String> genres, final int year,
                          final int duration) {
        super(title, year, cast, genres);
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(final Double rating) {
        this.rating = rating;
    }

    public Integer getFavoriteOccurrence() {
        return favoriteOccurrence;
    }

    public void setFavoriteOccurrence(final Integer favoriteOccurrence) {
        this.favoriteOccurrence = favoriteOccurrence;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(final Integer views) {
        this.views = views;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(final Integer order) {
        this.order = order;
    }

    //////////////////////////////////////////////////

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "MovieInputData{" + "title= "
                + super.getTitle() + "year= "
                + super.getYear() + "duration= "
                + duration + "cast {"
                + super.getCast() + " }\n"
                + "genres {" + super.getGenres() + " }\n ";
    }
}
