package org.example.commands;

import org.example.utils.Ask;
import org.example.utils.CollectionManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.util.Date;

import static java.lang.Long.parseLong;

/**
 * Команда "update". Позволяет перезаписать значения полей элемента по его id.
 */
public class UpdateById extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public UpdateById(Console console, CollectionManager collectionManager) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов");
            if (collectionManager.byId(parseLong(arguments))==null) throw new InvalidInput("Объект с таким id не найден.");
            Date date = collectionManager.byId(parseLong(arguments)).getCreationDate();
            collectionManager.removeById(parseLong(arguments));
            collectionManager.add(Ask.AskFlat(console, parseLong(arguments), date));
            console.println("Объект успешно обновлен");
        } catch (InvalidInput e) {console.println(e.printExc());
        } catch (NumberFormatException e) {console.println("Ошибка. Аргумент не является id. Повторите попытку");}
    }
}