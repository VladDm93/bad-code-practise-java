import controller.CliController;
import model.*;

import java.util.Scanner;

public class PizzaOrder {

    private static final String HELP_COMMAND = "?";

    private static final String ANOTHER_HELP_COMMAND = "help";

    private static final String STORE_COMMAND = "-store";

    private static final String SIZE_COMMAND = "-size";

    private static final String ANOTHER_SIZE_COMMAND = "--S";

    private static final String ADD_COMMAND = "-add";

    private static final String ANOTHER_ADD_COMMAND = "--A";

    private static final String REM_COMMAND = "-rem";

    private static final String ANOTHER_REM_COMMAND = "--R";

    private static final String OK_COMMAND = "-ok";

    private static Storage storage;

    private static Pizza pizza;

    public static void main(String[] args) {
        CliController.printHelloMessage();
        initDefaultStorage();
        try {
            while (true) {
                String input = new Scanner(System.in).nextLine();
                if (input != null && !input.isEmpty()) {
                    if (HELP_COMMAND.equals(input) || ANOTHER_HELP_COMMAND.equals(
                        input)) {
                        CliController.printHelpMessage();
                    } else if (STORE_COMMAND.equals(input)) {
                        CliController.printStoreMessage(storage.getStorageIngredients());
                        // Если присутствуют команды, необходимые для указания размера,
                        // добавления/удаления ингридиентов
                    } else if (input.startsWith(SIZE_COMMAND)
                               || input.startsWith(ANOTHER_SIZE_COMMAND)
                               || input.startsWith(ADD_COMMAND)
                               || input.startsWith(ANOTHER_ADD_COMMAND)
                               || input.startsWith(REM_COMMAND)
                               || input.startsWith(ANOTHER_REM_COMMAND)) {
                        String s = input.replaceAll(",", "");
                        s = s.replaceAll("\"", "");
                        String[] commands = s.split(" ");
                        pizza = parseCommands(commands);
                        System.out.println("Данные обновлены");
                    } else if (OK_COMMAND.equals(input)) {
                        if (pizza != null)
                            CliController.printOkMessage(pizza);
                        else {
                            System.out.println("Неизвестная команда\n Ознакомьтесь со справкой");
                            CliController.printHelpMessage();
                        }
                    } else {
                        System.out.println("Неизвестная команда\n Ознакомьтесь со справкой");
                        CliController.printHelpMessage();
                    }
                }
            }
        } catch (StorageException | PizzaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка, ещё раз проверьте вводимые данные");
        }
    }

    public static void initDefaultStorage() {
        storage = new DefaultStorage();
        try {
            storage.addIngredient(new Ingredient("Сыр"), 200);
            storage.addIngredient(new Ingredient("Перец"), 100);
            storage.addIngredient(new Ingredient("Колбаса"), 50);
            storage.addIngredient(new Ingredient("Соус"), 500);
        } catch (StorageException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Pizza parseCommands(
        String[] commands
    ) throws PizzaException, StorageException {
        if (commands != null && commands.length > 0) {
            pizza = pizza != null ? pizza : new Pizza();
            for (int i = 0; i < commands.length; i++) {
                String command = commands[i];
                if (SIZE_COMMAND.equals(command) || ANOTHER_SIZE_COMMAND
                    .equals(command)) {
                    pizza.setSize(Integer.valueOf(commands[i + 1]));
                } else if (ADD_COMMAND.equals(command)
                           || ANOTHER_ADD_COMMAND.equals(command)) {
                    for (int j = i + 1; j < commands.length; j += 2) {
                        Ingredient ingredient = new Ingredient(commands[j]);
                        int count = Integer.valueOf(commands[j + 1]);
                        pizza.addIngredient(
                            ingredient,
                            count
                        );
                        storage.removeIngredient(ingredient, count);
                    }
                } else if (REM_COMMAND.equals(command)
                           || ANOTHER_REM_COMMAND.equals(command)) {
                    for (int j = i + 1; j < commands.length; j += 2) {
                        Ingredient ingredient = new Ingredient(commands[j]);
                        int count = Integer.valueOf(commands[j + 1]);
                        pizza.removeIngredient(
                            ingredient,
                            count
                        );
                        storage.addIngredient(ingredient, count);
                    }
                }
            }
            return pizza;
        } else
            throw new PizzaException("Неверная команада");
    }
}
