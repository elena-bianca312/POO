package task1;

import java.util.Objects;

public class Test {

    public static class F1{
        private String name;
        private boolean polePosition;
        private int finalPlace;

        public F1(String name, boolean polePosition, int finalPlace) {
            this.name = name;
            this.polePosition = polePosition;
            this.finalPlace = finalPlace;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPolePosition() {
            return polePosition;
        }

        public void setPolePosition(boolean polePosition) {
            this.polePosition = polePosition;
        }

        public int getFinalPlace() {
            return finalPlace;
        }

        public void setFinalPlace(int finalPlace) {
            this.finalPlace = finalPlace;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, polePosition, finalPlace);
        }

        @Override
        public String toString() {
            return "F1{" +
                    "name='" + name + '\'' +
                    ", polePosition=" + polePosition +
                    ", finalPlace=" + finalPlace +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, F1> myHashMap = new MyHashMap<>();

        F1 verstappen = new F1("Max Verstappen", false, 1);
        F1 hamilton = new F1("Lewis Hamilton", true, 2);
        F1 leclerc = new F1("Charles Leclerc", false, 3);

        myHashMap.put(1, verstappen);
        myHashMap.put(2, hamilton);
        myHashMap.put(3, leclerc);

        for(int i = 1; i <= myHashMap.getEntries().size(); i++) {
            System.out.println(myHashMap.get(i));
        }

        F1 bottas = new F1("Valtteri Bottas", false, 2);
        myHashMap.put(2, bottas);
        System.out.println();

        for(int i = 1; i <= myHashMap.getEntries().size(); i++) {
            System.out.println(myHashMap.get(i));
        }

        //example for null
        System.out.println(myHashMap.get(420));
    }

}
