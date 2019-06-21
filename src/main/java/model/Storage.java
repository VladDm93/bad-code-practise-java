package model;

import java.util.HashMap;

public abstract class Storage {

    public abstract void addIngredient(Ingredient ingredient, int count)
        throws StorageException;

    public abstract HashMap<Ingredient, Integer> getStorageIngredients()
        throws StorageException;

    public abstract void removeIngredient(Ingredient ingredient, int count)
        throws StorageException;
}
