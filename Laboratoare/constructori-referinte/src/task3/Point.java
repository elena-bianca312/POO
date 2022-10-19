package task3;

public class Point {

    private float coord1;
    private float coord2;

    public float getCoord1() {
        return coord1;
    }

    public void setCoord1(float coord1) {
        this.coord1 = coord1;
    }

    public float getCoord2() {
        return coord2;
    }

    public void setCoord2(float coord2) {
        this.coord2 = coord2;
    }

    public Point(float coord1, float coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    public void changeCoords(float nr1, float nr2) {
        coord1 = nr1;
        coord2 = nr2;
    }

    public void afisare(){
        System.out.println("(" + this.coord1 + "," + this.coord2 + ")");
    }
}
