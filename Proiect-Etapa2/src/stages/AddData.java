package stages;

import consumers.ConsumerFactory;
import consumers.MyConsumer;
import distributors.DistributorFactory;
import distributors.MyDistributor;
import producers.MyProducer;
import producers.ProducerFactory;
import reader.Consumer;
import reader.Distributor;
import reader.Producer;

import java.util.List;

/**
 * The type Add data.
 */
public final class AddData {

    private AddData() {
    }

    /**
     * Sets new consumers.
     * <p>
     * Adds (new) consumers to the consumer list declared in the DoStages class
     *
     * @param myConsumers  the my consumers
     * @param addConsumers the add consumers
     */
    public static void setNewConsumers(final List<MyConsumer> myConsumers,
                                       final List<Consumer> addConsumers) {
        ConsumerFactory consumerFactory = ConsumerFactory.getInstance();
        for (Consumer consumer : addConsumers) {
            MyConsumer newConsumer =
                    (MyConsumer) consumerFactory.getConsumerType("consumer", consumer);
            newConsumer.setDistributor(null);
            myConsumers.add(newConsumer);
        }
    }

    /**
     * Sets new distributors.
     * <p>
     * Adds (new) distributors to the distributor list declared in the DoStages class
     *
     * @param myDistributors  the my distributors
     * @param addDistributors the add distributor
     */
    public static void setNewDistributors(final List<MyDistributor> myDistributors,
                                          final List<Distributor> addDistributors) {
        DistributorFactory distributorFactory = DistributorFactory.getInstance();
        for (Distributor distributor : addDistributors) {
            MyDistributor newDistributor =
                    (MyDistributor) distributorFactory
                            .getDistributorType("distributor", distributor);
            myDistributors.add(newDistributor);
        }
    }

    /**
     * Sets new producers.
     *
     * @param myProducers  the my producers
     * @param addProducers the add producers
     */
    public static void setNewProducers(final List<MyProducer> myProducers,
                                       final List<Producer> addProducers) {
        ProducerFactory producerFactory = ProducerFactory.getInstance();
        for (Producer producer : addProducers) {
            MyProducer newProducer =
                    (MyProducer) producerFactory.getProducerType("producer", producer);
            myProducers.add(newProducer);
        }
    }

    /**
     * Add producers by energy.
     *
     * @param myProducers   the my producers
     * @param typeProducers the type producers
     * @param type          the type
     */
    public static void addProducersByEnergy(final List<MyProducer> myProducers,
                                            final List<MyProducer> typeProducers, String type) {
        for (MyProducer producer : myProducers) {
            if (producer.getEnergyType().equals(type)) {
                typeProducers.add(producer);
            }
        }
    }
}
