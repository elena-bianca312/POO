package first;

public class CounterOutTask implements Task{

    public static int contor = 0;

    public CounterOutTask() {

    }

    public void execute(){
        contor++;
        System.out.println("Valoarea contorului este: " + contor);
    }

}
