public class F5 {

    public static double F5(double a,double b,int x) {
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