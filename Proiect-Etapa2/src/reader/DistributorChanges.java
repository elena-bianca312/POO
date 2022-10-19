package reader;

/**
 * The type Costs changes.
 */
public class DistributorChanges {

    private int id;
    private int infrastructureCost;

    /**
     * Instantiates a new Costs changes.
     */
    public DistributorChanges() {
    }

    /**
     * Instantiates a new Costs changes.
     *
     * @param id                 the id
     * @param infrastructureCost the infrastructure cost
     */
    public DistributorChanges(final int id, final int infrastructureCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
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
     * Gets infrastructure cost.
     *
     * @return the infrastructure cost
     */
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    /**
     * Sets infrastructure cost.
     *
     * @param infrastructureCost the infrastructure cost
     */
    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }
}
