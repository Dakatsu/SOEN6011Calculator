
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * This class is test class for function 5
 */
public class TestF5 {

    public static final double EPSON = 0.000000000001;// allowable error

    /**
     * Set a=0, output is 0. When x=0, output is a
     */
    @Test
    public void testF5() {
        double y = F5.f5(0, 19, 2);
        double expectY = 0;
        assertTrue(y == expectY);
        y = F5.f5(2, 10, 0);
        expectY = 2;
        assertTrue(y == expectY);
    }

    /**
     * test f5 with positive exponent
     */
    @Test
    public void testF5PositiveX() {
        double y = F5.f5(1.0, 3.4, 10);
        double expectY = 206437.77540597753;
        assertTrue((y - expectY < EPSON) || (expectY - y < EPSON));
    }

    /**
     * test f5 with negative exponent
     */
    @Test
    public void testF5NegativeX() {
        double y = F5.f5(2.0, -3.4, -10);
        double expectY = 9.6881493518656114e-006;
        assertTrue((y - expectY < EPSON) || (expectY - y < EPSON));
    }
}
