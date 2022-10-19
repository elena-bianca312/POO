package stages;

import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;

import java.util.List;

/**
 * The type Distributors budget.
 */
public final class DistributorsBudget {

    private DistributorsBudget() {
    }

    private static final double PERCENTAGE = 1.2;

    /**
     * Distributors get contract money.
     *
     * Iterate through distributors
     *      Iterate through contracts
     *          -> If the client didn't skip payment
     *              -> distributor receives money
     *          -> If the client skipped payment
     *              -> if he didn't pay fee: distributor doesn't receive anything
     *              -> else: distributor receives tax and current pay
     *              -> sets skipped pay to false
     *
     * @param myConsumers    the my consumers
     * @param myDistributors the my distributors
     */
    public static void distributorsGetContractMoney(final List<MyConsumer> myConsumers,
                                                    final List<MyDistributor> myDistributors) {
        for (MyDistributor distributor : myDistributors) {
            for (Contract contract : distributor.getContracts()) {
                MyConsumer consumer = FindByID.findConsumerByID(myConsumers, contract.getId());
                if (consumer != null && !consumer.isBankrupt()) {
                    //client paid
                    if (!contract.getClientSkippedPayment()) {
                        distributor.setInitialBudget(distributor.getInitialBudget()
                                + consumer.getNewContractPrice());
                    } else { //client skipped
                        if (contract.getPaidFee()) {
                            distributor.setInitialBudget((int) (distributor.getInitialBudget()
                                    + consumer.getOldContractPrice() * PERCENTAGE
                                    + consumer.getNewContractPrice()));
                            contract.setClientSkippedPayment(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Distributors pay costs.
     *
     * If the distributor is not bankrupt, distributor pays cost
     *
     * @param myDistributors the my distributors
     */
    public static void distributorsPayCosts(final List<MyDistributor> myDistributors) {
        for (MyDistributor distributor : myDistributors) {
            if (!distributor.isBankrupt()) {
                if (distributor.getInitialBudget() - distributor.getTotalCosts() < 0) {
                    distributor.setBankrupt(true);
                }

                distributor.setInitialBudget(
                        (int) (distributor.getInitialBudget() - distributor.getTotalCosts()));
            }
        }
    }
}
