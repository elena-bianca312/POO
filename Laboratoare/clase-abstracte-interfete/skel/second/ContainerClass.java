package second;
import first.Task;
import java.util.ArrayList;

public abstract class ContainerClass implements Container{

    ArrayList<Task> list = new ArrayList<Task>();

    public ArrayList<Task> getTasks() {
        return list;
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
