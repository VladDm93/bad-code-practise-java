package test;


import model.Ingredient;
import model.PizzaException;
import org.junit.*;

import model.Pizza;

public class PizzaTest {

    @Test(expected = PizzaException.class)
    public void removeIngredientWhenItNull() throws PizzaException {
        Pizza pizza = new Pizza();
        pizza.removeIngredient(new Ingredient(""), 1);
    }


    @Test(expected = PizzaException.class)
    public void addIngredientWhenItExists() throws PizzaException{
        Ingredient ingredient = null;
        Pizza pizza = new Pizza();

        pizza.addIngredient(ingredient, 10);

    }

    @Test
    public void addIngredientShouldIncreaseIngredientCount() throws PizzaException{
        Pizza pizza = new Pizza();

        pizza.addIngredient(new Ingredient(""), 10);
        Assert.assertEquals(pizza.getIngredients().size(), 1);

    }
}
