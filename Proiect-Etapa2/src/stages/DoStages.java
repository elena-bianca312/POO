package stages;

import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;
import producers.MyProducer;
import reader.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Do stages.
 */
public class DoStages {

    private static Input input;
    private static List<MyConsumer> myConsumers = new ArrayList<>();
    private static List<MyDistributor> myDistributors = new ArrayList<>();
    private static List<MyProducer> myProducers = new ArrayList<>();

    /**
     * Instantiates a new Do stages.
     *
     * @param input the input
     */
    public DoStages(final Input input) {
        DoStages.input = input;
    }

    /**
     * Update contract months.
     */
    public static void updateContractMonths() {
        for (MyDistributor distributor : myDistributors) {
            for (Contract contract : distributor.getContracts()) {
                contract.setRemainedContractMonths(contract.getRemainedContractMonths() - 1);
            }
        }
    }

    /**
     * Gets input.
     *
     * @return the input
     */
    public Input getInput() {
        return input;
    }

    /**
     * Gets my consumers.
     *
     * @return the my consumers
     */
    public List<MyConsumer> getMyConsumers() {
        return myConsumers;
    }

    /**
     * Sets my consumers.
     *
     * @param myConsumers the my consumers
     */
    public void setMyConsumers(final List<MyConsumer> myConsumers) {
        DoStages.myConsumers = myConsumers;
    }

    /**
     * Gets my distributors.
     *
     * @return the my distributors
     */
    public List<MyDistributor> getMyDistributors() {
        return myDistributors;
    }

    /**
     * Sets my distributors.
     *
     * @param myDistributors the my distributors
     */
    public void setMyDistributors(final List<MyDistributor> myDistributors) {
        DoStages.myDistributors = myDistributors;
    }

    /**
     * Gets my producers.
     *
     * @return the my producers
     */
    public List<MyProducer> getMyProducers() {
        return myProducers;
    }

    /**
     * Sets my producers.
     *
     * @param myProducers the my producers
     */
    public void setMyProducers(final List<MyProducer> myProducers) {
        DoStages.myProducers = myProducers;
    }

    /**
     * Do turns.
     * <p>
     * Calls the functions that do the different parts of the simulation in the correct order
     * + if all distributors are bankrupt -> stop game / simulation
     */
    public void doTurns() {

        AddData.setNewConsumers(myConsumers, input.getInitialData().getConsumers());
        AddData.setNewDistributors(myDistributors, input.getInitialData().getDistributors());
        AddData.setNewProducers(myProducers, input.getInitialData().getProducers());


        for (int i = 0; i <= input.getNumberOfTurns(); i++) {
            //System.out.println("Runda -------------- " + i);

//            System.out.println(myConsumers.toString());
//            System.out.println(myDistributors.toString());
//            System.out.println(myProducers.toString());

            if (i == 0) {
                //first month
                //distributors choose their producers
                DistributorsAndProducers.distributorsChooseProducers(myDistributors, myProducers);
                for (MyDistributor distributor : myDistributors) {
                    distributor.calcProductionCost();
                    distributor.setEnergyProvided(0);
                }

            } else {
                DoMonthlyUpdates.doUpdates(myConsumers, myDistributors, i - 1, input);
                DistributorsAndProducers.distributorsChooseProducers(myDistributors, myProducers);
                for (MyDistributor distributor : myDistributors) {
                    distributor.calcProductionCost();
                }
            }

            if (i > 1) {
                DoMonthlyUpdates.calculateMonthlyStats(myProducers, i - 1);
            }

            ContractsPrice.setContractsPrice(myDistributors);
            ConsumersChooseContracts.consumersChooseContract(myConsumers, myDistributors);
            updateContractMonths();
            RemoveBankruptOrExpired.removeExpiredContracts(myConsumers, myDistributors);
            ConsumerActions.consumersGetPaid(myConsumers);
            ConsumerActions.consumersPayContract(myConsumers);
            DistributorsBudget.distributorsGetContractMoney(myConsumers, myDistributors);
            DistributorsBudget.distributorsPayCosts(myDistributors);
            RemoveBankruptOrExpired.removeBankruptConsumers(myConsumers);
            RemoveBankruptOrExpired
                    .removeBankruptDistributorsContracts(myConsumers, myDistributors);

            boolean gameOver = RemoveBankruptOrExpired.bankruptDistributors(myDistributors);
            if (gameOver) {
                break;
            }

            if (i != 0) {
                DoMonthlyUpdates
                        .doUpdatesForProducers(myDistributors, myProducers, i - 1,
                                input);
            }
        }

        DoMonthlyUpdates.calculateMonthlyStats(myProducers, input.getNumberOfTurns());
    }
}
