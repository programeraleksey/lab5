package org.example.commands;

import org.example.models.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "min_by_area". Выводит элемент коллекции с минимальным значением поля area.
 */
public class MinByArea extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public MinByArea(Console console, CollectionManager collectionManager) {
        super("min_by_area", "вывести объект коллекции с минимальным значением area");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            long x = 594;
            Flat y = null;
            for (Flat flat : collectionManager.getCollection()) {
                if (flat.getArea() < x) {
                    x = flat.getArea();
                    y = flat;
                }
            }
            console.println(y.toString());
        } catch (InvalidInput e) {
            console.println(e.printExc());
        }
    }
}
