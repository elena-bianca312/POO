package distributors;

import consumers.MyConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type My distributor.
 */
public final class MyDistributor implements DistributorInterface {

    private static final double PERCENTAGE = 0.2;
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int initialProductionCost;
    private Integer contractPrice;
    private boolean isBankrupt = false;
    private List<MyConsumer> consumerList = new ArrayList<>();
    private List<Contract> contracts = new ArrayList<>();

    /**
     * Instantiates a new My distributor.
     *
     * @param id                        the id
     * @param contractLength            the contract length
     * @param initialBudget             the initial budget
     * @param initialInfrastructureCost the initial infrastructure cost
     * @param initialProductionCost     the initial production cost
     */
    public MyDistributor(final int id, final int contractLength, final int initialBudget,
                         final int initialInfrastructureCost,
                         final int initialProductionCost) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
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

    /**
     * Gets contract price.
     *
     * @return the contract price
     */
    public Integer getContractPrice() {
        return contractPrice;
    }

    /**
     * Sets contract price.
     *
     * @param contractPrice the contract price
     */
    public void setContractPrice(final Integer contractPrice) {
        this.contractPrice = contractPrice;
    }

    /**
     * Is bankrupt boolean.
     *
     * @return the boolean
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets bankrupt.
     *
     * @param bankrupt the bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Gets consumer list.
     *
     * @return the consumer list
     */
    public List<MyConsumer> getConsumerList() {
        return consumerList;
    }

    /**
     * Sets consumer list.
     *
     * @param consumerList the consumer list
     */
    public void setConsumerList(final List<MyConsumer> consumerList) {
        this.consumerList = consumerList;
    }

    /**
     * Gets contracts.
     *
     * @return the contracts
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * Sets contracts.
     *
     * @param contracts the contracts
     */
    public void setContracts(final List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * Calculates the price for the contract.
     *
     * @return the contract price
     */
    public int calcContractPrice() {
        double price;
        double profit = Math.round(Math.floor(PERCENTAGE * this.getInitialProductionCost()));
        if (this.getConsumerList().size() != 0) {
            price = (double) Math
                    .round(Math.floor(this.getInitialInfrastructureCost()
                            / this.getConsumerList().size())
                            + this.getInitialProductionCost()
                            + profit);
        } else {
            price = (this.getInitialInfrastructureCost()
                    + this.getInitialProductionCost() + profit);
        }
        return (int) price;
    }

    /**
     * Calculates the costs that the distributor has to pay monthly.
     * It uses the given formula
     *
     * @return the costs
     */
    public double getTotalCosts() {
        double costs;
        costs = this.getInitialInfrastructureCost() + this.getInitialProductionCost()
                * this.getConsumerList().size();
        return costs;
    }

    /**
     * Adds a new consumer to the consumers list.
     *
     * @param consumer the consumer
     */
    public void addConsumer(final MyConsumer consumer) {
        consumerList.add(consumer);
    }

    /**
     * Adds a new contract to the contract list.
     *
     * @param contract the contract
     */
    public void addContract(final Contract contract) {
        contracts.add(contract);
    }

    /**
     * Finds a contract by the consumer's id.
     *
     * @return the contract
     * @param findId the id
     */
    public Contract findContractByConsumerID(final Integer findId) {
        for (Contract contract : contracts) {
            if (contract.getId() == findId) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyDistributor{"
                +
                "id=" + id
                +
                ", initialBudget=" + initialBudget
                +
                ", initialInfrastructureCost=" + initialInfrastructureCost
                +
                ", initialProductionCost=" + initialProductionCost
                +
                ", consumersNo=" + consumerList.size()
                +
                ", consumers=" + consumerList + "\n"
                +
                ", contracts=" + contracts.toString()
                + "\n"
                +
                '}';
    }
}
