package org.example.commands;

import org.example.models.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "show". Выводит все элементы коллекции.
 */
public class Show extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public Show(Console console, CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количетсво аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            for (Flat flat : collectionManager.getCollection()) {
                console.println(flat);
            }
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}
