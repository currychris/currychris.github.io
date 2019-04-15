package app;
import java.util.Scanner;

public class App {
    private static final double MWST = 0.19;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Anzahl: ");
        int anzahl = in.nextInt();
        System.out.print("Einzelpreis: ");
        double preis = in.nextDouble();

        System.out.println("Die Rechnung beträgt " + getRechnung(anzahl, preis) + " Euro");

        in.close();
    }

    public static double getRechnung(int anzahl, double preis){
        return anzahl * preis * (1 + MWST) + checkVersand(anzahl);
    }

    public static double checkVersand(int anzahl){
        if(anzahl > 9){
            return 10;
        } else {
            return 0;
        }
    }
}