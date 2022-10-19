package task2;

public class MyVector3 implements Sumabil {

    private int x;
    private int y;
    private int z;

    public MyVector3() {
        x = 0;
        y = 0;
        z = 0;
    }

    public MyVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void addValue(Sumabil value) {
        MyVector3 vector3 = (MyVector3) value;
        x += vector3.getX();
        y += vector3.getY();
        z += vector3.getZ();
    }

    @Override
    public String toString() {
        return "MyVector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
