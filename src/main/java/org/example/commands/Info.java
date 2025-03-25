package org.example.commands;

import org.example.utils.*;

/**
 * Команда "info". Выводит информацию о коллекции.
 */
public class Info extends Command{
    private final Console console;
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public Info(Console console, FileManager fileManager, CollectionManager collectionManager) {
        super("info", "вывести информацию о коллекции.");
        this.fileManager = fileManager;
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");

            String lastSaveDate;
            String lastInitTime;
            if (fileManager.getLastInitDate() == null) { lastInitTime = "в данной сессии инициализации еще не происходило";}
            else { lastInitTime = fileManager.getLastInitDate().toString();}
            if (fileManager.getLastSaveDate() == null) { lastSaveDate = "в данной сессии сохранения еще не происходило";}
            else { lastSaveDate = fileManager.getLastInitDate().toString();}

            String s="Сведения о коллекции:\n";
            s+=" Тип: " + collectionManager.getCollection().getClass().toString()+"\n";
            s+=" Количество элементов: " + collectionManager.getCollection().size()+"\n";
            s+=" Дата последнего сохранения: " + lastSaveDate+"\n";
            s+=" Дата последней инициализации: " + lastInitTime;
            console.println(s);
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}
