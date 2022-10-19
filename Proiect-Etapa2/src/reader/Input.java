package reader;

import java.util.List;

/**
 * The type Input.
 */
public class Input {

    private int numberOfTurns;

    private InitialData initialData;

    private List<MonthlyUpdates> monthlyUpdates;

    /**
     * Gets number of turns.
     *
     * @return the number of turns
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * Sets number of turns.
     *
     * @param numberOfTurns the number of turns
     */
    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /**
     * Gets initial data.
     *
     * @return the initial data
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * Sets initial data.
     *
     * @param initialData the initial data
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * Gets monthly updates.
     *
     * @return the monthly updates
     */
    public List<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    /**
     * Sets monthly updates.
     *
     * @param monthlyUpdates the monthly updates
     */
    public void setMonthlyUpdates(final List<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }
}
