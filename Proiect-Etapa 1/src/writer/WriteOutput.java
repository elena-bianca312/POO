package writer;

import stages.DoStages;
import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Write output.
 */
public final class WriteOutput {

    private List<WriteConsumer> consumers = new ArrayList<>();
    private List<WriteDistributor> distributors = new ArrayList<>();

    /**
     * Instantiates a new Write output.
     */
    public WriteOutput() {
    }

    /**
     * Gets consumers.
     *
     * @return the consumers
     */
    public List<WriteConsumer> getConsumers() {
        return consumers;
    }

    /**
     * Sets consumers.
     *
     * @param consumers the consumers
     */
    public void setConsumers(final List<WriteConsumer> consumers) {
        this.consumers = consumers;
    }

    /**
     * Gets distributors.
     *
     * @return the distributors
     */
    public List<WriteDistributor> getDistributors() {
        return distributors;
    }

    /**
     * Sets distributors.
     *
     * @param distributors the distributors
     */
    public void setDistributors(final List<WriteDistributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * Format output.
     *
     * @param data the data
     */
    public void formatOutput(final DoStages data) {
        for (MyConsumer myConsumer : data.getMyConsumers()) {
            WriteConsumer consumer = new WriteConsumer(myConsumer.getId(),
                    myConsumer.isBankrupt(), myConsumer.getNewBudget());
            consumers.add(consumer);
        }
        for (MyDistributor myDistributor : data.getMyDistributors()) {
            List<WriteContract> contracts = new ArrayList<>();
            if (myDistributor.getContracts() != null) {
                for (Contract myContract : myDistributor.getContracts()) {
                    WriteContract contract = new WriteContract(myContract.getId(),
                            myContract.getPrice(), myContract.getRemainedContractMonths());
                    contracts.add(contract);
                }
                WriteDistributor distributor = new WriteDistributor(myDistributor.getId(),
                        myDistributor.getInitialBudget(), myDistributor.isBankrupt(), contracts);
                distributors.add(distributor);
            }
        }
    }

    @Override
    public String toString() {
        return "WriteOutput{"
                +
                "consumers=" + consumers.toString()
                +
                ", distributors=" + distributors.toString()
                +
                '}';
    }
}
