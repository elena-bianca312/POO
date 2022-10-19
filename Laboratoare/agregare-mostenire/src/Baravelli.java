import java.lang.Math.*;

public class Baravelli extends CandyBox{

    private float radius;
    private float height;

    public Baravelli() {
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) (Math.PI * radius * radius * height);
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + super.getFlavor() + " has volume " + getVolume();
    }

    public void printBaravelliDim() {
        System.out.println("radius: " + this.radius + " height: " + this.height);
    }

    public void printDim() {
        System.out.println("radius: " + this.radius + " height: " + this.height);
    }
}
