package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {

    private Recipe r1;

    @Before
    public void setUp() throws Exception{
        r1 = new Recipe();
        r1.setName("TestCoffee");
        r1.setAmtChocolate("0");
        r1.setAmtMilk("1");
        r1.setAmtCoffee("2");
        r1.setAmtSugar("3");
        r1.setPrice("15");
    }
    @Test
    public void testSetName() {

        String newName = "NewCoffeeName";
        r1.setName(newName);
        assertEquals(newName, r1.getName());
            //fail("Exception thrown");
    }
    @Test
    public void testFailSetName() {
        //setName method only checks for null value, not empty string
        String oldName = r1.getName();
        String newName = "";
        r1.setName(newName);
        assertEquals(oldName, r1.getName());
    }
    @Test
    public void testSetAmtChocolate() {
        try {
            r1.setAmtChocolate("1");
        }
        catch (RecipeException e) {
            fail("Not good");
        }
        assertEquals(1, r1.getAmtChocolate());
    }
    @Test
    public void testSetAmtChocolateException() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate("-1"));
    }
    @Test
    public void testSetAmtCoffee() {
        try {
            r1.setAmtCoffee("2");
        }
        catch (RecipeException e) {
            fail("Not good");
        }
        assertEquals(2, r1.getAmtCoffee());
    }
    @Test
    public void testSetAmtCoffeeException() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("-2"));
    }
    @Test
    public void testSetAmtMilk() {
        try {
            r1.setAmtMilk("3");
        }
        catch (RecipeException e) {
            fail("Not good");
        }
        assertEquals(3, r1.getAmtMilk());
    }
    @Test
    public void testSetAmtMilkException() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk("-3"));
    }
    @Test
    public void testSetPrice() {
        try {
            r1.setPrice("23");
        }
        catch (RecipeException e) {
            fail("Not good");
        }
        assertEquals(23, r1.getPrice());
    }
    @Test
    public void testSetPriceException() {
        assertThrows(RecipeException.class, () -> r1.setPrice("-23"));
    }
    @Test
    public void TestHashCode() {
        int hash = 31 + (r1.getName().hashCode());
        assertEquals(hash, r1.hashCode());
    }

    @Test
    public void getNameTest() {
        assertEquals("Coffee", r1.getName());
    }
}
