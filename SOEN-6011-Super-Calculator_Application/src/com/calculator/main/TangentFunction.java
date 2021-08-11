package com.calculator.main;

public class TangentFunction {

	public String calculate(double parseDouble) {
		  return getTan(parseDouble);
	}

		
//  variable start here
	final static double PI = 3.14159265358979;
	final static double EPS = 1E-2;
	final static double EPSValueForMinimumCheck=1E-10;
	// variable end here

	// helper function or method start here
	public static double getRad (double tempX){
		return ((tempX*PI)/180.0);
	}
	public static double checkIfInsignificant (double tempX){
		return tempX<0? tempX*(-1): tempX;
	}
	// helper function or method end ere

	

	// cos function or method start here
	public static double getCos (double x){
		x=getRad(x);
		// variable start here
		double retVal = 1;
		double tmpResult = 1;
		int i=1;
		// variable end here
		
		for (; ;i+=2){
			
			double value = (-1) * x *x / (i*(i+1));
			
			tmpResult = tmpResult * value;
			
			if (checkIfInsignificant(value)<=EPS) {
				break;
			}
			
			retVal =retVal+ tmpResult;
		}
		return retVal;
	}
	// cos function or method end here

	
	// sin function or method start here
	public static double getSin(double x){
		x=getRad(x);
		// variable start here
		double tmpResult = x;
		double retVal = x;
		int i=0;
		// variable end here
		
		for(; ; ++i){
			
			double value = ((-1)*x*x / ((2*i+2)*(2*i+3)));
			
			tmpResult = tmpResult * value;
			
			if(checkIfInsignificant(value) <= EPS){
				break;
			}
			
			retVal=retVal+tmpResult;
		}
		return retVal;
	}
	// sin function or method end here
	

	// tan function or method start here
	public static String getTan (double x){
		double valueOfSinX=getSin(x);
		double valueOfCosX=getCos(x);

		//System.out.println(valueOfSinX);
		//System.out.println(valueOfCosX);

		
		if(valueOfSinX>=0){
			if(valueOfSinX<EPSValueForMinimumCheck){
				return String.valueOf(0);
			}
		}
		else{
			if((-1*valueOfSinX)<EPSValueForMinimumCheck){
				return String.valueOf(0);
			}
		}
		
		if(valueOfCosX>=0){
			if(valueOfCosX<EPSValueForMinimumCheck){
				return "undefined";
			}
		}else{
			if((-1*valueOfCosX)<EPSValueForMinimumCheck){
				return "undefined";
			}
		}
			
		return String.valueOf(String.format("%.8f", (valueOfSinX/valueOfCosX)));
	}
	// tan function or method end here

}
