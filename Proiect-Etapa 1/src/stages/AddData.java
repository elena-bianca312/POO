package stages;

import reader.Consumer;
import reader.Distributor;
import consumers.ConsumerFactory;
import consumers.MyConsumer;
import distributors.DistributorFactory;
import distributors.MyDistributor;

import java.util.List;

/**
 * The type Add data.
 */
public final class AddData {

    private AddData() {
    }

    /**
     * Sets new consumers.
     *
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
     *
     * Adds (new) distributors to the distributor list declared in the DoStages class
     *
     * @param myDistributors the my distributors
     * @param addDistributor the add distributor
     */
    public static void setNewDistributors(final List<MyDistributor> myDistributors,
                                          final List<Distributor> addDistributor) {
        DistributorFactory distributorFactory = DistributorFactory.getInstance();
        for (Distributor distributor : addDistributor) {
            MyDistributor newDistributor =
                    (MyDistributor) distributorFactory
                            .getDistributorType("distributor", distributor);
            myDistributors.add(newDistributor);
        }
    }

}
