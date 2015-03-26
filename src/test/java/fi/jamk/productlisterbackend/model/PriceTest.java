package fi.jamk.productlisterbackend.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti Minkkinen
 */
public class PriceTest {
    
    public PriceTest() {
    }

    /**
     * Test of toString method, of class Price.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Price p = new Price();
        p.setProductId(12);
        p.setShopId(33);
        p.setQuantityPrice(10.0);
        p.setUnitPrice(-1.0);
        String expResult = "Price of productId 12 at shopId 33: q:10.0 u:-1.0";
        String result = p.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Price.
     */
    @Test
    public void testIsValid_valid() throws Exception {
        System.out.println("isValid");
        Price p = new Price();
        p.setQuantityPrice(10.0);
        p.setUnitPrice(-1.0);
        boolean expResult = true;
        boolean result = p.isValid();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValid method, of class Price. Should throw Exception
     */
    @Test(expected = Exception.class)
    public void testIsValid_notvalid() throws Exception {
        System.out.println("isValid");
        Price p = new Price();
        p.setQuantityPrice(-1.0);
        p.setUnitPrice(-1.0);
        boolean expResult = false;
        boolean result = p.isValid();
    }
}
