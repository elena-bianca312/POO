package storage;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository { // TODO make this an Observable

    private List<SensorData> newData = new LinkedList<>();
    private List<Observer> observers = new ArrayList<>();

    public List<SensorData> getNewData() {
        return newData;
    }

    public void setNewData(List<SensorData> newData) {
        this.newData = newData;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void addData(SensorData dataRecord){
        // TODO
        // store data (e.g. in a List)
        // notify observers
        newData.add(dataRecord);
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    // TODO implement a method to get the stored data (needed by the strategies)
    // getNewData
}


