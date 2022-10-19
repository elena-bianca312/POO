package producers;

import reader.Producer;

/**
 * The type Producer factory.
 */
public final class ProducerFactory {

    private static ProducerFactory instance = null;

    private ProducerFactory() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ProducerFactory getInstance() {
        if (instance == null) {
            instance = new ProducerFactory();
        }
        return instance;
    }

    /**
     * Gets producer type.
     *
     * @param producerType the producer type
     * @param producer     the producer
     * @return the producer type
     */
    public ProducerInterface getProducerType(final String producerType,
                                             final Producer producer) {
        switch (producerType) {
            case Utils.PRODUCER:
                return new MyProducer(producer.getId(),
                        producer.getEnergyType(),
                        producer.getMaxDistributors(),
                        producer.getPriceKW(),
                        producer.getEnergyPerDistributor());

            default:
                throw new IllegalStateException("Unexpected value: " + producerType);
        }
    }

}
