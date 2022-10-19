package reader;

/**
 * The type Consumer.
 */
public class Consumer {

    private int id;
    private int initialBudget;
    private int monthlyIncome;

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
     * Gets initial budget.
     *
     * @return the initial budget
     */
    public int getInitialBudget() {
        return initialBudget;
    }

    /**
     * Sets initial budget.
     *
     * @param initialBudget the initial budget
     */
    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    /**
     * Gets monthly income.
     *
     * @return the monthly income
     */
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * Sets monthly income.
     *
     * @param monthlyIncome the monthly income
     */
    public void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * ToString method.
     *
     * @return params of class in organized manner
     */
    @Override
    public String toString() {
        return "Consumer{"
                +
                "id=" + id
                +
                ", initialBudget=" + initialBudget
                +
                ", monthlyIncome=" + monthlyIncome
                +
                '}';
    }
}
