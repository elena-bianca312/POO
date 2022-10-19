package reader;

import java.util.List;

/**
 * The type Monthly updates.
 */
public class MonthlyUpdates {

    /**
     * The New consumers.
     */
    private List<Consumer> newConsumers;

    /**
     * The Costs changes.
     */
    private List<CostsChanges> costsChanges;

    /**
     * Gets new consumers.
     *
     * @return the new consumers
     */
    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    /**
     * Sets new consumers.
     *
     * @param newConsumers the new consumers
     */
    public void setNewConsumers(final List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /**
     * Gets costs changes.
     *
     * @return the costs changes
     */
    public List<CostsChanges> getCostsChanges() {
        return costsChanges;
    }

    /**
     * Sets costs changes.
     *
     * @param costsChanges the costs changes
     */
    public void setCostsChanges(final List<CostsChanges> costsChanges) {
        this.costsChanges = costsChanges;
    }
}
