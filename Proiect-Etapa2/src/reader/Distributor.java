package reader;

/**
 * The type Distributor.
 */
public class Distributor {

    private int id;

    private int contractLength;

    private int initialBudget;

    private int initialInfrastructureCost;

    private int energyNeededKW;

    private String producerStrategy;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets contract length.
     *
     * @return the contract length
     */
    public int getContractLength() {
        return contractLength;
    }

    /**
     * Sets contract length.
     *
     * @param contractLength the contract length
     */
    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    /**
     * Gets initial budget.
     *
     * @return the initial budget
     */
    public int getInitialBudget() {
        return initialBudget;
    }

    /**
     * Sets initial budget.
     *
     * @param initialBudget the initial budget
     */
    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    /**
     * Gets initial infrastructure cost.
     *
     * @return the initial infrastructure cost
     */
    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    /**
     * Sets initial infrastructure cost.
     *
     * @param initialInfrastructureCost the initial infrastructure cost
     */
    public void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    /**
     * Gets energy needed kw.
     *
     * @return the energy needed kw
     */
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * Sets energy needed kw.
     *
     * @param energyNeededKW the energy needed kw
     */
    public void setEnergyNeededKW(final int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /**
     * Gets producer strategy.
     *
     * @return the producer strategy
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }

    /**
     * Sets producer strategy.
     *
     * @param producerStrategy the producer strategy
     */
    public void setProducerStrategy(final String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }
}
