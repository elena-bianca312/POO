package stages;

import distributors.MyDistributor;
import producers.MyProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Distributors and producers.
 */
public final class DistributorsAndProducers {

    private DistributorsAndProducers() {
    }

    /**
     * Distributors choose producers.
     *
     * @param myDistributors the my distributors
     * @param myProducers    the my producers
     */
    public static void distributorsChooseProducers(final List<MyDistributor> myDistributors,
                                                   final List<MyProducer> myProducers) {
        for (MyDistributor distributor : myDistributors) {
            //if distributor's producer changes costs or if it doesn't have producers
            if (distributor.getProducerList().isEmpty()) {
                switch (distributor.getProducerStrategy()) {
                    case "GREEN" -> {
                        List<MyProducer> greenProducers = new ArrayList<>();
                        AddData.addProducersByEnergy(myProducers, greenProducers, "WIND");
                        AddData.addProducersByEnergy(myProducers, greenProducers, "SOLAR");
                        AddData.addProducersByEnergy(myProducers, greenProducers, "HYDRO");
                        //compare greenProducers by price and then quantity
                        Comparables compareTool = new Comparables();
                        if (!greenProducers.isEmpty()) {
                            compareTool.sortProducers1(greenProducers, "asc");
                            assignProducersToDistributors(distributor, greenProducers);
                            if (distributor.getEnergyProvided()
                                    >= distributor.getEnergyNeededKW()) {
                                break;
                            }
                        }
                        compareTool.sortProducers1(myProducers, "asc");
                        assignProducersToDistributors(distributor, myProducers);
                    }
                    case "PRICE" -> {
                        Comparables compareTool = new Comparables();
                        compareTool.sortProducers1(myProducers, "asc");
                        assignProducersToDistributors(distributor, myProducers);
                    }
                    case "QUANTITY" -> {
                        Comparables compareTool = new Comparables();
                        compareTool.sortProducers2(myProducers, "asc");
                        assignProducersToDistributors(distributor, myProducers);
                    }
                    default -> throw new IllegalStateException(
                            "Unexpected value: " + distributor.getProducerStrategy());
                }
            }
        }
    }

    /**
     * Assign producers to distributors.
     *
     * @param distributor the distributor
     * @param producers   the producers
     */
    public static void assignProducersToDistributors(MyDistributor distributor,
                                                     List<MyProducer> producers) {
        int i = 0;
        while (i < producers.size()) {
            if (producers.get(i).getDistributors().size() < producers.get(i).getMaxDistributors()) {
                if (FindEntities.findProducerByID(distributor.getProducerList(),
                        producers.get(i).getId()) == null) {
                    distributor.getProducerList().add(producers.get(i));
                    producers.get(i).getDistributors().add(distributor);
                    distributor.setEnergyProvided(distributor.getEnergyProvided()
                            + producers.get(i).getEnergyPerDistributor());
                    if (distributor.getEnergyProvided() >= distributor.getEnergyNeededKW()) {
                        break;
                    }
                }
            }
            i++;
        }
    }
}
