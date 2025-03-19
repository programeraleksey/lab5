package org.example.commands;

import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.FileManager;
import org.example.utils.InvalidInput;

/**
 * Команда "save". Сохраняет коллекцию в файл flats.json.
 * @see FileManager
 */
public class Save extends Command {
    private final Console console;
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public Save(Console console, FileManager fileManager, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (collectionManager.getCollection().isEmpty()) throw new InvalidInput("Коллекция пуста.");
            var flag = fileManager.save();
            if (flag) {console.println("Коллекция успешно сохранена.");}
            else {console.println("Произошла ошибка при сохранении файла в коллекцию. Повторите попытку.");}
        } catch (InvalidInput e) {
            console.println(e.printExc());
        }
    }
}
