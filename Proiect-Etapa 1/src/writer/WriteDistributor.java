package writer;

import java.util.List;

/**
 * The type Write distributor.
 */
public final class WriteDistributor {

    private int id;

    private int budget;

    private boolean isBankrupt;

    private List<WriteContract> contracts;

    /**
     * Instantiates a new Write distributor.
     *
     * @param id         the id
     * @param budget     the budget
     * @param isBankrupt the is bankrupt
     * @param contracts  the contracts
     */
    public WriteDistributor(final int id, final int budget, final boolean isBankrupt,
                            final List<WriteContract> contracts) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
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
     * Gets contracts.
     *
     * @return the contracts
     */
    public List<WriteContract> getContracts() {
        return contracts;
    }

    /**
     * Sets contracts.
     *
     * @param contracts the contracts
     */
    public void setContracts(final List<WriteContract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "WriteDistributor{"
                +
                "id=" + id
                +
                ", budget=" + budget
                +
                ", isBankrupt=" + isBankrupt
                +
                ", contracts=" + contracts.toString()
                +
                '}';
    }
}
