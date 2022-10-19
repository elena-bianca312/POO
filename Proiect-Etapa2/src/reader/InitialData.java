package reader;

import java.util.List;

/**
 * The type Initial data.
 */
public class InitialData {

    /**
     * The Consumers.
     */
    private List<Consumer> consumers;

    /**
     * The Distributors.
     */
    private List<Distributor> distributors;

    private List<Producer> producers;

    /**
     * Gets consumers.
     *
     * @return the consumers
     */
    public List<Consumer> getConsumers() {
        return consumers;
    }

    /**
     * Sets consumers.
     *
     * @param consumers the consumers
     */
    public void setConsumers(final List<Consumer> consumers) {
        this.consumers = consumers;
    }

    /**
     * Gets distributors.
     *
     * @return the distributors
     */
    public List<Distributor> getDistributors() {
        return distributors;
    }

    /**
     * Sets distributors.
     *
     * @param distributors the distributors
     */
    public void setDistributors(final List<Distributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * Gets producers.
     *
     * @return the producers
     */
    public List<Producer> getProducers() {
        return producers;
    }

    /**
     * Sets producers.
     *
     * @param producers the producers
     */
    public void setProducers(final List<Producer> producers) {
        this.producers = producers;
    }
}
