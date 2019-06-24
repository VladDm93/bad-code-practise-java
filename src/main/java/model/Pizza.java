package model;

import java.util.HashMap;

/**
 * Класс-модель, который описывает сущность типа "пицца".
 */
public class Pizza {

    private int size;

    private HashMap<Ingredient, Integer> ingredients;

    public Pizza() {
        this.ingredients = new HashMap<>();
    }

    public Pizza(int size, HashMap<Ingredient, Integer> ingredients) {
        this.size = size;
        this.ingredients = ingredients;

    }

    public boolean isNotNull(Ingredient ingredient, int count) {
        if (ingredient != null && count > 0 && ingredientsCollectionNotNull()) {
            return true;
        }
        return false;
    }

    public void addIngredient(Ingredient ingredient, int count) throws PizzaException {
      if(isNotNull(ingredient, count)) {
            if (ingredients.containsKey(ingredient)) {
                int alreadyExistIngredientCount = ingredients.get(
                    ingredient);
                ingredients.put(
                    ingredient, alreadyExistIngredientCount + count);
            } else {
                ingredients.put(ingredient, count);
            }
        } else
            throw new PizzaException("Указан некорректный ингредиент или его количество");
    }

    public void removeIngredient(Ingredient ingredient, int count) throws PizzaException {
       if (isNotNull(ingredient, count)){
           if (ingredients.containsKey(ingredient)) {
               System.out.println("salam");
                int alreadyExistIngredientCount = ingredients.get(ingredient);
                if (Math.abs(count) >= alreadyExistIngredientCount) {
                    System.out.println("privet");
                    ingredients.remove(ingredient);
                } else {
                    ingredients.put(
                            ingredient, alreadyExistIngredientCount - count);
                }
            } else
                throw new PizzaException("Вы пытаетесь удалить ингредиент, который не существует в пицце");
        }
    }

    private boolean ingredientsCollectionNotNull() {
        return ingredients != null;
    }

    private void initIngredientsCollection() {
        ingredients = new HashMap<>();
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(
        HashMap<Ingredient, Integer> ingredients
    ) {
        this.ingredients = ingredients;
    }
}
