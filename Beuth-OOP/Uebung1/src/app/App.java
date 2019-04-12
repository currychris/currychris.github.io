package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int input;

        do{   
            System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
            input = scanner.nextInt(); 
        }while(evalInput(input) == false);

        scanner.close();
    }

    private static boolean evalInput(int num){
        if(num > 0) return true;
        return false;
    }
}