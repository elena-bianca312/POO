package consumers;

import distributors.MyDistributor;

/**
 * The type My consumer.
 */
public final class MyConsumer implements ConsumerInterface {

    private int id;

    private int initialBudget;

    private int monthlyIncome;

    private int newBudget;

    private boolean isBankrupt;

    private MyDistributor distributor = null;

    private Integer oldContractPrice;

    private Integer newContractPrice;

    private boolean skippedPay;

    private Integer monthNo;

    private MyDistributor oldDistributor = null;

    /**
     * Instantiates a new My consumer.
     *
     * @param id            the id
     * @param initialBudget the initial budget
     * @param monthlyIncome the monthly income
     */
    public MyConsumer(final int id, final int initialBudget, final int monthlyIncome) {
        this.id = id;
        this.newBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
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
     * Gets new budget.
     *
     * @return the new budget
     */
    public int getNewBudget() {
        return newBudget;
    }

    /**
     * Sets new budget.
     *
     * @param newBudget the new budget
     */
    public void setNewBudget(final int newBudget) {
        this.newBudget = newBudget;
    }

    /**
     * Is bankrupt boolean.
     *
     * @return the boolean
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets bankrupt.
     *
     * @param bankrupt the bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Gets distributor.
     *
     * @return the distributor
     */
    public MyDistributor getDistributor() {
        return distributor;
    }

    /**
     * Sets distributor.
     *
     * @param distributor the distributor
     */
    public void setDistributor(final MyDistributor distributor) {
        this.distributor = distributor;
    }

    /**
     * Gets old contract price.
     *
     * @return the old contract price
     */
    public Integer getOldContractPrice() {
        return oldContractPrice;
    }

    /**
     * Sets old contract price.
     *
     * @param oldContractPrice the old contract price
     */
    public void setOldContractPrice(final Integer oldContractPrice) {
        this.oldContractPrice = oldContractPrice;
    }

    /**
     * Gets new contract price.
     *
     * @return the new contract price
     */
    public Integer getNewContractPrice() {
        return newContractPrice;
    }

    /**
     * Sets new contract price.
     *
     * @param newContractPrice the new contract price
     */
    public void setNewContractPrice(final Integer newContractPrice) {
        this.newContractPrice = newContractPrice;
    }

    /**
     * Gets skipped pay.
     *
     * @return the skipped pay
     */
    public boolean getSkippedPay() {
        return skippedPay;
    }

    /**
     * Sets skipped pay.
     *
     * @param skippedPay the skipped pay
     */
    public void setSkippedPay(final boolean skippedPay) {
        this.skippedPay = skippedPay;
    }

    /**
     * Gets month no.
     *
     * @return the month no
     */
    public Integer getMonthNo() {
        return monthNo;
    }

    /**
     * Sets month no.
     *
     * @param monthNo the month no
     */
    public void setMonthNo(final Integer monthNo) {
        this.monthNo = monthNo;
    }

    public MyDistributor getOldDistributor() {
        return oldDistributor;
    }

    public void setOldDistributor(MyDistributor oldDistributor) {
        this.oldDistributor = oldDistributor;
    }

    /**
     * Adds monthly income.
     */
    public void addMonthlyIncome() {
        newBudget = newBudget + monthlyIncome;
    }

    @Override
    public String toString() {
        return "MyConsumer{"
                +
                "id=" + id
                +
                ", Budget=" + newBudget
                +
                ", isBankrupt=" + isBankrupt
                +
                ", monthNo=" + monthNo
                +
                '}';
    }
}
