package so;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestF5 {
	public static final double EPSON=0.000000000001;
	
	@Test
	public void testF5PositiveX() {
		double y=F5.f5(1.0, 3.4, 10);
		double expectY=206437.77540597753;
		assertTrue((y-expectY<EPSON)||(expectY-y<EPSON));
	}
	
	@Test
	public void testF5NegativeX() {
		double y=F5.f5(2.0, -3.4, -10);
		double expectY=9.6881493518656114e-006;
		assertTrue((y-expectY<EPSON)||(expectY-y<EPSON));
	}
}
