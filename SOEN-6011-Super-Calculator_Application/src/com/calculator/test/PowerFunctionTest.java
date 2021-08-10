package com.calculator.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.calculator.main.PowerFunction;
import com.calculator.main.SuperCalculator;

public class PowerFunctionTest {
  
 PowerFunction powerFunction = new PowerFunction();
 SuperCalculator calculator =  new SuperCalculator();
 
  @Test
  public void isNumeric() {
    assertEquals(true,SuperCalculator.numericInputCheck("123"));
    assertEquals(true,SuperCalculator.numericInputCheck("120.9"));
    assertEquals(false,SuperCalculator.numericInputCheck("sss"));
    assertEquals(false,SuperCalculator.numericInputCheck(", .!?"));
    assertEquals(false,SuperCalculator.numericInputCheck("----"));
    assertEquals(false,SuperCalculator.numericInputCheck("@~#"));
  }
  

  /**
   * test if x^0=1
   */
  @Test
  public void realNumberRaisedToZero() {
    assertEquals(1.0, powerFunction.calculate(5.698468,0), 0);
  }

  /**
   * test if x^1=x
   */
  @Test
  public void realNumberExceptZeroRaisedToOne() {
    assertEquals(72645.3625892, powerFunction.calculate(72645.3625892,1), 0);
  }

  /**
   * test if 0^0=1
   */
  @Test
  public void zeroRaisedToZero() {
    assertEquals(1.0, powerFunction.calculate(0,0), 0);
  }

  /**
   * test if 0^y=0
   */
  @Test
  public void zeroRaisedToRealNumber() {
    assertEquals(0.0, powerFunction.calculate(0,856954745.2545523), 0);
  }

  /**
   * test if -x^(odd)y =-result
   */
  @Test
  public void negativeRealNumberRaisedToOddRealNumber() {

    assertEquals(-16384, powerFunction.calculate(-4,7), 0);
  }

  /**
   * test if -x^(even)y=+result
   */
  @Test
  public void negativeRealNumberRaisedToEvenRealNumber() {
    assertEquals(65536, powerFunction.calculate(-4,8), 0);
  }

}
