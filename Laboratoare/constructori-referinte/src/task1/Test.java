package task1;

public class Test {

    public static void main(String[] args) {
        Complex nr1 = new Complex(4,5);
        Complex nr2 = new Complex(3,2);
        Complex nr3 = new Complex();
        nr3.showNumber();
        nr1.addWithComplex(nr2);
    }

}
