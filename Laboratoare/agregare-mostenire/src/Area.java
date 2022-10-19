public class Area {

    private CandyBag bag;
    private int number;
    private String street;

    public Area() {
        this.bag = new CandyBag();
        this.number = 0;
        this.street = "";
    }

    public Area(CandyBag bag, int number, String street) {
        this.bag = bag;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println(this.street + " " + this.number + "\n");
        System.out.println("La multi ani, draga mami");

        for(int i = 0; i < this.bag.getCadou().size(); i++)
        {
//            this.bag.getCadou().get(i).toString();
//
//            if(this.bag.getCadou().get(i) instanceof Lindt)
//            {
//                ((Lindt) this.bag.getCadou().get(i)).printLindtDim();
//            }
//            if(this.bag.getCadou().get(i) instanceof Baravelli)
//            {
//                ((Baravelli) this.bag.getCadou().get(i)).printBaravelliDim();
//            }
//            if(this.bag.getCadou().get(i) instanceof ChocAmor)
//            {
//                ((ChocAmor) this.bag.getCadou().get(i)).printChocAmorDim();
//            }

           this.bag.getCadou().get(i).printDim();
        }
    }
}
