package com.calculator.main;

/**
 * A library of functions related to the implementation of F3, hyperbolic sine
 * (sinh).
 *
 * @author Kyle
 */
public final class SinhLibraries {
	/**
	 * Euler's number.
	 */
	private static final double E = 2.718281828459045;

	/**
	 * The default number of decimal places to parse for the sinh function.
	 */
	private static final int DEFAULT_MAX_DECIMAL_DIGITS = 9;

	/**
	 * The maximum value E can be raised until its double becomes infinity.
	 */
	private static final int MAX_E_EXPONENT = 709;

	// The minimum value E can be raised until its double becomes zero.
	// Not used, but good to know.
	// private static int MIN_E_EXPONENT = -744;

	/**
	 * Hidden constructor for utility class.
	 */
	private SinhLibraries() {
		
	}

	/**
	 * Calculates the hyperbolic sine, or sinh: 1/2(e^x - e^-x). Integer inputs
	 * are accurate up to 12 decimal places. Real numbers vary in accuracy, with
	 * simpler rational parts return more accurate values. Due to floating point
	 * math, anyvalue higher than |709| will return infinity, indicating an
	 * unfathomably large number.
	 *
	 * @param input        The angle to calculate in string form.
	 * @param maxDecDigits The maximum number of post-decimal digits to parse.
	 * @return The result.
	 */
	public static double sinh(final String input, final int maxDecDigits)
			throws NumberFormatException {
		// Refuse input with exponents.
		if (input.toUpperCase().contains("E")) {
			throw new NumberFormatException("This function cannot "
					                      + "handle exponents.");
		}
		// Just spit back infinities if they were input.
		if (input.toUpperCase().equals("INFINITY")) {
			return Double.POSITIVE_INFINITY;
		}
		if (input.toUpperCase().equals("-INFINITY")) {
			return Double.NEGATIVE_INFINITY;
		}
		long intInput = 0;
		int fracNum = 0;
		int fracDen = 0;
		int decimalIdx = input.indexOf(".");
		// If no decimal, just parse as an integer.
		if (decimalIdx == -1) {
			intInput = Long.parseLong(input);
		} else {
			// Otherwise, handle the integral and decimal parts.
			// Get the integral part, if it exists.
			if (decimalIdx != 0 && !input.startsWith("-.")) {
				intInput = Long.parseLong(input.substring(0, decimalIdx));
			}
			if (!input.endsWith(".")) {
				// Separate the real portion into two fractional parts.
				int startIdx = decimalIdx + 1;
				// We can parse up to 9 digits in an int.
				final int maxParsableInt = 9;
				int digitsToParse = maxParsableInt < maxDecDigits
						? maxParsableInt
						: maxDecDigits;
				int endIdx = input.length() < startIdx + digitsToParse
						? input.length()
						: startIdx + digitsToParse;
				String fracNumStr = input.substring(startIdx, endIdx);
				String fracDenStr = "1" + "0".repeat(fracNumStr.length());
				fracNum = Integer.parseInt(fracNumStr);
				fracDen = Integer.parseInt(fracDenStr);
				// Attempt to reduce the fractions via GCD.
				long gcd = gcd(fracNum, fracDen);
				fracNum /= gcd;
				fracDen /= gcd;
				// Raising E higher than MAX_E_EXPONENT returns infinity.
				// To prevent that, clamp the numerator to below it.
				if (fracNum > MAX_E_EXPONENT) {
					fracDen = (int) (fracDen * (long) MAX_E_EXPONENT / fracNum);
					fracNum = MAX_E_EXPONENT;
				}
				// Negate the fractional portion if needed.
				if (input.startsWith("-")) {
					fracNum = -fracNum;
				}
			}
		}
		// Just return zero if the input is zero.
		if (intInput == 0 && fracDen == 0) {
			return 0.0;
		}
		// Return pos/neg infinity if exponent would return infinity anyways.
		if (abs(intInput) > MAX_E_EXPONENT) {
			return intInput > 0 ? Double.POSITIVE_INFINITY
					            : Double.NEGATIVE_INFINITY;
		}
		// Calculate the integer portion.
		double left = powInt(E, (int) intInput);
		double right = powInt(E, (int) (-intInput));
		// Handle the fractional math if necessary.
		if (fracDen > 0) {
			double leftRoot = root(fracDen, powInt(E, fracNum));
			double rightRoot = root(fracDen, powInt(E, -fracNum));
			left *= leftRoot;
			right *= rightRoot;
		}
		return (left - right) * 0.5;
	}

	/**
	 * Calculates the hyperbolic sine, or sinh: 1/2(e^x - e^-x). Integer inputs
	 * are accurate up to 12 decimal places. Real numbers vary in accuracy, with
	 * simpler rational parts return more accurate values. Due to floating point
	 * math, any value higher than |709| will return infinity, indicating an
	 * unfathomably large number. This function will parse the default number
	 * of digits after the decimal point, represented by
	 * DEFAULT_MAX_DECIMAL_DIGITS.
	 *
	 * @param input The angle to calculate in string form.
	 * @return The result.
	 */
	public static double sinh(final String input) throws NumberFormatException {
		return sinh(input, DEFAULT_MAX_DECIMAL_DIGITS);
	}

	/**
	 * Raises a number by a positive or negative integer.
	 *
	 * @param base The input to raise.
	 * @param exp  The exponent.
	 * @return The base raised to the power of the exponent.
	 */
	public static double powInt(final double base, final int exp) {
		double result = 1;
		// If exponent is positive.
		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		// If exponent is negative.
		for (int i = 0; i > exp; i--) {
			result /= base;
		}
		return result;
	}

	/**
	 * Calculates the nth root of a number to double precision.
	 *
	 * @param n    The radix to find.
	 * @param base The number whose root is desired.
	 * @return The nth root of the base number.
	 */
	public static double root(final int n, final double base) {
		double result = base;
		// The root must be between 1 and the base number.
		double step = base < 1 ? (1 - base) / 2 : (base / 2) + 0.5;
		// Dividing a double by 2 will eventually turn it into 0.0.
		while (step > 0.0) {
			double resultSquared = powInt(result, n);
			// Break if we found the exact root.
			if (resultSquared == base) {
				break;
			}
			// Otherwise, step toward the root's location.
			if (resultSquared < base) {
				result += step;
			} else {
				result -= step;
			}
			step /= 2;
		}
		// Return our final result, whether we have the exact root or
		// cannot step closer to it.
		return result;
	}

	/**
	 * Returns the greatest common denominator of two long integers.
	 *
	 * @param left  The first number.
	 * @param right The second number.
	 * @return The greatest common denominator, or zero if left & right are 0.
	 */
	public static long gcd(final long left, final long right) {
		if (abs(right) > abs(left)) {
			return gcd(right, left);
		}
		if (left == 0 && right == 0) {
			return 0;
		}
		for (long i = left; i > 1; i--) {
			if (left % i == 0 && right % i == 0) {
				return i;
			}
		}
		return 1;
	}

	/**
	 * Returns the absolute value of a long integer.
	 *
	 * @param input The input long integer.
	 * @return The absolute value of the input.
	 */
	public static long abs(final long input) {
		return input > 0 ? input : -input;
	}
}
