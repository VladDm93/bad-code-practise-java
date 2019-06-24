package storage;

import exception.StorageException;
import model.Ingredient;

import java.util.HashMap;
import java.util.Map;

public abstract class Storage {

    public abstract void addIngredient(Ingredient ingredient, int count)
            throws StorageException;

    public abstract Map<Ingredient, Integer> getStorageIngredients()
            throws StorageException;

    public abstract void removeIngredient(Ingredient ingredient, int count)
            throws StorageException;
}
