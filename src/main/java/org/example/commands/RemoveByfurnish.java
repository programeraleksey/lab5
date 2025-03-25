package org.example.commands;

import org.example.models.Flat;
import org.example.models.Furnish;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "remove_any_by_furnish". Удаляет первый встретившийся элемент коллекции, поле furnish которого равно переданному.
 */
public class RemoveByfurnish extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public RemoveByfurnish(Console console, CollectionManager collectionManager) {
        super("remove_any_by_furnish", "удалить из коллекции один элемент, значение поля furnish которого эквивалентно заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            Furnish x = Furnish.valueOf(arguments);
            for (Flat flat : collectionManager.getCollection()) {
                if (flat.getFurnish().equals(x)) {
                    collectionManager.removeById(flat.getId());
                    console.println("Элемент успешно удален.");
                    break;
                }
            }
        } catch (InvalidInput e) {console.println(e.printExc());
        } catch (IllegalArgumentException e) {console.println("Ошибка. Переданный аргумент не является объектом типа furnish. Повторите попытку.");}
    }
}
