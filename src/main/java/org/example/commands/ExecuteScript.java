package org.example.commands;

import org.example.utils.Console;
import org.example.utils.InvalidInput;

import java.io.File;

/**
 * Команда "execute_script". Исполняет скрипт из переданного фалйа.
 */
public class ExecuteScript extends Command {
    private Console console;

    public ExecuteScript(Console console) {
        super("execute_script", "считать и исполнить скрипт из указанного файла");
        this.console = console;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            File file = new File(arguments);
            if (!file.exists()) throw new InvalidInput("Файл не найден.");
            if (!file.canRead()) throw new InvalidInput("Нет прав для чтения файла.");
            try {
                console.setFileScanner(file);
            } catch (Exception e) {console.println("Ошибка. " + e.getMessage());}
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}