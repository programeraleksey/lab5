package org.example.commands;

/**
 * Абстрактный класс, от которого наследуются все команды.
 */
public abstract class Command {
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Выполняет команду
     */
    public abstract void apply(String arguments);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}