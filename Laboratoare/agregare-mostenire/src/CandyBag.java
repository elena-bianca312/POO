import java.util.*;

public class CandyBag {

    private ArrayList<CandyBox> cadou;

    public CandyBag() {
        cadou = new ArrayList<CandyBox>();
        cadou.add(new Lindt("vanila cream", "Botswana", 3, 7, 5));
        cadou.add(new Baravelli("mango", "tropice", 2, 5));
        cadou.add(new ChocAmor("milka", "Tara romaneasca", 6));
    }

    public CandyBag(ArrayList<CandyBox> cadou) {
        this.cadou = cadou;
    }

    @Override
    public String toString() {

        String string = "";
        for(int i = 0; i < cadou.size(); i++)
        {
            string += cadou.get(i).toString();
            string += "\n";
        }
        return string;
    }

    public ArrayList<CandyBox> getCadou() {
        return cadou;
    }

    public void setCadou(ArrayList<CandyBox> cadou) {
        this.cadou = cadou;
    }
}
