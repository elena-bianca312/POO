package stages;

import consumers.MyConsumer;
import distributors.MyDistributor;
import producers.MyProducer;

import java.util.List;

/**
 * The type Find by id.
 */
public final class FindEntities {

    private FindEntities() {
    }

    /**
     * Find distributor by id my distributor.
     *
     * @param myDistributors the my distributors
     * @param id             the id
     * @return the my distributor
     */
    public static MyDistributor findDistributorByID(final List<MyDistributor> myDistributors,
                                                    final Integer id) {
        for (MyDistributor distributor : myDistributors) {
            if (distributor.getId() == id) {
                return distributor;
            }
        }
        return null;
    }

    /**
     * Find consumer by id my consumer.
     *
     * @param myConsumers the my consumers
     * @param id          the id
     * @return the my consumer
     */
    public static MyConsumer findConsumerByID(final List<MyConsumer> myConsumers,
                                              final Integer id) {
        for (MyConsumer consumer : myConsumers) {
            if (consumer.getId() == id) {
                return consumer;
            }
        }
        return null;
    }

    /**
     * Find producer by id my producer.
     *
     * @param myProducers the my producers
     * @param id          the id
     * @return the my producer
     */
    public static MyProducer findProducerByID(final List<MyProducer> myProducers,
                                              final Integer id) {
        for (MyProducer producer : myProducers) {
            if (producer.getId() == id) {
                return producer;
            }
        }
        return null;
    }
}
