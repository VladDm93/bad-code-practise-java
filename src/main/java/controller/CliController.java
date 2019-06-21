package controller;

import model.Ingredient;
import model.Pizza;

import java.util.HashMap;
import java.util.Map;

public class CliController {

    public static void printHelloMessage() {
        System.out.println("Добро пожаловать в приложением \"Pizza " +
                           "Order\".\nС его помощью вы можете осуществить " +
                           "процесс заказа пиццы, выбрав подходящий размер " +
                           "пиццы и ингридиенты.\nДля получения более полной " +
                           "информации о приложении введите команду \"?\" " +
                           "или \"help\".\"");
    }

    public static void printHelpMessage() {
        System.out.println("Команды:\n" +
                           "\t-store - получить информацию о наличии " +
                           "ингридиентов.\n" +
                           "\t-size, --S - установить размер пиццы " +
                           "(целочисленное, положительное).\n" +
                           "\t-add <\"название ингридиента\" количество>, --A" +
                           " <\"название ингридиента\" количество> - добавить" +
                           " ингридиент к пицце (число ингридиентов в пицце -" +
                           " целочисленное, положительное). Пример: -add " +
                           "\"сыр\" 2 (-A \"сыр\" 2). При множественном " +
                           "добавлении: -add \"сыр\" 2, \"колбаса\" 3 (-A " +
                           "\"сыр\" 2, \"колбаса\" 3).\n" +
                           "\t-rem <\"название ингридиента\" количество>, --R" +
                           " <\"название ингридиента\" количество> - удалить " +
                           "ингридиент из пиццы (число удаляемых ингридиентов" +
                           " из пиццы - целочисленное, положительное). " +
                           "Пример: -rem \"сыр\" 2 (-R \"сыр\" 2). При " +
                           "множественном удалении ингридиентов: -rem \"сыр\"" +
                           " 2, \"колбаса\" 3 (-R \"сыр\" 2, \"колбаса\" 3)" +
                           ".\n" +
                           "\t-ok, --OK - выдача заказа (печать информации о " +
                           "заказанной пиццы).");
    }

    public static void printStoreMessage(HashMap<Ingredient, Integer> ingredients) {
        if (ingredients != null && ingredients.size() > 0) {
            StringBuilder message = new StringBuilder(
                "На данный момент в хранилище имеются следующие ингриденты:\n");
            for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
                Ingredient ingredient = entry.getKey();
                Integer count = entry.getValue();
                message.append("- ").append(ingredient.getName())
                       .append(" (количество: ").append(count).append(")\n");
            }
            System.out.println(message.toString());
        } else
            System.out.println("Хранилище пусто");
    }

    public static void printOkMessage(Pizza pizza) {
        if (pizza != null) {
            StringBuilder message = new StringBuilder("Заказ на пиццу:\n")
                .append("Размер: ").append(pizza.getSize()).append(" см\n");
            HashMap<Ingredient, Integer> ingredients = pizza.getIngredients();
            if (ingredients != null && !ingredients.isEmpty()) {
                for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
                    Ingredient ingredient = entry.getKey();
                    Integer count = entry.getValue();
                    message.append("- ").append(ingredient.getName())
                           .append(" (Количество: ").append(count).append(")\n");
                }
                System.out.println(message.toString());
            } else
                System.out.println("Вы не выбрали ингредиенты для пиццы");
        } else
            System.out.println("Ошибка при печати информации по пицце");
    }
}
