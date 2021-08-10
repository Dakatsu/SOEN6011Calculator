package tests.com.calculator.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.main.SinhLibraries;

/**
 * A series of unit tests for the Sinh Library functions.
 * @author Kyle
 */
class SinhLibrariesTest {
	
	@Test 
	void sinhZeroes() {
		assertEquals(0, SinhLibraries.sinh("0"));
		assertEquals(0, SinhLibraries.sinh("0."));
		assertEquals(0, SinhLibraries.sinh(".0"));
		assertEquals(0, SinhLibraries.sinh("0.0"));
	}
	
	@Test 
	void sinhPosOne() {
		assertEquals(1.1752012, SinhLibraries.sinh("1"), 0.0000001);
	}
	
	@Test 
	void sinhNegOne() {
		assertEquals(-1.1752012, SinhLibraries.sinh("-1"), 0.0000001);
	}
	
	@Test 
	void sinhPosTwo() {
		assertEquals(3.6268604, SinhLibraries.sinh("2"), 0.0000001);
	}
	
	@Test 
	void sinhNegTwo() {
		assertEquals(-3.6268604, SinhLibraries.sinh("-2"), 0.0000001);
	}
	
	@Test 
	void sinhDouble() {
		assertEquals(-8.8482332, SinhLibraries.sinh("-2.876543"), 0.03125);
	}
	
	@Test 
	void sinhPosInfinity() {
		assertEquals(Double.POSITIVE_INFINITY, SinhLibraries.sinh("710"));
		assertEquals(Double.POSITIVE_INFINITY, SinhLibraries.sinh("Infinity"));
	}
	
	@Test 
	void sinhNegInfinity() {
		assertEquals(Double.NEGATIVE_INFINITY, SinhLibraries.sinh("-710"));
		assertEquals(Double.NEGATIVE_INFINITY, SinhLibraries.sinh("-Infinity"));
	}
	
	@Test 
	void sinhExponentInput() {
		assertThrows(NumberFormatException.class, () -> {
			SinhLibraries.sinh("5.690484e304");
		});
	}
	
	@Test 
	void sinhEmptyInput() {
		assertThrows(NumberFormatException.class, () -> {
			SinhLibraries.sinh("");
		});
	}
	
	@Test 
	void sinhBadInput() {
		assertThrows(NumberFormatException.class, () -> {
			SinhLibraries.sinh("-ifjfj");
		});
	}
	
	@Test 
	void rootOfOne() {
		// nth root of 1 should always be precisely 1.
		assertEquals(1.0, SinhLibraries.root(2, 1), Double.MIN_VALUE);
		assertEquals(1.0, SinhLibraries.root(3, 1), Double.MIN_VALUE);
		assertEquals(1.0, SinhLibraries.root(4, 1), Double.MIN_VALUE);
	}
	
	@Test 
	void rootAboveOne() {
		assertEquals(1.4142, SinhLibraries.root(2, 2), 0.03125);
		assertEquals(1.2599, SinhLibraries.root(3, 2), 0.03125);
		assertEquals(0.9876, SinhLibraries.root(4, 0.9513), 0.03125);
	}
	
	@Test 
	void rootBelowOne() {
		assertEquals(0.5, SinhLibraries.root(2, 0.25), 0.03125);
		assertEquals(0.5, SinhLibraries.root(3, 0.125), 0.03125);
		assertEquals(0.5, SinhLibraries.root(3, 0.125), 0.03125);
	}
	
	@Test 
	void gcdBothZero() {
		assertEquals(0, SinhLibraries.gcd(0, 0));
	}
	
	@Test 
	void gcdZeroAndOne() {
		assertEquals(1, SinhLibraries.gcd(0, 1));
		assertEquals(1, SinhLibraries.gcd(1, 0));
	}
	
	@Test 
	void gcdFactors() {
		assertEquals(3, SinhLibraries.gcd(3, 3));
		assertEquals(15, SinhLibraries.gcd(15, 45));
		assertEquals(15, SinhLibraries.gcd(45, 15));
	}
	
	@Test 
	void gcdLargerInts() {
		assertEquals(7, SinhLibraries.gcd(385, 623));
	}
	
	@Test 
	void absZero() {
		assertEquals(0, SinhLibraries.abs(0));
	}
	
	@Test 
	void absPositive() {
		assertEquals(5, SinhLibraries.abs(5));
		assertEquals(Long.MAX_VALUE, SinhLibraries.abs(Long.MAX_VALUE));
	}
	
	@Test 
	void absNegative() {
		assertEquals(5, SinhLibraries.abs(-5));
		assertEquals(Long.MAX_VALUE, SinhLibraries.abs(-Long.MAX_VALUE));
	}
}
