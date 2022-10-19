package stages;

import producers.MyProducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type Comparables.
 */
public final class Comparables {

    /**
     * Instantiates a new Comparables.
     */
    public Comparables() {
    }

    /**
     * Compare by price int.
     *
     * sort ascending by price
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the int
     */
    public int compareByPrice(final MyProducer p1, final MyProducer p2) {
        return Double.compare(p1.getPriceKW(), p2.getPriceKW());
    }

    /**
     * Compare by quantity int.
     *
     * sort descending by quantity
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the int
     */
    public int compareByQuantity(final MyProducer p1, final MyProducer p2) {
        return Integer.compare(p2.getEnergyPerDistributor(), p1.getEnergyPerDistributor());
    }

    /**
     * Compare by id int.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the int
     */
    public int compareById(final MyProducer p1, final MyProducer p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }

    /**
     * Compare chain 1 list.
     *
     * @return the list
     */
    public List<Comparator<MyProducer>> compareChain1() {
        List<Comparator<MyProducer>> chainList = new ArrayList<>();
        chainList.add(this::compareById);
        chainList.add(this::compareByQuantity);
        chainList.add(this::compareByPrice);
        return chainList;
    }

    /**
     * Sort producers 1.
     *
     * @param producers the producers
     * @param type      the type
     */
    public void sortProducers1(List<MyProducer> producers, final String type) {
        for (Comparator<MyProducer> comparator : this.compareChain1()) {
            if (type.equals("asc")) {
                Collections.sort(producers, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(producers, comparator.reversed());
            }
        }
    }

    /**
     * Compare chain 2 list.
     *
     * @return the list
     */
    public List<Comparator<MyProducer>> compareChain2() {
        List<Comparator<MyProducer>> chainList = new ArrayList<>();
        chainList.add(this::compareById);
        chainList.add(this::compareByQuantity);
        return chainList;
    }

    /**
     * Sort producers 2.
     *
     * @param producers the producers
     * @param type      the type
     */
    public void sortProducers2(List<MyProducer> producers, final String type) {
        for (Comparator<MyProducer> comparator : this.compareChain2()) {
            if (type.equals("asc")) {
                Collections.sort(producers, comparator);
            } else if (type.equals("desc")) {
                Collections.sort(producers, comparator.reversed());
            }
        }
    }
}
