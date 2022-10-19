package distributors;

import consumers.MyConsumer;

/**
 * The interface Distributor interface.
 */
public interface DistributorInterface {

    /**
     * Calc contract price int.
     *
     * @return the int
     */
    int calcContractPrice();

    /**
     * Gets total costs.
     *
     * @return the total costs
     */
    double getTotalCosts();

    /**
     * Add consumer.
     *
     * @param consumer the consumer
     */
    void addConsumer(MyConsumer consumer);

    /**
     * Add contract.
     *
     * @param contract the contract
     */
    void addContract(Contract contract);

    /**
     * Find contract by consumer id contract.
     *
     * @param id the id
     * @return the contract
     */
    Contract findContractByConsumerID(Integer id);

}
