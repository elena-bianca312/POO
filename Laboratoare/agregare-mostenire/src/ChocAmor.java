public class ChocAmor extends CandyBox{

    private float length;

    public ChocAmor() {
    }

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + super.getFlavor() + " has volume " + getVolume();
    }

    public void printChocAmorDim() {
        System.out.println("length: " + this.length);
    }

    public void printDim() {
        System.out.println("length: " + this.length);
    }
}
