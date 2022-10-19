import java.util.*;

public class PasswordMaker {

    private static final int MAGIC_NUMBER = 7;
    private static MagicStringGenerator s = new MagicStringGenerator();
    private static int n = 22;
    private static final String MAGIC_STRING = s.getAlphaNumericString(n);

    private static String name;

    private PasswordMaker(String name) {
        this.name = name;
    }

    //Implementarea de singleton
    private static PasswordMaker instance = null;

    private static int contor = 0; //contor static
    public static PasswordMaker getInstance(String name) {
        if(instance == null)
        {
            instance = new PasswordMaker(name);
        }
        contor++;
        System.out.println("contor " + contor);
        return instance;
    }

    //Eager Initialization - bloc static
    static{
        name = "Un nume";
        PasswordMaker instance = new PasswordMaker(name);
    }

    String getPassword(){
        //Generam alfabetul cu 10 caractere din MAGIC_STRING
        RandomStringGenerator gen1 = new RandomStringGenerator(10, MAGIC_STRING);
        String alphabet = gen1.next();

        //Generam parola conform cerintei
        RandomStringGenerator gen2 = new RandomStringGenerator(MAGIC_NUMBER, alphabet);
        int number = (int) ((Math.random() * (100 - 0)) + 0);
        //Conversia la string a sumei (lungimii numelui + numar random)
        String password = gen2.next() + String.valueOf(name.length() + number);

        return password;
    }

    //Testele din main pentru a verifica corectitudinea codului
    public static void main(String[] args) {
        PasswordMaker p1 = PasswordMaker.getInstance("Persoana 1");
        String parola1 = p1.getPassword();
        System.out.println("parola 1 " + parola1);
        System.out.println(p1.name);
        PasswordMaker p2 = PasswordMaker.getInstance("Persoana 2");
        String parola2 = p2.getPassword();
        System.out.println("parola 2 " + parola2);
        System.out.println(p2.name);
    }
}
