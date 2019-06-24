import model.Ingredient;
import model.Pizza;
import model.PizzaException;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PizzaOrdertests {
    Pizza pizza;
    Ingredient ingredient;
    @BeforeEach
    public void prepare(){
        pizza = new Pizza(50,new HashMap<Ingredient, Integer>());
        ingredient = new Ingredient("cheeeeess");
    }
    @Test()
    public void addIngredient_ShouldCreatePizzs_Sucksessfull() throws PizzaException {
        pizza.addIngredient(ingredient,3);
        int k = pizza.getIngredients().get(ingredient);
        Assertions.assertEquals(3,k);
    }

    @Test()
    public void addIngredient_ShouldGenerateException() throws PizzaException{
        Assertions.assertThrows(PizzaException.class,()->pizza.addIngredient(ingredient, -5));
    }
    @Test()
    public void  removeIngredient_ShouldGenerateException() throws PizzaException{
        Assertions.assertThrows(PizzaException.class,()->pizza.removeIngredient(ingredient, -5));
    }
    @AfterEach
    public void after(){
        
    }
    /*@Test()
    public void  removeIngredient_ShouldSu throws PizzaException{
        Pizza pizza = new Pizza(50,new HashMap<Ingredient, Integer>());
        Ingredient ingredient = new Ingredient("cheeeeess");
        Assertions.assertThrows(PizzaException.class,()->pizza.removeIngredient(ingredient, -5));
    }*/
}
