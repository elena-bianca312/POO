import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Lindt bomboana1 = new Lindt("ciocolata", "Africa", 2, 3, 4);
        Lindt bomboana2 = new Lindt("ciocolata", "Africa", 2, 3, 4);

//        System.out.println(bomboana1.toString());
//        System.out.println(bomboana1.equals(bomboana2));


//        Lindt b1 = new Lindt("vanila cream", "Botswana", 3, 7, 5);
//        Baravelli b2 = new Baravelli("mango", "tropice", 2, 5);
//        ChocAmor b3 = new ChocAmor("milka", "Tara romaneasca", 6);
//        ArrayList<CandyBox> list = new ArrayList<CandyBox>();
//        list.add(b1);
//        list.add(b2);
//        list.add(b3);

        CandyBag bag = new CandyBag();
        System.out.println(bag.toString());
//
//        bomboana1.printLindtDim();

        Area area = new Area(bag, 313, "Poli");
        area.getBirthdayCard();


    }

}
