
import java.util.Scanner;

/**
 * 
 * This class implement function 5
 * 
 */
public class F5 {

    /**
     * main method, test for f5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a:");
        double a = scanner.nextDouble();
        System.out.print("b:");
        double b = scanner.nextDouble();
        System.out.print("x:");
        int x = scanner.nextInt();
        System.out.print("y=a*b^x=");
        System.out.println(F5.f5(a, b, x));
        scanner.close();
    }

    /**
     * calculate the value of a*(b^x)
     * 
     * @param a double type
     * @param b base number,double type
     * @param x exponent number,integer type
     * @return a*(b^x) double type
     */
    public static double f5(double a, double b, int x) {
        if (a == 0) {
            return 0;
        }
        double bx = intPower(b, x);
        return a * bx;
    }

    /**
     * calculate the value of a^x
     * 
     * @param a base number,double type
     * @param x exponent number,integer type
     * @return a^x double type
     */
    public static double intPower(double a, int x) {
        if (x == 0) {
            return 1.0;
        }
        int b = x;
        if (b < 0) {
            b = -b;
        }
        double r = a;
        double y = 1;
        while (b > 0) {
            if (b % 2 == 0) {
                b = b / 2;
                r = r * r;
            } else {
                b = b - 1;
                y = y * r;
            }
        }
        if (x < 0) {
            return 1 / y;
        } else {
            return y;
        }
    }
}
