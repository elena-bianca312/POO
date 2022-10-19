package reader;

/**
 * The type Distributor.
 */
public class Distributor {

    private int id;

    private int contractLength;

    private int initialBudget;

    private int initialInfrastructureCost;

    private int initialProductionCost;

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
     * Gets initial production cost.
     *
     * @return the initial production cost
     */
    public int getInitialProductionCost() {
        return initialProductionCost;
    }

    /**
     * Sets initial production cost.
     *
     * @param initialProductionCost the initial production cost
     */
    public void setInitialProductionCost(final int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }
}
