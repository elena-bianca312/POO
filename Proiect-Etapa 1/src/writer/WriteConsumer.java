package writer;

/**
 * The type Write consumer.
 */
public final class WriteConsumer {

    private int id;

    private boolean isBankrupt;

    private int budget;

    /**
     * Instantiates a new Write consumer.
     *
     * @param id         the id
     * @param isBankrupt the is bankrupt
     * @param budget     the budget
     */
    public WriteConsumer(final int id, final boolean isBankrupt, final int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
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
     * Gets is bankrupt.
     *
     * @return the is bankrupt
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets is bankrupt.
     *
     * @param bankrupt the bankrupt
     */
    public void setIsBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Gets budget.
     *
     * @return the budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Sets budget.
     *
     * @param budget the budget
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "WriteConsumer{"
                +
                "id=" + id
                +
                ", isBankrupt=" + isBankrupt
                +
                ", budget=" + budget
                +
                '}';
    }
}
