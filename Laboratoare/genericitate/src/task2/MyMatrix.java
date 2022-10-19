package task2;

import java.util.Arrays;

public class MyMatrix implements Sumabil {

    private int[][] matrix;

    public MyMatrix() {
        matrix = new int[4][4];
    }

    public MyMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getValue(int i, int j) {
        return matrix[i][j];
    }

    @Override
    public void addValue(Sumabil value) {
        MyMatrix newMatrix = (MyMatrix) value;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] += newMatrix.getValue(i, j);
            }
        }
    }

    @Override
    public String toString() {

        String string = "";

        for (int i = 0; i < 4; i++) {
            string = string.concat("[");
            for (int j = 0; j < 4; j++) {
                string = string.concat(matrix[i][j] + ", ");
            }
            string = string.substring(0, string.length() - 2);
            string = string.concat("]; ");
        }

        string = string.substring(0, string.length() - 2);

        return "MyMatrix{" +
                "matrix=" + string +
                '}';
    }
}
