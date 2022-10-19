package mypackage;

import fileio.Input;

/**
 * The type Actors.
 */
public final class Actors {

    private Input actorInput;

    /**
     * Instantiates a new Actors.
     *
     * @param actorInput the actor input
     */
    public Actors(final Input actorInput) {
        this.actorInput = actorInput;
    }

    /**
     * Gets actor input.
     *
     * @return the actor input
     */
    public Input getActorInput() {
        return actorInput;
    }

    /**
     * Sets actor input.
     *
     * @param actorInput the actor input
     */
    public void setActorInput(final Input actorInput) {
        this.actorInput = actorInput;
    }

    /**
     * Initialize actors actor.
     *
     * @return the actor
     */
    public Actor initializeActors() {
        return new Actor(actorInput.getActors());
    }
}
