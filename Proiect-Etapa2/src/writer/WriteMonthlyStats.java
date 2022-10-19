package writer;

import java.util.List;

/**
 * The type Write monthly stats.
 */
public class WriteMonthlyStats {

    private int month;

    private List<Integer> distributorsIds;

    /**
     * Instantiates a new Write monthly stats.
     *
     * @param month           the month
     * @param distributorsIds the distributors ids
     */
    public WriteMonthlyStats(final int month, final List<Integer> distributorsIds) {
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
        return "WriteMonthlyStats{"
                + "month="
                + month
                + ", distributorsIds="
                + distributorsIds
                + '}';
    }
}
