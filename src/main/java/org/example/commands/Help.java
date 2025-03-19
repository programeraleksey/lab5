package org.example.commands;

import org.example.utils.CommandManager;
import org.example.utils.Console;
import org.example.utils.InvalidInput;

/**
 * Команда "help". Выводит справку по всем командам.
 */
public class Help extends Command{
    private final Console console;
    private final CommandManager commandManager;

    public Help(Console console, CommandManager commandmanager) {
        super("help", "вывести справку по доступным командам.");
        this.commandManager = commandmanager;
        this.console = console;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) throw new InvalidInput("Неверное количество аргументов.");
            var map = commandManager.getCommands();
            for (Command command: map.values()) {
                console.println(command.getName() + ": " + command.getDescription());
            }
            console.println("exit : завершить программу (без сохранения в файл)");
        } catch (InvalidInput e) {console.println(e.printExc());}
    }
}
