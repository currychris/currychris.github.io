package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Rechner (a/b/c/d): ");
        char auswahl = in.nextLine().charAt(0);
        System.out.print("Grenzwert: ");
        int grenzwert = in.nextInt();
        in.close();

        switch(auswahl){
            case 'a': sumA(grenzwert);
                    break;
            case 'b': sumB(grenzwert);
                    break;
            case 'c': sumC(grenzwert);
                    break;
            case 'd': sumD(grenzwert);
                    break;
            default: System.out.println("Fehlerhafte Auswahl");
        }
    }

    public static void sum(int start, int n, int fkt){
        String ausgabe = null;
        int num = 0;
        int sum = 0;
        
        for(int i = start; i <= n; i++){
            num = fkt*i;
            sum += num;
            if(i < n){
                
            } else {

            }
        }
    }

    public static void sumA(int n){
        String ausgabe = null;
        int sum = 0;

        System.out.println("sumA");
        System.out.println("Grenzwert: " + n);
        
        for(int i = 1; i < n; i++){
            ausgabe += i + "+";
            sum += i;
        }
        sum += n;
        ausgabe += n + " = " + sum;
        System.out.println(ausgabe);
    }

    public static void sumB(int n){
        String ausgabe = null;
        int sum = 0;
        int num = 0;

        System.out.println("sumB");
        System.out.println("Grenzwert: " + n);

        for(int i = 1; i < n; i++){
            num = 2*i;
            ausgabe += num + "+";
            sum += num;
        }
        num = 2*n;
        sum += num;
        ausgabe += num + " = " + sum;
        System.out.println(ausgabe);
    }

    public static void sumC(int n){
        String ausgabe = null;
        int sum = 0;

        System.out.println("sumC");
        System.out.println("Grenzwert: " + n);

        for(int i = 0; i < n; i++){
            ausgabe += i*2+1 + "+";
            sum += i*2+1;
        }
    }

    public static void sumD(int n){

    }
}