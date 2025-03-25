package org.example.commands;

import org.example.models.Flat;
import org.example.models.Furnish;
import org.example.models.View;
import org.example.utils.Ask;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * Команда "remove_greater". Удаляет из коллекции все элементы, id которых больше переданного.
 */
public class RemoveGreater extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public RemoveGreater(Console console, CollectionManager collectionManager) {
        super("remove_greater", "удалить из коллекции все элементы, превышающие заданный");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            Flat flat = Ask.AskFlat(console, 0, new Date());
            String name = flat.getName();
            double[] coords = flat.getCoords();
            long area = flat.getArea();
            Long numb = flat.getNumberOfRooms();
            Integer height = flat.getHeight();
            Furnish furnish = flat.getFurnish();
            View view = flat.getView();
            String houseName = flat.getHouse().getName();
            Integer houseyear = flat.getHouse().getYear();
            int housenumb = flat.getHouse().getNumberOfFloors();
            Boolean flag = false;
            LinkedList<Flat> flats = new LinkedList<Flat>();
            flats.addAll(collectionManager.getCollection());
            for (Flat flat1: flats) {
                if (flag) collectionManager.removeById(flat1.getId());
                if (flat1.getName().equals(name) &&
                        Arrays.equals(flat1.getCoords(), coords) &&
                        flat1.getArea() == area &&
                        flat1.getNumberOfRooms().equals(numb) &&
                        flat1.getHeight().equals(height) &&
                        flat1.getFurnish().equals(furnish) &&
                        flat1.getView().equals(view) &&
                        flat1.getHouse().getName().equals(houseName) &&
                        flat1.getHouse().getYear().equals(houseyear) &&
                        flat.getHouse().getNumberOfFloors() == housenumb)
                {flag = true;}
            }
        } catch (InvalidInput e) {
            console.println(e.printExc());
        }
    }
}