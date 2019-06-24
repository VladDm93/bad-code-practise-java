package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ToDo Описание
 *
 * @author Ilshat Rizvanov
 **/
public class PizzaTests {
    private Pizza pizza;

    @BeforeEach
    void init() {
        pizza = new Pizza();
    }

    @Test
    void ingredientAdded_ifIngredientAdded() throws PizzaException {
        Ingredient ingredient = new Ingredient("Pelmen");
        pizza.addIngredient(ingredient, 1);
        assertTrue(pizza.getIngredients().containsKey(ingredient));
    }

    @Test
    void ingredientRemoved_ifIngredientRemoved() throws PizzaException {
        Ingredient ingredient = new Ingredient("Pelmen");
        pizza.addIngredient(ingredient, 1);
        pizza.removeIngredient(ingredient, 1);
        assertFalse(pizza.getIngredients().containsKey(ingredient));
    }
}
