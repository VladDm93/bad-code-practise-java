package storage;

import model.Ingredient;
import exception.StorageException;

import java.util.HashMap;
import java.util.Map;

public class DefaultStorage extends Storage {
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    @Override
    public void addIngredient(Ingredient ingredient, int count) throws StorageException {
        if (ingredient == null || count <= 0) {
            throw new StorageException("Введён некорректный ингредиент или его количество");
        }
        if (ingredients.containsKey(ingredient)) {
            ingredients.put(ingredient, ingredients.get(ingredient) + count);
        } else {
            ingredients.put(ingredient, count);
        }
    }

    @Override
    public void removeIngredient(Ingredient ingredient, int count) throws StorageException {
        if (ingredient == null || count <= 0) {
            throw new StorageException("Введён некорректный ингридиент или его количество");
        }
        if (ingredients.containsKey(ingredient)) {
            int alreadyExistIngredientCount = ingredients.get(ingredient);
            if (count >= alreadyExistIngredientCount) {
                ingredients.remove(ingredient);
            } else {
                ingredients.put(ingredient, alreadyExistIngredientCount - count);
            }
        } else {
            throw new StorageException("Вы пытаетесь удалить несуществующий ингридиент в хранилище");
        }
    }

    @Override
    public Map<Ingredient, Integer> getStorageIngredients() {
        return ingredients;
    }
}
