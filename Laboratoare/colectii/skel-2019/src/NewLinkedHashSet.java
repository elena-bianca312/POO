package src;

import java.util.LinkedHashSet;
import java.util.List;

public class NewLinkedHashSet extends LinkedHashSet<Integer> {

    @Override
    public boolean add(Integer integer) {
        if(integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
