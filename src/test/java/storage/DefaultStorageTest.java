package storage;

import exception.StorageException;
import model.Ingredient;
import org.junit.*;


public class DefaultStorageTest {

    private Storage storage;
    private Ingredient testIngredient;

    @Before
    public void setUp() {
        storage = new DefaultStorage();
        testIngredient = new Ingredient("Cucumber");
    }

    @Test
    public void addNotExistIngredient() throws StorageException {
        storage.addIngredient(testIngredient, 2);

        Assert.assertEquals((Integer)2, storage.getStorageIngredients().get(testIngredient));
    }

    @Test
    public void removeIngredientNotNull() throws StorageException {
        storage.addIngredient(testIngredient, 2);
        storage.removeIngredient(testIngredient, 1);

        Assert.assertEquals((Integer)1, storage.getStorageIngredients().get(testIngredient));
    }

    @Test
    public void removeIngredientNull() throws StorageException {
        storage.addIngredient(testIngredient, 2);
        storage.removeIngredient(testIngredient, 2);

        Assert.assertNull(storage.getStorageIngredients().get(testIngredient));
    }
}