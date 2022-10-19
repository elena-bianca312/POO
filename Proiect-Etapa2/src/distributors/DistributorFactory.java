package distributors;

import reader.Distributor;

/**
 * The type Distributor factory.
 */
public final class DistributorFactory {

    private static DistributorFactory instance = null;

    /**
     * Instantiates a new Distributor factory.
     */
    private DistributorFactory() {
    }

    /**
     * Gets instance.
     * Implementation of singleton design pattern for distributor factor.
     *
     * @return the instance
     */
    public static DistributorFactory getInstance() {
        if (instance == null) {
            instance = new DistributorFactory();
        }
        return instance;
    }

    /**
     * Gets distributor type.
     * Factory static function to create instances of distributors.
     *
     * @param distributorType the distributor type
     * @param distributor     the distributor
     * @return the distributor type
     */
    public DistributorInterface getDistributorType(final String distributorType,
                                                   final Distributor distributor) {
        switch (distributorType) {
            case Utils.DISTRIBUTOR:
                return new MyDistributor(distributor.getId(),
                        distributor.getContractLength(),
                        distributor.getInitialBudget(),
                        distributor.getInitialInfrastructureCost(),
                        distributor.getEnergyNeededKW(),
                        distributor.getProducerStrategy());
            default:
                throw new IllegalStateException("Unexpected value: " + distributorType);
        }
    }

}
