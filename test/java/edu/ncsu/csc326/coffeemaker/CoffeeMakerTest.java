package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    @Before
    public void setUp() throws Exception {
        cm = new CoffeeMaker();


        //Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");

    }
    @Test
    public void addRecipeTest() {
        assertTrue(cm.addRecipe(r1));
    }
    @Test
    public void deleteRecipeTest() {
        cm.addRecipe(r1);
        cm.addRecipe(r2);
        //Index 0 because when user is asked for input they -1 before calling the method...
        assertEquals("Coffee", cm.deleteRecipe(0));
    }
    @Test
    public void EditRecipeTest() {
        cm.addRecipe(r1);
        cm.addRecipe(r2);
        cm.editRecipe(0, r2);
    }
    @Test
    public void testCheckInventory() {
    StringBuffer buf = new StringBuffer();
        buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");

        assertEquals(buf.toString(), cm.checkInventory());
    }
    @Test
    public void testAddInventory() {
        StringBuffer buf = new StringBuffer();

        buf.append("Coffee: ");
        buf.append(16);
        buf.append("\n");
        buf.append("Milk: ");
        buf.append(17);
        buf.append("\n");
        buf.append("Sugar: ");
        buf.append(18);
        buf.append("\n");
        buf.append("Chocolate: ");
        buf.append(19);
        buf.append("\n");
        try {
            cm.addInventory("1", "2", "3", "4");
        }
        catch (InventoryException e) {
            fail("Not good");
        }
        assertEquals(buf.toString(), cm.checkInventory());
    }
    @Test
    public void testAddInventoryException() {
        assertThrows(InventoryException.class, () -> cm.addInventory("-1", "-2", "-3", "-4"));
    }

    @Test
    public void testMakeCoffee() {
        cm.addRecipe(r1);
        assertEquals(0, cm.makeCoffee(0, 50));
        assertEquals(10, cm.makeCoffee(0, 60));
        assertEquals(40, cm.makeCoffee(0, 40));
    }

    @Test
    public void testGetRecipes() {
        cm.addRecipe(r1);
        cm.addRecipe(r2);
        Recipe[] arr = {r1, r2, null, null};
        assertArrayEquals(arr, cm.getRecipes());
    }
}
