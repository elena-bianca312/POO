package mypackage;

import fileio.Input;

/**
 * The type Serials.
 */
public final class Serials {

    private Input serialInput;

    /**
     * Instantiates a new Serials.
     *
     * @param serialInput the serial input
     */
    public Serials(final Input serialInput) {
        this.serialInput = serialInput;
    }

    /**
     * Gets serial input.
     *
     * @return the serial input
     */
    public Input getSerialInput() {
        return serialInput;
    }

    /**
     * Sets serial input.
     *
     * @param serialInput the serial input
     */
    public void setSerialInput(final Input serialInput) {
        this.serialInput = serialInput;
    }


    /**
     * Initialize serials serial.
     *
     * @return the serial
     */
    public Serial initializeSerials() {
        return new Serial(serialInput.getSerials());
    }
}
