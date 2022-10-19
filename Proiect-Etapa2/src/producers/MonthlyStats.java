package producers;

import java.util.List;

/**
 * The type Monthly stats.
 */
public class MonthlyStats {

    private int month;

    private List<Integer> distributorsIds;

    /**
     * Instantiates a new Monthly stats.
     *
     * @param month           the month
     * @param distributorsIds the distributors ids
     */
    public MonthlyStats(final int month, final List<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
    public void setMonth(final int month) {
        this.month = month;
    }

    /**
     * Gets distributors ids.
     *
     * @return the distributors ids
     */
    public List<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    /**
     * Sets distributors ids.
     *
     * @param distributorsIds the distributors ids
     */
    public void setDistributorsIds(final List<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }

    /**
     * Formats monthly stats
     *
     * @return string containing details of the monthly stats
     */
    @Override
    public String toString() {
        return "MonthlyStats{"
                + "month="
                + month
                + ", distributorsIds="
                + distributorsIds
                + '}';
    }
}
