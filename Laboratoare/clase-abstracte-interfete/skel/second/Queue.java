package second;
import first.*;

public class Queue extends ContainerClass{

    @Override
    public Task pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public void push(Task task) {
        list.add(0, task);
    }

    @Override
    public void transferFrom(Container container) {
        while(!container.isEmpty()) {
            push(container.pop());
        }
    }
}
