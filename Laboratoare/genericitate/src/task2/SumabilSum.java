package task2;

import java.util.List;

public class SumabilSum {

    public <E extends Sumabil> E sum (List<E> list, E sum) {
        for(E element : list) {
            sum.addValue(element);
        }
        return sum;
    }

}
