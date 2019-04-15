package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Note: ");
        int note = in.nextInt();
        String notenString;

        switch(note){
            case 1: notenString = "Sehr gut";
                    break;
            case 2: notenString = "Gut";
                    break;
            case 3: notenString = "Befriedigend";
                    break;
            case 4: notenString = "Ausreichend";
                    break;
            case 5: notenString = "Mangelhaft";
                    break;
            case 6: notenString = "Ungenügend";
                    break;
            default: notenString = "Fehlerhafte Eingabe";
        }

        System.out.println(notenString);

        in.close();
    }
}