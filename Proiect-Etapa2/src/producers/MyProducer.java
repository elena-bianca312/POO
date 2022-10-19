package producers;

import distributors.MyDistributor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type My producer.
 */
public class MyProducer implements ProducerInterface {

    private int id;
    private String energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;
    private List<MyDistributor> distributors = new ArrayList<>();
    private List<MonthlyStats> monthlyStats = new ArrayList<>();

    /**
     * Instantiates a new My producer.
     *
     * @param id                   the id
     * @param energyType           the energy type
     * @param maxDistributors      the max distributors
     * @param priceKW              the price kw
     * @param energyPerDistributor the energy per distributor
     */
    public MyProducer(final int id, final String energyType, final int maxDistributors,
                      final double priceKW, final int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
    }

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

    /**
     * Gets distributors.
     *
     * @return the distributors
     */
    public List<MyDistributor> getDistributors() {
        return distributors;
    }

    /**
     * Sets distributors.
     *
     * @param distributors the distributors
     */
    public void setDistributors(final List<MyDistributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * Gets monthly stats.
     *
     * @return the monthly stats
     */
    public List<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }

    /**
     * Sets monthly stats.
     *
     * @param monthlyStats the monthly stats
     */
    public void setMonthlyStats(final List<MonthlyStats> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    /**
     * Update.
     *
     * @param distributor the distributor
     */
    public void update(final MyDistributor distributor) {
        List<MyDistributor> newList = new ArrayList<>();
        for (MyDistributor iter : distributors) {
            if (!iter.equals(distributor)) {
                newList.add(iter);
            }
        }
        distributors = newList;
    }

    /**
     * Formats producer
     *
     * @return string containing details of the producer
     */
    @Override
    public String toString() {
        return "MyProducer{"
                + "id="
                + id
                + ", energyType='"
                + energyType
                + '\''
                + ", maxDistributors="
                + maxDistributors
                + ", priceKW="
                + priceKW
                + ", energyPerDistributor="
                + energyPerDistributor
                + ", distributors="
                + distributors
                + ", monthlyStats="
                + monthlyStats
                + '}';
    }
}
