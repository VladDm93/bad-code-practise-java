package model;

import java.util.HashMap;

/**
 * Класс-модель, который описывает сущность типа "пицца".
 */
public class Pizza {

    private int size;

    private HashMap<Ingredient, Integer> ingredients;

    public Pizza() {

    }

    public Pizza(
        int size, HashMap<Ingredient, Integer> ingredients
    ) {
        this.size = size;
        this.ingredients = ingredients;
    }

    public void addIngredient(
        Ingredient ingredient,
        int count
    ) throws PizzaException {
        if (ingredient != null && count > 0) {
            // Проверка на существование коллекции
            if (!ingredientsCollectionNotNull())
                initIngredientsCollection();
            // Если элемент уже существует
            if (ingredients.containsKey(ingredient)) {
                int alreadyExistIngredientCount = ingredients.get(
                    ingredient);
                ingredients.put(
                    ingredient, alreadyExistIngredientCount + count);
            // Если не существует
            } else {
                ingredients.put(ingredient, count);
            }
        } else
            throw new PizzaException(
                "Указан некорректный ингредиент или его количество");
    }

    public void removeIngredient(Ingredient ingredient, int count) throws PizzaException {
        if (ingredient == null || count < 1) throw new PizzaException("Указан некорректный ингредиент или его количество");
        if (ingredients == null) initIngredientsCollection();
        if (!ingredients.containsKey(ingredient)) throw new PizzaException("Вы пытаетесь удалить ингредиент, который не существует в пицце");

        if (ingredients.get(ingredient) > count) ingredients.put(ingredient, ingredients.get(ingredient) - count);
        else ingredients.remove(ingredient);
    }

    private boolean ingredientsCollectionNotNull() {
        return ingredients != null;
    }

    private void initIngredientsCollection() {
        ingredients = new HashMap<Ingredient, Integer>();
    }

    // -- Getters & Setters --

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
