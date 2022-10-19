package reader;

/**
 * The type Producer.
 */
public class Producer {

    private int id;

    private String energyType;

    private int maxDistributors;

    private double priceKW;

    private int energyPerDistributor;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets energy type.
     *
     * @return the energy type
     */
    public String getEnergyType() {
        return energyType;
    }

    /**
     * Sets energy type.
     *
     * @param energyType the energy type
     */
    public void setEnergyType(final String energyType) {
        this.energyType = energyType;
    }

    /**
     * Gets max distributors.
     *
     * @return the max distributors
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * Sets max distributors.
     *
     * @param maxDistributors the max distributors
     */
    public void setMaxDistributors(final int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /**
     * Gets price kw.
     *
     * @return the price kw
     */
    public double getPriceKW() {
        return priceKW;
    }

    /**
     * Sets price kw.
     *
     * @param priceKW the price kw
     */
    public void setPriceKW(final double priceKW) {
        this.priceKW = priceKW;
    }

    /**
     * Gets energy per distributor.
     *
     * @return the energy per distributor
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * Sets energy per distributor.
     *
     * @param energyPerDistributor the energy per distributor
     */
    public void setEnergyPerDistributor(final int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }
}
