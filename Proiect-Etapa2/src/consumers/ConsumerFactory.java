package consumers;

import reader.Consumer;

/**
 * The type Consumer factory.
 */
public final class ConsumerFactory {

    private static ConsumerFactory instance = null;

    private ConsumerFactory() {
    }

    /**
     * Gets instance.
     * Implementation of singleton design pattern for consumer factory.
     *
     * @return the instance
     */
    public static ConsumerFactory getInstance() {
        if (instance == null) {
            instance = new ConsumerFactory();
        }
        return instance;
    }

    /**
     * Gets consumer type.
     * Factory static function to create instances of consumers.
     *
     * @param consumerType the consumer type
     * @param consumer     the consumer
     * @return the consumer type
     */
    public ConsumerInterface getConsumerType(final String consumerType, final Consumer consumer) {
        switch (consumerType) {
            case Utils.CONSUMER:
                return new MyConsumer(consumer.getId(), consumer.getInitialBudget(),
                        consumer.getMonthlyIncome());
            default:
                throw new IllegalStateException("Unexpected value: " + consumerType);
        }
    }

}
