package com.calculator.test;

import static org.junit.Assert.assertEquals;

import com.calculator.main.PowerFunction;
import com.calculator.main.SuperCalculator;
import org.junit.Test;



/** The Class PowerFunctionTest. */
public class PowerFunctionTest {

  /** Numeric input check test. */
  @Test
  public void numericInputCheckTest() {
    assertEquals(true, SuperCalculator.numericInputCheck("123"));
    assertEquals(true, SuperCalculator.numericInputCheck("120.9"));
    assertEquals(false, SuperCalculator.numericInputCheck("sss"));
    assertEquals(false, SuperCalculator.numericInputCheck(", .!?"));
    assertEquals(false, SuperCalculator.numericInputCheck("----"));
    assertEquals(false, SuperCalculator.numericInputCheck("@~#"));
  }

  /**
   * Test Case Id : F7_TestCase_1 Test cases for Requirement Id : F7-R1 test if X(0) to the power of
   * Y(0)=1.0
   */
  @Test
  public void zeroPowerofZero() {
    assertEquals(1.0, PowerFunction.calculate(0, 0), 0);
  }

  /**
   * Test Case Id : F7_TestCase_2 Test cases for Requirement Id : F7-R2 test if X(0) to the power of
   * Y(Real Number)=0.0
   */
  @Test
  public void zeroPowerofRealNumber() {
    assertEquals(0.0, PowerFunction.calculate(0, 3), 0);
  }

  /**
   * Test Case Id : F7_TestCase_3 Test cases for Requirement Id : F7-R3 test if X(Positive Number)
   * to the power of Y(0)=1.0
   */
  @Test
  public void positiveNumberPowerofZero() {
    assertEquals(1.0, PowerFunction.calculate(7, 0), 0);
  }

  /**
   * Test Case Id : F7_TestCase_4 Test cases for Requirement Id : F7-R4 test if X(Negative Number)
   * to the power of Y (0)=1.0
   */
  @Test
  public void negativeNumberPowerofZero() {
    assertEquals(1.0, PowerFunction.calculate(-4, 0), -1);
  }

  /**
   * Test Case Id : F7_TestCase_5 Test cases for Requirement Id : F7-R5 test if X(Positive Number)
   * to the power of Y(1)= x.
   */
  @Test
  public void positiveNumberPowerofOne() {
    assertEquals(7.0, PowerFunction.calculate(7, 1), 0);
  }

  /**
   * Test Case Id : F7_TestCase_6 Test cases for Requirement Id : F7-R6 test if X(Positive Number)
   * to the power of Y(Positive Number)= Positive Number.
   */
  @Test
  public void positiveNumberPowerofPositiveNumber() {
    assertEquals(1953125.0, PowerFunction.calculate(5, 9), 0);
  }

  /**
   * Test Case Id : F7_TestCase_7 Test cases for Requirement Id : F7-R7 test if X(Negative Number)
   * to the power of Y(Positive Even Number)= Positive Number.
   */
  @Test
  public void negativeNumberPowerofPositiveEvenNumber() {
    assertEquals(3.1631340244069614E-245, PowerFunction.calculate(-3, 4.4), -1);
  }

  /**
   * Test Case Id : F7_TestCase_8 Test cases for Requirement Id : F7-R8 test if X(Negative Number)
   * to the power of Y(Positive Odd Number)= Negative Number.
   */
  @Test
  public void negativeNumberPowerofPositiveOddNumber() {
    assertEquals(-729, PowerFunction.calculate(-9, 3), 0);
  }
}
