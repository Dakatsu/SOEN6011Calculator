package com.calculator.test;

import static org.junit.Assert.assertTrue;

import com.calculator.main.F5;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/** This class is test class for function 5. */
public class F5Test {

  /** The Constant EPSON. */
  public static final double EPSON = 0.0000001; // allowable error

  /** Test function y=e^x. */
  @Test
  public void testEx() {
    double y = F5.ex(2.4, 20);
    double expectY = 11.0231763;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /** Test function lnBase. */
  @Test
  public void testLnBase() {
    double y = F5.lnBase(0.6, 20);
    double expectY = -0.5108256;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /**
   * Test function ln.
   *
   * @throws Exception the exception
   */
  @Test
  public void testLn() throws Exception {
    double y = F5.ln(10.6);
    double expectY = 2.3608540;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /** Test function power(double a,int x). */
  @Test
  public void testIntPower() {
    double y = F5.power(1.6, 7);
    double expectY = 26.8435456;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /**
   * Test function power(double a,double x).
   *
   * @throws Exception the exception
   */
  @Test
  public void testDecimalPower() throws Exception {
    double y = F5.power(5.6, 7.5);
    double expectY = 408705.2369134;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /**
   * Set a=0, output is 0. When x=0, output is a
   *
   * @throws Exception the exception
   */
  @Test
  public void testF5() throws Exception {
    double y = F5.calculate(0, 19, 2);
    double expectY = 0;
    assertTrue(y == expectY);
    y = F5.calculate(2, 10, 0);
    expectY = 2;
    assertTrue(y == expectY);
  }

  /**
   * Test f5 with positive exponent.
   *
   * @throws Exception the exception
   */
  @Test
  public void testF5PositiveX() throws Exception {
    double y = F5.calculate(1.0, 3.4, 5.6);
    double expectY = 946.8516393;
    System.out.println(y);
    assertTrue(F5.abs(y - expectY) < EPSON);
  }

  /**
   * Test f5 with negative exponent.
   *
   * @throws Exception the exception
   */
  @Test
  public void testF5NegativeX() throws Exception {
    double y = F5.calculate(2.0, 3.4, -5.6);
    double expectY = 0.0021122;
    assertTrue(F5.abs(y - expectY) < EPSON);
  }
}
