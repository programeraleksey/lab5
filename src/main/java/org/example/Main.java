package org.example;

import org.example.utils.*;
import org.example.commands.*;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        CollectionManager collectionmanager = new CollectionManager();
        FileManager fileManager = new FileManager(collectionmanager);
        CommandManager commandmanager = new CommandManager() {{
            add(new Help(console, this));
            add(new Info(console, fileManager, collectionmanager));
            add(new Show(console, collectionmanager));
            add(new Add(console, collectionmanager));
            add(new UpdateById(console, collectionmanager));
            add(new RemoveById(console, collectionmanager));
            add(new Clear(console, collectionmanager));
            add(new Save(console, fileManager, collectionmanager));
            add(new Load(console, fileManager, collectionmanager));
            add(new ExecuteScript(console));
            add(new RemoveFirst(console, collectionmanager));
            add(new Head(console, collectionmanager));
            add(new RemoveGreater(console, collectionmanager));
            add(new RemoveByfurnish(console, collectionmanager));
            add(new MinByArea(console, collectionmanager));
            add(new GroupByFurnish(console, collectionmanager));
        }};

        String[] userCommand = {"", ""};
        console.print("Введите команду --> ");
        while (true) {
            try {
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                Command command = commandmanager.getCommands().get(userCommand[0]);
                if (userCommand[0].equals("exit")) break;
                command.apply(userCommand[1]);
            } catch (Exception e) {
                console.println("Команда не найдена. Введите help для просмотра доступных команд.");
            }
        }
        console.println("Завершение программы...");
    }
}
//execute_script text.txt