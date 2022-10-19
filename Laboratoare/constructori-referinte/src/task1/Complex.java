package task1;

public class Complex {
    private int real;
    private int imaginary;

    //constructor 1
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //constructor 2
    public Complex() {
        this(0, 0);
    }

    //constructor 3
    public Complex(Complex nr) {
        this.real = nr.real;
        this.imaginary = nr.imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void showNumber() {
        System.out.println("Complex number: (" + this.real + "," + this.imaginary + ")");
    }

    public void addWithComplex(Complex nr) {
        this.real = this.real + nr.real;
        this.imaginary = this.imaginary + nr.imaginary;
        this.showNumber();
    }
}


