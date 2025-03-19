package org.example.commands;

import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.FileManager;
import org.example.utils.InvalidInput;

/**
 * Команда "load". Загружает коллекцию из файла flats.json.
 * @see FileManager
 */
public class Load extends Command {
    private final Console console;
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public Load(Console console, FileManager fileManager, CollectionManager collectionManager) {
        super("load", "загрузить сохраненную коллекцию");
        this.console = console;
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            if (!collectionManager.getCollection().isEmpty()) new Clear(console, collectionManager).apply("");
            var flag = fileManager.load();
            if (flag) {console.println("Коллекция успешно загружена.");}
            else {console.println("Произошла ошибка при загрузке коллекции. Повторите попытку.");}
        } catch (InvalidInput e) {
            console.println(e.printExc());
        }
    }
}