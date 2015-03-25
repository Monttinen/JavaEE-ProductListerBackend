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
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of getCategoryName method, of class Category.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        Category instance = new Category();
        instance.setCategoryName("testiKategoria");
        String expResult = "testiKategoria";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryDescription method, of class Category.
     */
    @Test
    public void testGetCategoryDescription() {
        System.out.println("getCategoryDescription");
        Category instance = new Category();
        instance.setCategoryDescription("kuvaus testi kategorialle");
        String expResult = "kuvaus testi kategorialle";
        String result = instance.getCategoryDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryParentId method, of class Category.
     */
    @Test
    public void testGetCategoryParentId() {
        System.out.println("getCategoryParentId");
        Category instance = new Category();
        instance.setCategoryParentId(0);
        int expResult = 0;
        int result = instance.getCategoryParentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryId method, of class Category.
     * Cannot currently test this as category id is gotten from database
     */
    /*@Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        Category instance = new Category();
        int expResult = 1; // TODO: get from db when creating
        int result = instance.getCategoryId();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String CategoryName = "setCategoryName";
        Category instance = new Category();
        instance.setCategoryName(CategoryName);
        assertEquals(CategoryName, instance.getCategoryName());
    }

    /**
     * Test of setCategoryParentId method, of class Category.
     */
    @Test
    public void testSetCategoryParentId() {
        System.out.println("setCategoryParentId");
        int CategoryParentId = 0;
        Category instance = new Category();
        instance.setCategoryParentId(CategoryParentId);
        assertEquals(CategoryParentId, instance.getCategoryId());
    }

    /**
     * Test of setCategoryDescription method, of class Category.
     */
    @Test
    public void testSetCategoryDescription() {
        System.out.println("setCategoryDescription");
        String CategoryDescription = "testDescription";
        Category instance = new Category();
        instance.setCategoryDescription(CategoryDescription);
        assertEquals(CategoryDescription, instance.getCategoryDescription());
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category();
        instance.setCategoryDescription("desc");
        instance.setCategoryName("name");
        instance.setCategoryParentId(0);
        
        String expResult = "name";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
