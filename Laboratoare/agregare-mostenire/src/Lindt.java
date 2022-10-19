public class Lindt extends CandyBox{

    private float length;
    private float width;
    private float height;

    public Lindt() {
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + this.getFlavor() + " has volume " + this.getVolume();
    }

    public void printLindtDim() {
        System.out.println("length: " + this.length + " width " + this.width + " height: " + this.height);
    }

    public void printDim() {
        System.out.println("length: " + this.length + " width " + this.width + " height: " + this.height);
    }
}
