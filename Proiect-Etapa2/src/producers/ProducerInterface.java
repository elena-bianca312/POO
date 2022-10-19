package producers;

import distributors.MyDistributor;

/**
 * The interface Producer interface.
 */
public interface ProducerInterface {

    /**
     * Update.
     *
     * @param distributor the distributor
     */
    void update(MyDistributor distributor);

}
