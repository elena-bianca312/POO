package mypackage;

import fileio.Input;

/**
 * The type Movies.
 */
public final class Movies {

    private Input movieInput;

    /**
     * Instantiates a new Movies.
     *
     * @param movieInput the movie input
     */
    public Movies(final Input movieInput) {
        this.movieInput = movieInput;
    }

    /**
     * Gets movie input.
     *
     * @return the movie input
     */
    public Input getMovieInput() {
        return movieInput;
    }

    /**
     * Sets movie input.
     *
     * @param movieInput the movie input
     */
    public void setMovieInput(final Input movieInput) {
        this.movieInput = movieInput;
    }

    /**
     * Initialize movies movie.
     *
     * @return the movie
     */
    public Movie initializeMovies() {
        return new Movie(movieInput.getMovies());
    }
}
