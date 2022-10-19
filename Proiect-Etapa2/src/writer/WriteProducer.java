package writer;

import producers.MonthlyStats;

import java.util.List;

/**
 * The type Write producer.
 */
public class WriteProducer {

    private int id;

    private int maxDistributors;

    private double priceKW;

    private String energyType;

    private int energyPerDistributor;

    private List<MonthlyStats> monthlyStats;

    /**
     * Instantiates a new Write producer.
     *
     * @param id                   the id
     * @param maxDistributors      the max distributors
     * @param priceKW              the price kw
     * @param energyType           the energy type
     * @param energyPerDistributor the energy per distributor
     * @param monthlyStats         the monthly stats
     */
    public WriteProducer(final int id, final int maxDistributors, final double priceKW,
                         final String energyType, final int energyPerDistributor,
                         final List<MonthlyStats> monthlyStats) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
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
     * Formats producer
     *
     * @return string containing details of the producer
     */
    @Override
    public String toString() {
        return "WriteProducer{"
                + "id="
                + id
                + ", maxDistributors="
                + maxDistributors
                + ", priceKW="
                + priceKW
                + ", energyType='"
                + energyType
                + '\''
                + ", energyPerDistributor="
                + energyPerDistributor
                + ", monthlyStats="
                + monthlyStats
                + '}';
    }
}
