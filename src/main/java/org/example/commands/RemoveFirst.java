package org.example.commands;

import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "remove_first". Удаляет первый элемент коллекции.
 */
public class RemoveFirst extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public RemoveFirst(Console console, CollectionManager collectionManager) {
        super("remove_first", "удалить первый элемент из коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");            collectionManager.removeById(collectionManager.getCollection().getFirst().getId());
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}