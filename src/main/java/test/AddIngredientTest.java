package test;

import model.Ingredient;
import model.Pizza;
import model.PizzaException;
import org.junit.Assert;
import org.junit.Test;

public class AddIngredientTest {

    @Test
    public void whenAddNotNullIngredient_itInPizza() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = new Ingredient("Cheese");

        // when
        pizza.addIngredient(ingredient, 1);

        // then
        Assert.assertTrue(pizza.getIngredients().containsKey(ingredient) &&
                pizza.getIngredients().get(ingredient) == 1);
    }

    @Test
    public void whenAddMultipleSameIngredients_itInPizza() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = new Ingredient("Cheese");

        // when
        pizza.addIngredient(ingredient, 1);
        pizza.addIngredient(ingredient, 1);

        // then
        Assert.assertTrue(pizza.getIngredients().containsKey(ingredient) &&
                pizza.getIngredients().get(ingredient) == 2);
    }

    @Test(expected = PizzaException.class)
    public void whenAddNullIngredient_exception() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = null;

        // when
        pizza.addIngredient(ingredient, 1);
    }

    @Test(expected = PizzaException.class)
    public void whenAddNonPositiveNumberIngredient_exception() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = null;

        // when
        pizza.addIngredient(ingredient, -1);
    }
}
