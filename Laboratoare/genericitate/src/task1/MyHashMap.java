package task1;

import java.util.ArrayList;

public class MyHashMap<Key, Value> {

    public class Entry {
        private Key key;
        private Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    private ArrayList<Entry> entries;

    public MyHashMap() {
        this.entries = new ArrayList<>();
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public void put(Key key, Value value) {
        for(Entry entry : entries) {
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        //if key not found
        entries.add(new Entry(key, value));
    }

    public Value get(Key key) {
        for(Entry entry : entries) {
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        System.out.println("Can't find key");
        return null;
    }
}
