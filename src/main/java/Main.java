import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int c = 0;
        String d = "hello";
        Scanner scanner = new Scanner(System.in);
        try {
            int a = 5;
            int b = 5;
            c = a / b;
            int k = Integer.parseInt(d);
            System.out.println(k);
        } catch (ArithmeticException | NumberFormatException ex) {
            ex.printStackTrace();
        }
        System.out.println(c);

    }
}
