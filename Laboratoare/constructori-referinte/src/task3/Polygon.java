package task3;

import java.util.*;
import java.io.*;

public class Polygon {

    private ArrayList<Point> points;

    public Polygon(int n) {
        this.points = new ArrayList<Point>(n);
    }

    public Polygon(float[] array2) {

        this(array2.length/2);
        for(int i = 0; i < array2.length/2; i++) {
            Point point = new Point(array2[2 * i], array2[2 * i + 1]);
            this.points.add(point);
        }
    }

    public void printPolygon() {
        for(int i = 0; i < this.points.size(); i++) {
            this.points.get(i).afisare();
        }
    }
}
