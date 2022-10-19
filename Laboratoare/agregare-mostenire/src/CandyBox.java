import java.util.Objects;

public class CandyBox {

    private String flavor;
    private String origin;

    public String getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public CandyBox() {
        this.flavor = "";
        this.origin = "";
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor=" + flavor +
                ", origin=" + origin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(flavor, candyBox.flavor) &&
                Objects.equals(origin, candyBox.origin);
    }

    public void printDim() {
    }

}
