package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    @Before
    public void setUp() throws Exception{
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtMilk("1");
        r1.setAmtCoffee("2");
        r1.setAmtSugar("3");
        r1.setPrice("15");

        r2 = new Recipe();
        r2.setName("Coffee");
        r2.setAmtChocolate("0");
        r2.setAmtMilk("1");
        r2.setAmtCoffee("2");
        r2.setAmtSugar("3");
        r2.setPrice("15");

        r3 = new Recipe();
        r3.setAmtChocolate("0");
        r3.setAmtMilk("1");
        r3.setAmtCoffee("2");
        r3.setAmtSugar("3");
        r3.setPrice("15");
    }
    @Test
    public void testSetName() {
        String newName = "NewCoffeeName";
        r1.setName(newName);
        assertEquals(newName, r1.getName());
    }
    @Test
    public void testFailSetName() {
        //setName method only checks for null value, not empty string
        /*String oldName = r1.getName();
        String newName = "";
        r1.setName(newName);
        assertEquals(oldName, r1.getName());
         */
        assertThrows(RecipeException.class, () -> r1.setName(""));
        assertThrows(RecipeException.class, () -> r1.setName(null));

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
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate("text"));

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
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("text"));
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
        assertThrows(RecipeException.class, () -> r1.setAmtMilk("text"));
    }
    @Test
    public void testSetAmtSugar() {
        try {
            r1.setAmtSugar("4");
        }
        catch (RecipeException e) {
            fail("Not good");
        }
        assertEquals(4, r1.getAmtSugar());
    }
    @Test
    public void testSetAmtSugarException() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar("-4"));
        assertThrows(RecipeException.class, () -> r1.setAmtSugar("text"));
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
        assertThrows(RecipeException.class, () -> r1.setPrice("text"));
    }
    @Test
    public void TestHashCode() {
        int hash = 31 + (r1.getName().hashCode());
        assertEquals(hash, r1.hashCode());
    }
    @Test
    public void testEquals() {
        //Cannot test equals when name is null
        String str = "TEST";
       assertFalse(r1.equals(str));
       assertTrue(r1.equals(r2));
       assertFalse(r3.equals(r1));
    }
    @Test
    public void testToString() {
        assertEquals(r1.getName(), r1.toString());
    }
    @Test
    public void getNameTest() {
        assertEquals("Coffee", r1.getName());
    }
}
