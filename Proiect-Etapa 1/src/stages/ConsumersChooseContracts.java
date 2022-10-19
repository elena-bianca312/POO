package stages;

import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;

import java.util.List;

/**
 * The type Consumers choose contracts.
 */
public final class ConsumersChooseContracts {

    private ConsumersChooseContracts() {
    }

    private static final int INT_MAX = 1000;

    /**
     * Consumers choose contract.
     *
     * Bankrupt consumers can't choose new contracts
     * A consumer can choose a (new) contract only if he doesn't have one (doesn't have a
     * distributor) or his contract is about to expire
     *
     * We iterate through distributors and choose the one with the minimum contract price
     * Then we assign the distributor to the consumer
     * If the consumer already has a distributor and he skipped the last payment, we save the old
     * contract price in "OldContractPrice", to compute his payment afterwards
     *
     * We create a new contract for the consumer in the distributor's contracts list
     *
     * @param myConsumers    the my consumers
     * @param myDistributors the my distributors
     */
    public static void consumersChooseContract(final List<MyConsumer> myConsumers,
                                               final List<MyDistributor> myDistributors) {
        for (MyConsumer consumer : myConsumers) {
            if (!consumer.isBankrupt()) {
                // if consumer does not have distributor
                // consumer's contract expires next month
                if (consumer.getDistributor() == null
                        || consumer.getMonthNo() == consumer.getDistributor().getContractLength()) {
                    Integer minPrice = INT_MAX;
                    MyDistributor minDistributor = null;
                    for (MyDistributor distributor : myDistributors) {
                        if (!distributor.isBankrupt()) {
                            if (distributor.getContractPrice() < minPrice) {
                                minPrice = distributor.getContractPrice();
                                minDistributor = distributor;
                            }
                        }
                    }
                    if (minDistributor != null) {
                        if (consumer.getDistributor() == null || consumer.getMonthNo()
                                == consumer.getDistributor().getContractLength()) {
                            if (!consumer.getSkippedPay()) {
                                consumer.setOldContractPrice(minDistributor.getContractPrice());
                            }

                        }
                        consumer.setNewContractPrice(minDistributor.getContractPrice());
                        consumer.setDistributor(minDistributor);
                        consumer.setMonthNo(0);
                        minDistributor.addConsumer(consumer);
                        Contract contract = new Contract(consumer.getId(),
                                minDistributor.getContractPrice(),
                                minDistributor.getContractLength());
                        contract.setPrice(minDistributor.getContractPrice());
                        contract.setRemainedContractMonths(minDistributor.getContractLength());
                        minDistributor.addContract(contract);
                    }
                }
            }
        }
    }
}
