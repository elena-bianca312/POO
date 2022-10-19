package stages;

import reader.Input;
import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Do stages.
 */
public class DoStages {

    private static Input input;
    private static List<MyConsumer> myConsumers = new ArrayList<>();
    private static List<MyDistributor> myDistributors = new ArrayList<>();

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
     * Do turns.
     *
     * Calls the functions that do the different parts of the simulation in the correct order
     * + if all distributors are bankrupt -> stop game / simulation
     *
     */
    public void doTurns() {

        AddData.setNewConsumers(myConsumers, input.getInitialData().getConsumers());
        AddData.setNewDistributors(myDistributors, input.getInitialData().getDistributors());

        for (int i = 0; i <= input.getNumberOfTurns(); i++) {
            //System.out.println("Runda -------------- " + i);
            if (i != 0) {
                DoMonthlyUpdates.doUpdates(myConsumers, myDistributors, i - 1, input);

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
        }
    }
}
