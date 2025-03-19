package org.example.commands;

import org.example.models.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.util.LinkedList;

/**
 * Команда "clear". Отчищает коллекцию.
 */
public class Clear extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            var flats = new LinkedList<Flat>();
            flats.addAll(collectionManager.getCollection());
            for (Flat flat: flats) {
                collectionManager.removeById(flat.getId());
            }
            console.println("Коллекция успешно очищена.");
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}