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

    }
}
