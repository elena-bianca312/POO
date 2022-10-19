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

}
