package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Erste Zahl: ");
        double num1 = in.nextDouble();
        System.out.print("Zweite Zahl: ");
        double num2 = in.nextDouble();
        System.out.print("Dritte Zahl: ");
        double num3 = in.nextDouble();
        in.close();

        System.out.println("Minimum: " + min(num1, num2, num3));
        System.out.println("Maximum: " + max(num1, num2, num3));
    }

    public static double min(double num1, double num2, double num3){
        double min = num1;
        if(num2 < min)
            min = num2;
        if(num3 < min)
            min = num3;
        return min;
    }

    public static double max(double num1, double num2, double num3){
        double max = num1;
        if(num2 > max)
            max = num2;
        if(num3 > max)
            max = num3;
        return max;
    }
}