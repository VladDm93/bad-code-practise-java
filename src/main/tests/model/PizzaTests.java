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
    void addIngredient_ifIngredientAdded() throws PizzaException {
        Ingredient ingredient = new Ingredient("Pelmen");
        pizza.addIngredient(ingredient, 1);
        assertTrue(pizza.getIngredients().containsKey(ingredient));
    }

    @Test
    void removeIngredient_ifIngredientRemoved() throws PizzaException {
        Ingredient ingredient = new Ingredient("Pelmen");
        pizza.addIngredient(ingredient, 1);
        pizza.removeIngredient(ingredient, 1);
        assertFalse(pizza.getIngredients().containsKey(ingredient));
    }

    @Test
    void addIngredient_exceptionThrown_ifIngredientIllegal() {
        assertThrows(Exception.class, () -> pizza.addIngredient(null, 1));
    }
}
