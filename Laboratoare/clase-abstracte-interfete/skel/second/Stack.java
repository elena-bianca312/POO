package second;
import first.*;

public class Stack extends ContainerClass{

    @Override
    public Task pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }

    @Override
    public void transferFrom(Container container) {
        while(!container.isEmpty()) {
            push(container.pop());
        }
    }
}
