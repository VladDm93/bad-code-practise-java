package model;

public class PizzaException extends Exception {

    private static final String DEFAULT_MESSAGE = "Произошла ошибка при создании пиццы";

    public PizzaException(String message) {
        super(message);
    }

    public PizzaException() {
        super(DEFAULT_MESSAGE);
    }
}
