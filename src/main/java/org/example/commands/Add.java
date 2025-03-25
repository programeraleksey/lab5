package org.example.commands;

import org.example.utils.*;

/**
 * Команда "add". Добавляет новый элемент в коллекцию.
 */
public class Add extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public Add(Console console, CollectionManager collectionManager) {
        super("add", "добавляет новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            collectionManager.add(Ask.AskFlat(console, collectionManager.getFreeId(), collectionManager.getDate()));
            console.println("Квартира успешно добавлена.");
        } catch (InvalidInput e) {
            console.println(e.printExc());
        }
    }
}
