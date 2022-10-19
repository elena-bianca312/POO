package src;

import java.util.TreeSet;

public class NewTreeSet extends TreeSet<Integer> {

    @Override
    public boolean add(Integer integer) {
        if(integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }

}
