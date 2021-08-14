/*
 * Unit test cases for tangent function
 * @Author Rokeya Begum Keya
 */

package com.calculator.test;

import static org.junit.Assert.assertEquals;

import com.calculator.main.TangentFunction;
import org.junit.Test;



// TODO: Auto-generated Javadoc
/** The Class TangentFunctionTest. */
public class TangentFunctionTest {

  /** Tan zero check. */
  @Test
  public void tanZeroCheck() {
    assertEquals("0", TangentFunction.getTan(0));
  }

  /** Tan forty check. */
  @Test
  public void tanFortyCheck() {
    assertEquals("0.83910101", TangentFunction.getTan(40));
  }

  /** Tan ninety check. */
  @Test
  public void tanNinetyCheck() {
    assertEquals("undefined", TangentFunction.getTan(90));
  }

  /** Tan negative value check. */
  @Test
  public void tanNegativeValueCheck() {
    assertEquals("-11.43005230", TangentFunction.getTan(95));
  }

  /** Tan negative number check. */
  @Test
  public void tanNegativeNumberCheck() {
    assertEquals("-0.17723233", TangentFunction.getTan(-10));
  }

  /** Tan one hundred and eighty check. */
  @Test
  public void tanOneHundredAndEightyCheck() {
    assertEquals("0", TangentFunction.getTan(180));
  }

  /** Gets the rad check. */
  @Test
  public void getRadCheck() {
    assertEquals(1.570796326794895, TangentFunction.getRad(90), 0.00001);
  }

  /** Gets the rad one hundred and eighty check. */
  @Test
  public void getRadOneHundredAndEightyCheck() {
    assertEquals(3.14159265358979, TangentFunction.getRad(180), 0.00001);
  }

  /** Gets the sin zero check. */
  @Test
  public void getSinZeroCheck() {
    assertEquals(0.0, TangentFunction.getSin(0), 0.1);
  }

  /** Gets the sin forty check. */
  @Test
  public void getSinFortyCheck() {
    assertEquals(0.6427875016052101, TangentFunction.getSin(40), 0.00001);
  }

  /** Gets the cos zero check. */
  @Test
  public void getCosZeroCheck() {
    assertEquals(1.0, TangentFunction.getCos(0), 0.1);
  }

  /** Gets the cos forty check. */
  @Test
  public void getCosFortyCheck() {
    assertEquals(0.7660430511524988, TangentFunction.getCos(40), 0.00001);
  }
}
