package storage;

public abstract class Observer {
    protected DataRepository dataRepository;
    public abstract void update();
}
