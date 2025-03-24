package org.example.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс консоли для считывания ввода и вывода информации.
 */
public class Console {
    private static Scanner fileScanner = null;
    private static Scanner defScanner = new Scanner(System.in);

    /**
     * Считывает ввод пользователя.
     * @return input
     */
    public String readln() {
        if (fileScanner != null) {
            if (fileScanner.hasNext()) return fileScanner.nextLine();
            fileScanner = null;
        }
        return defScanner.nextLine();
    }

    public void println(Object obj) {
        System.out.println(obj);
    }

    public void print(Object obj) {
        System.out.print(obj);
    }

    /**
     *  Устанавливает файл для считывания команд.
     * @param file Файл с командами.
     */
    public void setFileScanner(File file) throws FileNotFoundException {
        fileScanner = new Scanner(file);
    }
}
