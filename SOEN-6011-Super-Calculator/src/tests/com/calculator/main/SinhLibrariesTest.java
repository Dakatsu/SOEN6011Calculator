package tests.com.calculator.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.main.SinhLibraries;

/**
 * A series of unit tests for the Sinh Library functions.
 * @author Kyle
 *
 */
class SinhLibrariesTest {
	
	@Test 
	void sinhTest() {
		assertEquals(0, SinhLibraries.sinh("0"));
		assertEquals(0, SinhLibraries.sinh("0."));
		assertEquals(0, SinhLibraries.sinh(".0"));
		assertEquals(0, SinhLibraries.sinh("0.0"));

		assertEquals(Double.POSITIVE_INFINITY, SinhLibraries.sinh("710"));
		assertEquals(Double.NEGATIVE_INFINITY, SinhLibraries.sinh("-710"));
	}
	
	@Test 
	void gcdTest() {
		assertEquals(0, SinhLibraries.gcd(0, 0));
		assertEquals(1, SinhLibraries.gcd(0, 1));
		assertEquals(1, SinhLibraries.gcd(1, 0));
		assertEquals(3, SinhLibraries.gcd(3, 3));
		assertEquals(15, SinhLibraries.gcd(15, 45));
		assertEquals(15, SinhLibraries.gcd(45, 15));
	}
	
	@Test 
	void absTest() {
		assertEquals(0, SinhLibraries.abs(0));
		assertEquals(5, SinhLibraries.abs(5));
		assertEquals(5, SinhLibraries.abs(-5));
		assertEquals(Long.MAX_VALUE, SinhLibraries.abs(Long.MAX_VALUE));
		assertEquals(Long.MAX_VALUE, SinhLibraries.abs(Long.MIN_VALUE + 1));
	}
}
