package stages;

import consumers.MyConsumer;

import java.util.List;

/**
 * The type Consumer actions.
 */
public final class ConsumerActions {
    private static final double PERCENTAGE = 1.2;

    private ConsumerActions() {
    }

    /**
     * Consumers get paid.
     *
     * The monthly income is added to their current budget if the consumer is not bankrupt
     *
     * @param myConsumers the my consumers
     */
    public static void consumersGetPaid(final List<MyConsumer> myConsumers) {
        for (MyConsumer consumer : myConsumers) {
            if (!consumer.isBankrupt()) {
                consumer.addMonthlyIncome();
            }
        }
    }

    /**
     * Consumers pay contract.
     *
     * A consumer can choose a contract only if he's not bankrupt
     * If a consumer skipped last month's pay
     *      -> we check if paying the sum for this month and the previous month would bankrupt him
     *              -> yes, then bankrupt
     *              -> no, then pay and set skipped pay to false
     * Else
     *      -> we check if he has enough money to pay for this month's contract
     *              -> yes, then pay
     *              -> no, then don't pay and set skipped pay to true
     * Update the fields from his contract from his distributor's contract list:
     * setClientSkippedPayment + setPaidFee
     *
     * @param myConsumers the my consumers
     */
    public static void consumersPayContract(final List<MyConsumer> myConsumers) {
        for (MyConsumer consumer : myConsumers) {
            if (!consumer.isBankrupt()) {
                //consumer skipped payment
                if (consumer.getSkippedPay()) {
                    int price = (int) (consumer.getNewBudget()
                            - consumer.getOldContractPrice() * PERCENTAGE
                            - consumer.getNewContractPrice());
                    //bankrupt
                    if (price < 0) {
                        consumer.setBankrupt(true);
                    } else { //consumer paid fee and current month
                        consumer.setNewBudget(price);
                        consumer.setSkippedPay(false);
                        if (consumer.getDistributor() != null) {
                            consumer.getDistributor().findContractByConsumerID(consumer.getId())
                                    .setPaidFee(true);
                        }
                    }
                } else {
                    //consumer didn't skip payment
                    int price = consumer.getNewBudget() - consumer.getNewContractPrice();
                    //not enough money -> skip payment
                    if (price < 0) {
                        consumer.setSkippedPay(true);
                        if (consumer.getDistributor() != null) {
                            consumer.getDistributor().findContractByConsumerID(consumer.getId())
                                    .setClientSkippedPayment(true);
                            consumer.getDistributor().findContractByConsumerID(consumer.getId())
                                    .setPaidFee(false);
                        }
                    } else { //pay
                        consumer.setNewBudget(price);
                    }
                }
                consumer.setMonthNo(consumer.getMonthNo() + 1);
            }
        }
    }

}
