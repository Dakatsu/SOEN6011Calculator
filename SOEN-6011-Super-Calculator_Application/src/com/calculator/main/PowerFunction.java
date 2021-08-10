package com.calculator.main;

public class PowerFunction {

	double calculate(double firstRealNumber, double secondRealNumber) {
		double result = 1.0;
		result = powerBySquaring(result, firstRealNumber, secondRealNumber);
		final double baseFraction = secondRealNumber - (int) secondRealNumber;
		if (baseFraction > 0.1f) {
			final int result1 = (int) (Double.doubleToLongBits(firstRealNumber) >> 32);
			final int result2 = (int) (baseFraction * (result1 - 1072632447) + 1072632447);
			return result * Double.longBitsToDouble(((long) result2) << 32);
		}
		return result;
	}

	double powerBySquaring(double power, double firstRealNumber, double secondRealNumber) {
		int exponent = (int) secondRealNumber;
		double base = firstRealNumber;
		while (exponent != 0) {
			if ((exponent & 1) != 0) {
				power *= base;
			}
			base *= base;
			exponent >>= 1;
		}
		return power;
	}
}
