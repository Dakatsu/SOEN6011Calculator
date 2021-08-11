package com.calculator.main;

/**
 * The Class PowerFunction related to the implementation of function F5, Power Function a*(b^x).
 */
public class F5 {

    public static final double E = 2.7182818284590451;
    public static final int EXPANSION = 60;// default Taylor expansion times
    public static final double LN2 = 0.6931471805599453;// value of ln(2)

    /**
     * Calculate the value of a*(b^x)
     * 
     * @param a double type
     * @param b base number,double type
     * @param x exponent number,double type
     * @return a*(b^x) double type
     */
    public static double calculate(double a, double b, double x) {
        if (a == 0) {
            return 0;
        }
        return a * power(b, x);
    }

    /**
     * Calculate the value of e^x
     * 
     * @param x exponent number,double type
     * @param n the number of Taylor expansions,integer type
     * @return e^x double type
     */
    public static double ex(double x, int n) {
        double result = 1.0;
        double tmp = 1;
        for (int i = 1; i <= n; i++) {
            tmp *= i;
            result += power(x, i) / tmp;
        }
        return result;
    }

    /**
     * Calculate the value of ln(x).According to the Taylor expansion for ln(x+1),(-1<x<=1)
     * 
     * @param x domain is (0,2],double type
     * @param n the number of Taylor expansions,integer type
     * @return ln(x) double type
     */
    public static double lnBase(double x, int n) {
        x -= 1;
        int factor = 1;
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            result += factor * power(x, i) / i;
            factor = -factor;
        }
        return result;
    }

    /**
     * Calculate the value of ln(x).
     * 
     * @param x double type
     * @return ln(x) double type
     */
    public static double ln(double x) {
        double result = 0.0;
        while (x > 2) {
            result += LN2;
            x /= 2;
        }
        result += lnBase(x, EXPANSION);
        return result;
    }

    /**
     * Calculate the value of a^x
     * 
     * @param a base number,double type
     * @param x exponent number,integer type
     * @return a^x double type
     */
    public static double power(double a, int x) {
        if (x == 0)
            return 1.0;
        if (a == 0)
            return 0.0;
        int b = x;
        if (b < 0)
            b = -b;
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

    /**
     * Calculate the value of a^x.According to a^x=e^(x*ln(a))
     * 
     * @param a base number,double type
     * @param x exponent number,double type
     * @return a^x double type
     */
    public static double power(double a, double x) {
        if (x == 0)
            return 1.0;
        if (a == 0)
            return 0.0;
        double exp = x * ln(a);// If the value of exp is large, substituting exp into the function
                               // ex may cause the calculation to overflow.
        int integer = (int) exp;
        double decimal = exp - integer;
        double result = power(E, integer) * ex(decimal, EXPANSION);
        return result;
    }

    /**
     * Calculate absolute value of the input number
     * 
     * @param x double type
     * @return absolute value of x, double type
     */
    public static double abs(double x) {
        if (x < 0)
            x = -x;
        return x;
    }

}
