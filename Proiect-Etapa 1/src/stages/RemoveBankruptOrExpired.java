package stages;

import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Remove bankrupt or expired.
 */
public final class RemoveBankruptOrExpired {

    private RemoveBankruptOrExpired() {
    }

    /**
     * Remove bankrupt consumers.
     *
     * @param myConsumers the my consumers
     */
    public static void removeBankruptConsumers(final List<MyConsumer> myConsumers) {
        for (MyConsumer consumer : myConsumers) {
            Contract removeContract = null;
            if (consumer.getDistributor() != null) {
                for (Contract contract : consumer.getDistributor().getContracts()) {
                    if (contract.getId() == consumer.getId()) {
                        removeContract = contract;
                    }
                }
                if (removeContract != null && (consumer.isBankrupt())) {
                    consumer.getDistributor().getConsumerList().remove(consumer);
                    consumer.getDistributor().getContracts().remove(removeContract);
                }
            }
        }
    }

    /**
     * Remove expired contracts.
     *
     * @param myConsumers    the my consumers
     * @param myDistributors the my distributors
     */
    public static void removeExpiredContracts(final List<MyConsumer> myConsumers,
                                              final List<MyDistributor> myDistributors) {
        for (MyDistributor distributor : myDistributors) {
            List<Contract> validContracts = new ArrayList<>();
            for (Contract contract : distributor.getContracts()) {
                if (contract.getRemainedContractMonths() >= 0) {
                    validContracts.add(contract);
                } else {
                    MyConsumer consumer = FindByID.findConsumerByID(myConsumers, contract.getId());
                    distributor.getConsumerList().remove(consumer);
                }
            }
            distributor.setContracts(validContracts);
        }
    }

    /**
     * Bankrupt distributors boolean.
     *
     * @param myDistributors the my distributors
     * @return the boolean
     */
    public static boolean bankruptDistributors(final List<MyDistributor> myDistributors) {
        boolean gameOver = true;
        for (MyDistributor distributor : myDistributors) {
            gameOver = gameOver && distributor.isBankrupt();
            if (distributor.isBankrupt()) {
                for (MyConsumer consumer : distributor.getConsumerList()) {
                    consumer.setDistributor(null);
                    consumer.setSkippedPay(false);
                }
            }
        }
        return gameOver;
    }

    /**
     * Remove bankrupt distributors contracts.
     *
     * @param myConsumers    the my consumers
     * @param myDistributors the my distributors
     */
    public static void removeBankruptDistributorsContracts(final List<MyConsumer> myConsumers,
                                                       final List<MyDistributor> myDistributors) {
        for (MyDistributor distributor : myDistributors) {
            if (distributor.isBankrupt()) {
                for (Contract contract : distributor.getContracts()) {
                    MyConsumer consumer = FindByID.findConsumerByID(myConsumers, contract.getId());
                    assert consumer != null;
                    consumer.setDistributor(null);
                }
            }
        }
    }
}
