package org.example.commands;

import org.example.models.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.util.Arrays;

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
                console.println("Flat name: " + flat.getName() + "\n" +
                        "id:" + flat.getId() + "\n" +
                        "CreationDate: " + flat.getCreationDate() + "\n" +
                        "coordinates: " + Arrays.toString(flat.getCoords()) + "\n" +
                        "area: " + flat.getArea() + "\n" +
                        "number of rooms: " + flat.getNumberOfRooms() + "\n" +
                        "height: " + flat.getHeight() + "\n" +
                        "furnish: " + flat.getFurnish() + "\n" +
                        "view" + flat.getView() + "\n" +
                        "house name: " + flat.getHouse().getName() + "\n" +
                        "house year: " + flat.getHouse().getYear() + "\n" +
                        "number of house floor: " + flat.getHouse().getNumberOfFloors() + "\n");
            }
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}
