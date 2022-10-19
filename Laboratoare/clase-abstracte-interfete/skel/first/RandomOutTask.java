package first;
import java.util.*;

public class RandomOutTask implements Task{

    int number = (int) ((Math.random() * 1000));

    public RandomOutTask() {
    }

    public void execute(){
        System.out.println("Numarul generat random este: " + number);
    }
}
