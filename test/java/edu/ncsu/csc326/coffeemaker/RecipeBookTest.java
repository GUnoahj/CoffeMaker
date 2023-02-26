package edu.ncsu.csc326.coffeemaker;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class RecipeBookTest{

RecipeBook rb;
Recipe r1,r2,r3,r4,r5;


int expected_size =4;


@Before
public void setUp() throws Exception{
    rb = new RecipeBook();
    
    r1 = new Recipe();
    r1.setName("Expresso");
    r1.setPrice("30");
    r1.setAmtSugar("0");
    r1.setAmtMilk("0");
    r1.setAmtCoffee("10");
    r1.setAmtChocolate("0");


    
    r2 = new Recipe();
    r2.setName("Chocolate Milk");
    r2.setPrice("15");
    r2.setAmtSugar("10");
    r2.setAmtMilk("15");
    r2.setAmtCoffee("0");
    r2.setAmtChocolate("15");


    r3 = new Recipe();
    r3.setName("Coffee with Milk");
    r3.setPrice("40");
    r3.setAmtSugar("0");
    r3.setAmtMilk("20");
    r3.setAmtCoffee("25");
    r3.setAmtChocolate("0");


    r4 = new Recipe();
    r4.setName("Sweet coffee");
    r4.setPrice("45");
    r4.setAmtSugar("20");
    r4.setAmtMilk("5");
    r4.setAmtCoffee("25");
    r4.setAmtChocolate("0");


    r5 = new Recipe();
    r5.setName("Milk");
    r5.setPrice("10");
    r5.setAmtSugar("0");
    r5.setAmtMilk("25");
    r5.setAmtCoffee("0");
    r5.setAmtChocolate("0");

}


@Test
public void testGetEmptyRecipes(){
    Recipe[] rec_arr = rb.getRecipes();
    
    //check array size
    assertEquals(expected_size,rec_arr.length);
    
    for(int i=0; i<expected_size; i++){
        assertEquals(null,rec_arr[i]);        
    }
}



@Test
public void testDeleteNotInserted(){
    String str = rb.deleteRecipe(0);
    
    //check array size
    assertEquals(null,str);
    
}



@Test
public void testEditNotInserted(){
    String str = rb.editRecipe(0,r5);
    
    //check array size
    assertEquals(null,str);
}



@Test
public void testAddRecipe(){
    boolean b = rb.addRecipe(r1);
    
    assertEquals(true,b);

    b = rb.addRecipe(r2);
    assertEquals(true,b);

    Recipe[] rarr = rb.getRecipes();

    assertEquals(rarr[0],r1);
    assertEquals(rarr[1],r2);
    assertEquals(rarr[2],null);
}


@Test
public void testAddDuplicate(){
    boolean b = rb.addRecipe(r1);
    assertEquals(true,b);

    b = rb.addRecipe(r1);
    assertEquals(false,b);

    Recipe[] rarr = rb.getRecipes();

    if(rarr[1] == r1){
        fail();
    }

    assertEquals(rarr[1],null);
}



@Test
public void testAddMoreThanLimit(){
    boolean b = rb.addRecipe(r1);
    assertEquals(true,b);

    b = rb.addRecipe(r2);
    assertEquals(true,b);

    b = rb.addRecipe(r3);
    assertEquals(true,b);

    b = rb.addRecipe(r4);
    assertEquals(true,b);

    b = rb.addRecipe(r5);
    assertEquals(false,b);
}


@Test
public void testGetAllRecipes(){
     rb.addRecipe(r1);
     rb.addRecipe(r2);
     rb.addRecipe(r3);
     rb.addRecipe(r4);

     Recipe[] test = {r1,r2,r3,r4};

     Recipe[] rarr= rb.getRecipes();

     for (int i=0; i<expected_size; i++){
         assertEquals(test[i],rarr[i]);
     }
}


@Test
public void testDeleteRecipe(){
    rb.addRecipe(r1);
    rb.addRecipe(r2);
    rb.addRecipe(r3);
    rb.addRecipe(r4);

    Recipe[] test = {r1,r2,r4,null};

    String s = rb.deleteRecipe(2);

    assertEquals("Coffee with Milk",s);

    Recipe[] rarr= rb.getRecipes();

    for (int i=0; i<expected_size; i++){
        assertEquals(test[i],rarr[i]);
    }
}





@Test
public void testEditRecipe(){
    rb.addRecipe(r1);
    rb.addRecipe(r2);
    rb.addRecipe(r3);

    String s = rb.editRecipe(2,r4);

    assertEquals(r3.getName(),s);

    Recipe[] rarr = rb.getRecipes();

    assertEquals(rarr[2],r4);

}

}


