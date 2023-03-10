package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;


public class InventoryTest extends TestCase {

    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();
    }

    @Test
    public void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate() {
        inventory.setChocolate(7);
        assertEquals(7, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate() throws InventoryException {
        inventory.addChocolate("3");
        assertEquals(18, inventory.getChocolate());
    }

    @Test
    public void testChocolateException() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("-9"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testAddChocolate_string() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addChocolate("NAN"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee() {
        inventory.setCoffee(7);
        assertEquals(7, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee() throws InventoryException {
        inventory.addCoffee("3");
        assertEquals(18, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee_string() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addCoffee("NAN"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testCoffeeException() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addCoffee("-9"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testSetMilk() {
        inventory.setMilk(7);
        assertEquals(7, inventory.getMilk());
    }

    @Test
    public void testAddMilk() throws InventoryException {
        inventory.addMilk("3");
        assertEquals(18, inventory.getMilk());
    }

    @Test
    public void testAddMilk_string() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addMilk("NAN"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testMilkException() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addMilk("-9"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testSetSugar() {
        inventory.setSugar(7);
        assertEquals(7, inventory.getSugar());
    }

    @Test
    public void testAddSugar() throws InventoryException {
        inventory.addSugar("3");
        assertEquals(18, inventory.getSugar());
    }

    @Test
    public void testAddSugar_string() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addSugar("NAN"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testSugarException() {
        assertThrows(
                InventoryException.class, () -> {
                    inventory.addSugar("-9"); // Should throw an InventoryException
                }
        );
    }

    @Test
    public void testEnoughIngredients() throws RecipeException {
        Recipe r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("99");
        r1.setAmtCoffee("99");
        r1.setAmtMilk("99");
        r1.setAmtSugar("99");
        r1.setPrice("99");

        assertEquals(false, inventory.enoughIngredients(r1));
    }

    @Test
    public void testEnoughIngredientsException() {


        assertThrows(
                RecipeException.class, () -> {
                    Recipe r1 = new Recipe();
                    r1.setName("Coffee");
                    r1.setAmtChocolate("-9");
                    r1.setAmtCoffee("-9");
                    r1.setAmtMilk("-9");
                    r1.setAmtSugar("-9");
                    r1.setPrice("-9");
                    inventory.enoughIngredients(r1);
                }
        );
    }

    @Test
    public void testUseIngredients() throws RecipeException {
        Recipe r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("5");
        r1.setAmtCoffee("5");
        r1.setAmtMilk("5");
        r1.setAmtSugar("5");
        r1.setPrice("5");

        inventory.useIngredients(r1);
        assertEquals(10, inventory.getChocolate());
        assertEquals(10, inventory.getCoffee());
        assertEquals(10, inventory.getMilk());
        assertEquals(10, inventory.getSugar());
    }

    @Test
    public void testUseIngredientsException() throws RecipeException {
        Recipe r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("420");
        r1.setAmtCoffee("420");
        r1.setAmtMilk("420");
        r1.setAmtSugar("420");
        r1.setPrice("420");
        inventory.useIngredients(r1);
    }

    @Test
    public void testToString() {
        assertEquals("Coffee: 15" + "\n" + "Milk: 15" +  "\n" + "Sugar: 15" + "\n" + "Chocolate: 15" + "\n", inventory.toString());

    }
}