package stages;

import reader.Input;
import consumers.MyConsumer;
import distributors.MyDistributor;

import java.util.List;

/**
 * The type Do monthly updates.
 */
public final class DoMonthlyUpdates {

    private DoMonthlyUpdates() {
    }

    /**
     * Do updates.
     *
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

        //make cost changes
        for (int j = 0; j < input.getMonthlyUpdates().get(i).getCostsChanges().size(); j++) {
            MyDistributor distributor = FindByID.findDistributorByID(myDistributors,
                    input.getMonthlyUpdates().get(i).getCostsChanges().
                            get(j).getId());
            assert distributor != null;
            distributor.setInitialInfrastructureCost(input.getMonthlyUpdates().get(i).
                    getCostsChanges().get(j).getInfrastructureCost());
            distributor.setInitialProductionCost(input.getMonthlyUpdates().get(i).
                    getCostsChanges().get(j).getProductionCost());
        }
    }

}
