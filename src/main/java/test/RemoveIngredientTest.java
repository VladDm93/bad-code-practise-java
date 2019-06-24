package test;

import model.Ingredient;
import model.Pizza;
import model.PizzaException;
import org.junit.Assert;
import org.junit.Test;

public class RemoveIngredientTest {

    @Test
    public void whenRemoveNotNullIngredient_itInPizza() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = new Ingredient("Cheese");
        pizza.addIngredient(ingredient, 1);

        // when
        pizza.removeIngredient(ingredient, 1);

        // then
        Assert.assertFalse(pizza.getIngredients().containsKey(ingredient));
    }

    @Test
    public void whenAddMultipleSameIngredients_itInPizza() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = new Ingredient("Cheese");
        pizza.addIngredient(ingredient, 10);

        // when
        pizza.removeIngredient(ingredient, 1);

        // then
        Assert.assertTrue(pizza.getIngredients().containsKey(ingredient) &&
                pizza.getIngredients().get(ingredient) == 9);
    }

    @Test(expected = PizzaException.class)
    public void whenRemoveNullIngredient_exception() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = null;

        // when
        pizza.removeIngredient(ingredient, 1);
    }

    @Test(expected = PizzaException.class)
    public void whenRemoveNonPositiveNumberIngredient_exception() throws PizzaException {
        // given
        Pizza pizza = new Pizza();
        Ingredient ingredient = null;

        // when
        pizza.addIngredient(ingredient, -1);
    }
}
