package model;

public class StorageException extends Exception {

    private static final String DEFAULT_MESSAGE = "Произошла ошибка при работе с хранилищем";

    public StorageException(String message) {
        super(message);
    }

    public StorageException() {
        super(DEFAULT_MESSAGE);
    }
}
