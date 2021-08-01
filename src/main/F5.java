package so;

import java.util.Scanner;

public class F5 {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("a:");
		double a=scanner.nextDouble();
		System.out.print("b:");
		double b=scanner.nextDouble();
		System.out.print("x:");
		int x=scanner.nextInt();
		System.out.print("y=a*b^x=");
		System.out.println(F5.f5(a, b, x));
	}
	
	public static double f5(double a,double b,int x) {
		double bx=b*intPower(b, x);
		return a*bx;
	}

	public static double intPower(double a,int x) {
		/**
		 * return the value of a^x
		 */
		if(x==0) {
			return 1.0;
		}
		int b=x;
		if (b<0) {
			b=-b;
		}
		double r=a;
		double y=1;
		while(b>0) {
			if(b%2==0){
				b=b/2;
				r=r*r;
			}else {
				b=b-1;
				y=y*r; 
			}
		}
		if(x<0) {
			return 1/y;
		}else {
			return y;
		}
	}
}
