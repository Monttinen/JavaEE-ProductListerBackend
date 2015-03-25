package fi.jamk.productlisterbackend.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G7786
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductId method, of class Product.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductCategoryId method, of class Product.
     */
    @Test
    public void testGetProductCategoryId() {
        System.out.println("getProductCategoryId");
        Product instance = new Product();
        instance.setProductCategoryId(123);
        int expResult = 123;
        int result = instance.getProductCategoryId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product();
        instance.setProductName("tuote1");
        String expResult = "tuote1";
        String result = instance.getProductName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductBarcode method, of class Product.
     */
    @Test
    public void testGetProductBarcode() {
        System.out.println("getProductBarcode");
        Product instance = new Product();
        instance.setProductBarcode("123332");
        String expResult = "123332";
        String result = instance.getProductBarcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductCategoryId method, of class Product.
     */
    @Test
    public void testSetProductCategoryId() {
        System.out.println("setProductCategoryId");
        int ProductCategoryId = 23;
        Product instance = new Product();
        instance.setProductCategoryId(ProductCategoryId);
        assertEquals(ProductCategoryId, instance.getProductCategoryId());
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String ProductName = "tuote2";
        Product instance = new Product();
        instance.setProductName(ProductName);
        assertEquals(ProductName, instance.getProductName());
    }

    /**
     * Test of setProductBarcode method, of class Product.
     */
    @Test
    public void testSetProductBarcode() {
        System.out.println("setProductBarcode");
        String ProductBarcode = "32223";
        Product instance = new Product();
        instance.setProductBarcode(ProductBarcode);
        assertEquals(ProductBarcode, instance.getProductBarcode());
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        instance.setProductBarcode("123");
        instance.setProductCategoryId(44);
        instance.setProductName("tuote33");
        
        String expResult = "id: "+instance.getProductId()+", name: "+instance.getProductName()+", categoryId: "+instance.getProductCategoryId()+", barcode: "+instance.getProductBarcode();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
