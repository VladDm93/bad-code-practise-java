package model;

import java.util.HashMap;

public class DefaultStorage extends Storage {

    private HashMap<Ingredient, Integer> ingredients;

    public DefaultStorage() {
        initIngredients();
    }

    @Override
    public void addIngredient(
        Ingredient ingredient,
        int count
    ) throws StorageException {
        if (!ingredientsNotNull())
            initIngredients();
        if (ingredient != null && count > 0) {
            HashMap<Ingredient, Integer> ingredients = getStorageIngredients();
            // Если ингредиент уже существует
            if (ingredients.containsKey(ingredient)) {
                int alreadyExistIngredientCount = ingredients.get(
                    ingredient);
                ingredients.put(
                    ingredient, alreadyExistIngredientCount + count);
            // Если не существует
            } else
                ingredients.put(ingredient, count);
        } else
            throw new StorageException(
                "Введён некорректный ингредиент или его количество");
    }

    @Override
    public void removeIngredient(Ingredient ingredient, int count)
        throws StorageException {
        if (!ingredientsNotNull())
            initIngredients();
        if (ingredient != null && count > 0) {
            HashMap<Ingredient, Integer> ingredients = getStorageIngredients();
            // Если ингридиент уже существует
            if (ingredients.containsKey(ingredient)) {
                int alreadyExistIngredientCount = ingredients.get(
                    ingredient);
                // Если количество уже существующих элементов больше либо
                // равно количеству удаляемых
                if (Math.abs(count) >= alreadyExistIngredientCount)
                    ingredients.remove(ingredient);
                else
                    ingredients.put(
                        ingredient, alreadyExistIngredientCount - count);
            // Если не существует
            } else
                throw new StorageException(
                    "Вы пытаетесь удалить несуществующий ингридиент в хранилище");
        } else
            throw new StorageException(
                "Введён некорректный ингридиент или его количество");
    }

    @Override
    public HashMap<Ingredient, Integer> getStorageIngredients() {
        return ingredients;
    }

    private boolean ingredientsNotNull() {
        return ingredients != null;
    }

    private void initIngredients() {
        ingredients = new HashMap<>();
    }
}
