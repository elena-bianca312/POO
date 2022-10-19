package stages;

import consumers.MyConsumer;
import distributors.MyDistributor;
import producers.MonthlyStats;
import producers.MyProducer;
import reader.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Do monthly updates.
 */
public final class DoMonthlyUpdates {

    private DoMonthlyUpdates() {
    }

    /**
     * Do updates.
     * <p>
     * Adds new consumers
     * Changes the costs for distributors
     *
     * @param myConsumers    the my consumers
     * @param myDistributors the my distributors
     * @param i              the
     * @param input          the input
     */
    public static void doUpdates(final List<MyConsumer> myConsumers,
                                 final List<MyDistributor> myDistributors,
                                 final Integer i, final Input input) {

        //add new consumers
        AddData.setNewConsumers(myConsumers, input.getMonthlyUpdates().get(i).getNewConsumers());

        //make distributor changes
        for (int j = 0; j < input.getMonthlyUpdates().get(i).getDistributorChanges().size(); j++) {
            MyDistributor distributor = FindEntities.findDistributorByID(myDistributors,
                    input.getMonthlyUpdates().get(i).getDistributorChanges().
                            get(j).getId());
            assert distributor != null;
            distributor.setInitialInfrastructureCost(input.getMonthlyUpdates().get(i).
                    getDistributorChanges().get(j).getInfrastructureCost());
        }
    }


    /**
     * Do updates for producers.
     *
     * @param myDistributors the my distributors
     * @param myProducers    the my producers
     * @param i              the
     * @param input          the input
     */
    public static void doUpdatesForProducers(final List<MyDistributor> myDistributors,
                                             final List<MyProducer> myProducers,
                                             final Integer i, final Input input) {
        for (int j = 0; j < input.getMonthlyUpdates().get(i).getProducerChanges().size(); j++) {
            MyProducer producer =
                    FindEntities.findProducerByID(myProducers, input.getMonthlyUpdates()
                            .get(i).getProducerChanges().get(j).getId());
            assert producer != null;
            producer.setEnergyPerDistributor(input.getMonthlyUpdates().get(i).
                    getProducerChanges().get(j).getEnergyPerDistributor());
            //delete this producer's distributors from their producers' lists
            notifyAllObservers(producer, myDistributors, myProducers);
        }
    }

    /**
     * Notify all observers.
     *
     * @param producer       the producer
     * @param myDistributors the my distributors
     * @param myProducers    the my producers
     */
    public static void notifyAllObservers(MyProducer producer, List<MyDistributor> myDistributors,
                                          List<MyProducer> myProducers) {
        for (MyDistributor distributor : producer.getDistributors()) {
            for (MyProducer iterProducer : distributor.getProducerList()) {
                iterProducer.update(distributor);
            }
            distributor.getProducerList().clear();
            distributor.setEnergyProvided(0);
            DistributorsAndProducers.distributorsChooseProducers(myDistributors, myProducers);
        }
    }

    /**
     * Calculate monthly stats.
     *
     * @param myProducers the my producers
     * @param i           the
     */
    public static void calculateMonthlyStats(List<MyProducer> myProducers, int i) {
        for (MyProducer producer : myProducers) {
            List<Integer> distributorsIds = new ArrayList<>();
            for (MyDistributor distributor : producer.getDistributors()) {
                distributorsIds.add(distributor.getId());
            }
            Collections.sort(distributorsIds);
            MonthlyStats
                    newMonthlyStat = new MonthlyStats(i, distributorsIds);
            producer.getMonthlyStats().add(newMonthlyStat);
        }
    }

}
