package org.example.commands;

import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import static java.lang.Long.parseLong;

/**
 * Команда "remove_by_id". Удаляет элемент по его id.
 */
public class RemoveById extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id", "удаляет элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            if (collectionManager.byId(parseLong(arguments))==null) throw new InvalidInput("Объект с таким id не найден.");
            collectionManager.removeById(parseLong(arguments));
            console.println("Объект успешно удален.");
        } catch (InvalidInput e) {console.println(e.printExc());
        } catch (NumberFormatException e) {console.println("Ошибка. Переданный аргумент не является id. Повторите попытку.");}
    }
}
