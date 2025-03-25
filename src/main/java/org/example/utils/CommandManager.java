package org.example.utils;

import org.example.commands.Command;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс для хранения и вызова команд.
 */
public class CommandManager {
    private final Map<String, Command> commands = new LinkedHashMap<>();

    /**
     * Добавляет команду.
     * @param command Команда.
     */
    public void add(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * @return Словарь все команд.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

}
