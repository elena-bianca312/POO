package writer;

/**
 * The type Write contract.
 */
public final class WriteContract {

    private int consumerId;

    private int price;

    private int remainedContractMonths;

    /**
     * Instantiates a new Write contract.
     *
     * @param consumerId             the consumer id
     * @param price                  the price
     * @param remainedContractMonths the remained contract months
     */
    public WriteContract(final int consumerId, final int price, final int remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * Gets consumer id.
     *
     * @return the consumer id
     */
    public int getConsumerId() {
        return consumerId;
    }

    /**
     * Sets consumer id.
     *
     * @param consumerId the consumer id
     */
    public void setConsumerId(final int consumerId) {
        this.consumerId = consumerId;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * Gets remained contract months.
     *
     * @return the remained contract months
     */
    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    /**
     * Sets remained contract months.
     *
     * @param remainedContractMonths the remained contract months
     */
    public void setRemainedContractMonths(final int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    @Override
    public String toString() {
        return "WriteContract{"
                +
                "consumerId=" + consumerId
                +
                ", price=" + price
                +
                ", remainedContractMonths=" + remainedContractMonths
                +
                '}';
    }
}
