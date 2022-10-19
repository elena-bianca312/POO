package writer;

import consumers.MyConsumer;
import distributors.Contract;
import distributors.MyDistributor;
import producers.MyProducer;
import stages.DoStages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Write output.
 */
public final class WriteOutput {

    private List<WriteConsumer> consumers = new ArrayList<>();
    private List<WriteDistributor> distributors = new ArrayList<>();
    private List<WriteProducer> energyProducers = new ArrayList<>();

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

    public List<WriteProducer> getEnergyProducers() {
        return energyProducers;
    }

    public void setEnergyProducers(List<WriteProducer> energyProducers) {
        this.energyProducers = energyProducers;
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
                        myDistributor.getEnergyNeededKW(),
                        myDistributor.getContractPrice(), myDistributor.getInitialBudget(),
                        myDistributor.getProducerStrategy(),
                        myDistributor.isBankrupt(), contracts);
                distributors.add(distributor);
            }
        }
        for (MyProducer myProducer : data.getMyProducers()) {
            WriteProducer producer =
                    new WriteProducer(myProducer.getId(), myProducer.getMaxDistributors(),
                            myProducer.getPriceKW(), myProducer.getEnergyType(),
                            myProducer.getEnergyPerDistributor(),
                            myProducer.getMonthlyStats());
            energyProducers.add(producer);
        }

        energyProducers.sort(new Comparator<WriteProducer>() {
            @Override
            public int compare(WriteProducer p1, WriteProducer p2) {
                return Integer.compare(p1.getId(), p2.getId());
            }
        });
    }

    @Override
    public String toString() {
        return "WriteOutput{"
                + "consumers="
                + consumers
                + ", distributors="
                + distributors
                + ", energyProducers="
                + energyProducers
                + '}';
    }
}
