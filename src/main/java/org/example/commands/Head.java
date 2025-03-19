package org.example.commands;

import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "head". Выводит первый элемент коллекции.
 */
public class Head extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public Head(Console console, CollectionManager collectionManager) {
        super("head", "вывести первый элемент коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            console.println(collectionManager.getCollection().getFirst().toString());
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}
