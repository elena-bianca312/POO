package third;

public class Operation implements Plus, Minus, Mult, Div{

    float numar;

    public Operation(float numar) {
        this.numar = numar;
    }

    @Override
    public void div(float operand) {
        if(operand != 0)
            numar /= operand;
    }

    @Override
    public void minus(float operand) {
        numar -= operand;
    }

    @Override
    public void mult(float operand) {
        numar *= operand;
    }

    @Override
    public void plus(float operand) {
        numar += operand;
    }

    public float getNumber() {
        return numar;
    }
}
