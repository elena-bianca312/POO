package stages;

import distributors.MyDistributor;

import java.util.List;

/**
 * The type Contracts price.
 */
public final class ContractsPrice {

    private ContractsPrice() {
    }

    /**
     * Sets contracts price.
     *
     * Sets the price for the contracts for all distributors
     *
     * @param myDistributors the my distributors
     */
    public static void setContractsPrice(final List<MyDistributor> myDistributors) {
        for (MyDistributor distributor : myDistributors) {
            distributor.setContractPrice(distributor.calcContractPrice());
        }
    }

}
