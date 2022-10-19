package reader;

/**
 * The type Costs changes.
 */
public class CostsChanges {

    private int id;
    private int infrastructureCost;
    private int productionCost;

    /**
     * Instantiates a new Costs changes.
     */
    public CostsChanges() {
    }

    /**
     * Instantiates a new Costs changes.
     *
     * @param id                 the id
     * @param infrastructureCost the infrastructure cost
     * @param productionCost     the production cost
     */
    public CostsChanges(final int id, final int infrastructureCost, final int productionCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
        this.productionCost = productionCost;
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

    /**
     * Gets production cost.
     *
     * @return the production cost
     */
    public int getProductionCost() {
        return productionCost;
    }

    /**
     * Sets production cost.
     *
     * @param productionCost the production cost
     */
    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }
}
