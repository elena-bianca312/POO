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
     * The Distributor changes.
     */
    private List<DistributorChanges> distributorChanges;

    private List<ProducerChanges> producerChanges;

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
    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    /**
     * Sets costs changes.
     *
     * @param distributorChanges the costs changes
     */
    public void setDistributorChanges(final List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    /**
     * Gets producer changes.
     *
     * @return the producer changes
     */
    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    /**
     * Sets producer changes.
     *
     * @param producerChanges the producer changes
     */
    public void setProducerChanges(final List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }
}
