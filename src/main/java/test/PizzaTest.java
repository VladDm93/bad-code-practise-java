package test;

import model.Ingredient;
import model.Pizza;
import model.PizzaException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTest {

    private static Pizza pizza;

    @BeforeClass
    public static void setUp() {
        pizza = new Pizza();
    }

    @Test
    public void testAddIngredientOnCheese() {
        Ingredient cheese = new Ingredient("Cheese");
        try {
            pizza.addIngredient(cheese, 1);
        } catch (PizzaException e) {
            e.printStackTrace();
        }
        assertEquals(1, pizza.getIngredients().get(cheese).intValue());
    }

    @Test
    public void testRemoveIngredientOnCheese() {
        Ingredient cheese = new Ingredient("Cheese");
        try {
            pizza.removeIngredient(cheese, 1);
        } catch (PizzaException e) {
            e.printStackTrace();
        }
        assertNull(pizza.getIngredients().get(cheese));
    }
}
