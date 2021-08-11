/*
 * Unit test cases for tangent function
 * @Author Rokeya Begum Keya
 */

package com.calculator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calculator.main.TangentFunction;

public class TangentFunctionTest {

	@Test
	public void tanZeroCheck() {
		assertEquals("0", TangentFunction.getTan(0));
	}

	@Test
	public void tanFortyCheck() {
		assertEquals("0.83910101", TangentFunction.getTan(40));
	}

	@Test
	public void tanNinetyCheck() {
		assertEquals("undefined", TangentFunction.getTan(90));
	}

	@Test
	public void tanNegativeValueCheck() {
		assertEquals("-11.43005230", TangentFunction.getTan(95));
	}

	@Test
	public void tanNegativeNumberCheck() {
		assertEquals("-0.17723233", TangentFunction.getTan(-10));
	}

	@Test
	public void tanOneHundredAndEightyCheck() {
		assertEquals("0", TangentFunction.getTan(180));
	}

	@Test
	public void getRadCheck() {
		assertEquals(1.570796326794895, TangentFunction.getRad(90), 0.00001);
	}

	@Test
	public void getRadOneHundredAndEightyCheck() {
		assertEquals(3.14159265358979, TangentFunction.getRad(180), 0.00001);
	}

	@Test
	public void getSinZeroCheck() {
		assertEquals(0.0, TangentFunction.getSin(0), 0.1);
	}

	@Test
	public void getSinFortyCheck() {
		assertEquals(0.6427875016052101, TangentFunction.getSin(40), 0.00001);
	}

	@Test
	public void getCosZeroCheck() {
		assertEquals(1.0, TangentFunction.getCos(0), 0.1);
	}

	@Test
	public void getCosFortyCheck() {
		assertEquals(0.7660430511524988, TangentFunction.getCos(40), 0.00001);
	}

}
