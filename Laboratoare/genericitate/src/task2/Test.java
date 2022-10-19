package task2;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        SumabilSum sumabilSum = new SumabilSum();
        List<Sumabil> vectorArray = new ArrayList<>();

        Sumabil v1 = new MyVector3(1,2,3);
        Sumabil v2 = new MyVector3(4,5,6);
        Sumabil v3 = new MyVector3(7,8,9);

        vectorArray.add(v1);
        vectorArray.add(v2);
        vectorArray.add(v3);

        System.out.println(vectorArray);
        Sumabil sum = sumabilSum.sum(vectorArray, new MyVector3());
        System.out.println("After adding all the elements: ");
        System.out.println(sum);
        System.out.println();

        List<Sumabil> matrixArray = new ArrayList<>();
        Sumabil m1 = new MyMatrix(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}});
        Sumabil m2 = new MyMatrix(new int[][]{{2,2,2,2}, {2,2,2,2}, {2,2,2,2}, {2,2,2,2}});
        Sumabil m3 = new MyMatrix(new int[][]{{3,3,3,3}, {3,3,3,3}, {3,3,3,3}, {4,4,4,4}});

        matrixArray.add(m1);
        matrixArray.add(m2);
        matrixArray.add(m3);

        for (Sumabil sumabil : matrixArray) {
            System.out.println(sumabil.toString());
        }

        Sumabil sum2 = sumabilSum.sum(matrixArray, new MyMatrix());
        System.out.println("After adding all the elements: ");
        System.out.println(sum2);
    }

}
