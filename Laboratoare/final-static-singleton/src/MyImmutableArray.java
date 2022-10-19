import java.util.*;

public class MyImmutableArray {

    private final ArrayList<Integer> immutableArray;

    //Constructor
    public MyImmutableArray(ArrayList<Integer> immutableArray) {
        this.immutableArray = immutableArray;
    }

    //Getter-ul implementat folosindu-ne de hint
    public List<Integer> getArray(){
        return Collections.unmodifiableList(immutableArray);
    }

    //Testul pt clasa immutableArray.
    // Se observa ca atunci cand incercam sa rulam programul,
    // vom avea o eroare la linia 23 deoarece nu putem
    //sa modificam array-ul final
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(12, 50, 3, 71));
        System.out.println(array);

        MyImmutableArray immarray = new MyImmutableArray(array);
        System.out.println(immarray.getArray());
        immarray.getArray().add(5);
        System.out.println(immarray.getArray());
    }
}




