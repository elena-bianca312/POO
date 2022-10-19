package writer;

import java.util.List;

/**
 * The type Write distributor.
 */
public final class WriteDistributor {

    private int id;

    private int energyNeededKW;

    private int contractCost;

    private int budget;

    private String producerStrategy;

    private boolean isBankrupt;

    private List<WriteContract> contracts;

    public WriteDistributor(int id, int energyNeededKW, int contractCost, int budget,
                            String producerStrategy, boolean isBankrupt,
                            List<WriteContract> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

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

    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public int getContractCost() {
        return contractCost;
    }

    public void setContractCost(int contractCost) {
        this.contractCost = contractCost;
    }

    /**
     * Gets budget.
     *
     * @return the budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Sets budget.
     *
     * @param budget the budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    public String getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /**
     * Gets is bankrupt.
     *
     * @return the is bankrupt
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets is bankrupt.
     *
     * @param bankrupt the bankrupt
     */
    public void setIsBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Gets contracts.
     *
     * @return the contracts
     */
    public List<WriteContract> getContracts() {
        return contracts;
    }

    /**
     * Sets contracts.
     *
     * @param contracts the contracts
     */
    public void setContracts(final List<WriteContract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "WriteDistributor{"
                +
                "id=" + id
                +
                ", budget=" + budget
                +
                ", isBankrupt=" + isBankrupt
                +
                ", contracts=" + contracts.toString()
                +
                '}';
    }
}
