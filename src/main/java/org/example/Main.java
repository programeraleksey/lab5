package org.example;

import org.example.utils.*;
import org.example.commands.*;

public class Main {
    public static void main(String[] args) {
        var console = new Console();
        var collectionmanager = new CollectionManager();
        var fileManager = new FileManager(collectionmanager);
        var commandmanager = new CommandManager() {{
            add("help", new Help(console, this));
            add("info", new Info(console, fileManager, collectionmanager));
            add("show", new Show(console, collectionmanager));
            add("add", new Add(console, collectionmanager));
            add("update", new UpdateById(console, collectionmanager));
            add("remove_by_id", new RemoveById(console, collectionmanager));
            add("clear", new Clear(console, collectionmanager));
            add("save", new Save(console, fileManager, collectionmanager));
            add("load", new Load(console, fileManager, collectionmanager));
            add("execute_script", new ExecuteScript(console));
            add("remove_first", new RemoveFirst(console, collectionmanager));
            add("head", new Head(console, collectionmanager));
            add("remove_greater", new RemoveGreater(console, collectionmanager));
            add("remove_any_by_furnish", new RemoveByfurnish(console, collectionmanager));
            add("min_by_area", new MinByArea(console, collectionmanager));
            add("group_counting_by_furnish", new GroupByFurnish(console, collectionmanager));
        }};

        String[] userCommand = {"", ""};
        console.print("Введите команду --> ");
        while (true) {
            try {
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                var command = commandmanager.getCommands().get(userCommand[0]);
                if (userCommand[0].equals("exit")) break;
                command.apply(userCommand[1]);
            } catch (Exception e) {console.println("Команда не найдена. Введите help для просмотра доступных команд.");}
        }
        console.println("Завершение программы...");
    }
}
//execute_script text.txt