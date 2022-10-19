package distributors;

import consumers.MyConsumer;
import producers.MyProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type My distributor.
 */
public final class MyDistributor implements DistributorInterface {

    private static final double PERCENTAGE = 0.2;
    private static final double DIVISOR = 10;
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int energyNeededKW;
    private String producerStrategy;
    private int productionCost;
    private Integer contractPrice;
    private boolean isBankrupt = false;
    private List<MyConsumer> consumerList = new ArrayList<>();
    private List<Contract> contracts = new ArrayList<>();
    private List<MyProducer> producerList = new ArrayList<>();
    private int energyProvided;

    /**
     * Instantiates a new My distributor.
     *
     * @param id                        the id
     * @param contractLength            the contract length
     * @param initialBudget             the initial budget
     * @param initialInfrastructureCost the initial infrastructure cost
     * @param energyNeededKW            the energy needed kw
     * @param producerStrategy          the producer strategy
     */
    public MyDistributor(final int id, final int contractLength, final int initialBudget,
                         final int initialInfrastructureCost, final int energyNeededKW,
                         final String producerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
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
    public void setEnergyNeededKW(int energyNeededKW) {
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
    public void setProducerStrategy(String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    /**
     * Gets production cost.
     *
     * @return the production cost
     */
    public int getProductionCost() {
        return productionCost;
    }

    /**
     * Sets production cost.
     *
     * @param initialProductionCost the initial production cost
     */
    public void setProductionCost(int initialProductionCost) {
        this.productionCost = initialProductionCost;
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
     * Gets producer list.
     *
     * @return the producer list
     */
    public List<MyProducer> getProducerList() {
        return producerList;
    }

    /**
     * Sets producer list.
     *
     * @param producerList the producer list
     */
    public void setProducerList(List<MyProducer> producerList) {
        this.producerList = producerList;
    }

    /**
     * Gets energy provided.
     *
     * @return the energy provided
     */
    public int getEnergyProvided() {
        return energyProvided;
    }

    /**
     * Sets energy provided.
     *
     * @param energyProvided the energy provided
     */
    public void setEnergyProvided(int energyProvided) {
        this.energyProvided = energyProvided;
    }

    /**
     * Calc production cost.
     */
    public void calcProductionCost() {
        double price = 0;
        for (MyProducer producer : producerList) {
            price += producer.getEnergyPerDistributor() * producer.getPriceKW();
        }
        this.setProductionCost((int) Math.round(Math.floor(price / DIVISOR)));
    }

    /**
     * Calculates the price for the contract.
     *
     * @return the contract price
     */
    public int calcContractPrice() {
        double price;
        double profit = Math.round(Math.floor(PERCENTAGE * this.getProductionCost()));
        if (this.getConsumerList().size() != 0) {
            price = (double) Math
                    .round(Math.floor(this.getInitialInfrastructureCost()
                            / this.getConsumerList().size())
                            + this.getProductionCost()
                            + profit);
        } else {
            price = (this.getInitialInfrastructureCost()
                    + this.getProductionCost() + profit);
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
        costs = this.getInitialInfrastructureCost() + this.getProductionCost()
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
     * @param findId the id
     * @return the contract
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
                "id="
                + id
                + ", contractLength="
                + contractLength
                + ", producerStrategy='"
                + producerStrategy
                + '\''
                + ", productionCost="
                + productionCost
                + ", isBankrupt="
                + isBankrupt
                + ", consumerList="
                + consumerList
                + ", contracts="
                + contracts
                + ", producerList="
                + producerList
                + '}';
    }
}
