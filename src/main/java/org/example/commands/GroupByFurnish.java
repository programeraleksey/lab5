package org.example.commands;

import org.example.models.Flat;
import org.example.models.Furnish;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.util.HashMap;
import java.util.Map;

/**
 * Команда "group_by_furnish". Выводит количество элементов коллекции, группируя их по полю furnish.
 */
public class GroupByFurnish extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public GroupByFurnish(Console console, CollectionManager collectionManager) {
        super("group_counting_by_furnish", "сгруппировать элементы коллекции по значению поля furnish, вывести количество элементов в каждой группе");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            Map<Furnish, Integer> x = new HashMap<>();
            for (Furnish furnish : Furnish.values()) {
                x.put(furnish, 0);
            }
            for (Flat flat : collectionManager.getCollection()) {
                x.put(flat.getFurnish(), x.get(flat.getFurnish()) + 1);
            }
            for (Furnish key : x.keySet()) {
                console.println(key.getDescription() + ": " + x.get(key));
            }
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}