package distributors;

/**
 * The type Contract.
 */
public final class Contract {

    private int id;

    private Integer price;

    private Integer remainedContractMonths;

    private boolean clientSkippedPayment = false;

    private boolean paidFee = false;

    /**
     * Instantiates a new Contract.
     *
     * @param id                     the id
     * @param price                  the price
     * @param remainedContractMonths the remained contract months
     */
    public Contract(final int id, final Integer price, final Integer remainedContractMonths) {
        this.id = id;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
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
     * Gets price.
     *
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(final Integer price) {
        this.price = price;
    }

    /**
     * Gets remained contract months.
     *
     * @return the remained contract months
     */
    public Integer getRemainedContractMonths() {
        return remainedContractMonths;
    }

    /**
     * Sets remained contract months.
     *
     * @param remainedContractMonths the remained contract months
     */
    public void setRemainedContractMonths(final Integer remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * Gets client skipped payment.
     *
     * @return the client skipped payment
     */
    public boolean getClientSkippedPayment() {
        return clientSkippedPayment;
    }

    /**
     * Sets client skipped payment.
     *
     * @param clientSkippedPayment the client skipped payment
     */
    public void setClientSkippedPayment(final boolean clientSkippedPayment) {
        this.clientSkippedPayment = clientSkippedPayment;
    }

    /**
     * Gets paid fee.
     *
     * @return the paid fee
     */
    public boolean getPaidFee() {
        return paidFee;
    }

    /**
     * Sets paid fee.
     *
     * @param paidFee the paid fee
     */
    public void setPaidFee(final boolean paidFee) {
        this.paidFee = paidFee;
    }

    @Override
    public String toString() {
        return "Contract{"
                +
                "id=" + id
                +
                ", price=" + price
                +
                ", remainedContractMonths=" + remainedContractMonths
                +
                ", skippedpay=" + clientSkippedPayment
                +
                '}';
    }
}
