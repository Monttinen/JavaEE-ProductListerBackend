/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        String expResult = "";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryDescription method, of class Category.
     */
    @Test
    public void testGetCategoryDescription() {
        System.out.println("getCategoryDescription");
        Category instance = new Category();
        String expResult = "";
        String result = instance.getCategoryDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryParentId method, of class Category.
     */
    @Test
    public void testGetCategoryParentId() {
        System.out.println("getCategoryParentId");
        Category instance = new Category();
        int expResult = 0;
        int result = instance.getCategoryParentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryId method, of class Category.
     */
    @Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        Category instance = new Category();
        int expResult = 0;
        int result = instance.getCategoryId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String CategoryName = "";
        Category instance = new Category();
        instance.setCategoryName(CategoryName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryDescription method, of class Category.
     */
    @Test
    public void testSetCategoryDescription() {
        System.out.println("setCategoryDescription");
        String CategoryDescription = "";
        Category instance = new Category();
        instance.setCategoryDescription(CategoryDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
