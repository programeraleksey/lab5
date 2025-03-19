package org.example.utils;

import org.example.models.*;

import java.util.Date;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

/**
 * Класс для создания объекта класса Flat
 */
public class Ask {

    /**
     * Команда для создания объекта класса Flat
     * @param id Свободный id для объекта.
     * @param date Дата создания объекта.
     * @return объект класса Flat
     */
    public static Flat AskFlat(Console console, long id, Date date) {
        String name = AskName(console);
        Coordinates coordinates = Askcoords(console); //Поле не может быть null
        long area = Askarea(console); //Максимальное значение поля: 593, Значение поля должно быть больше 0
        Long numberOfRooms = AsknumberOfRooms(console); //Поле может быть null, Значение поля должно быть больше 0
        Integer height = Askheight(console); //Значение поля должно быть больше 0
        Furnish furnish = AskFurnish(console); //Поле не может быть null
        View view = Askview(console); //Поле не может быть null
        House house = AskHouse(console); //Поле не может быть null
        return new Flat(id, name, coordinates, date, area, numberOfRooms, height, furnish, view, house);
    }

    private static String AskName(Console console) {
            while (true) {
                try {
                    console.print("name: ");
                    String name = console.readln().trim();
                    if (name.isEmpty()) throw new InvalidInput("Поле name не может быть пустым.");
                    return name;
                } catch (InvalidInput e) {
                    console.println(e.printExc());
                }
            }
    }

    private static Coordinates Askcoords(Console console) {
        String x;
        while (true) {
            console.print("coordinate x: ");
            x = console.readln().trim();
            try {
                parseDouble(x);
                break;
            } catch (NumberFormatException e) {
                console.println("Ошибка. Поле x должно быть типа double. Повторите попытку.");
            }
        }
        while (true) {
            console.print("coordinate y: ");
            String y = console.readln().trim();
            try {
                return new Coordinates(parseDouble(x), parseFloat(y));
            } catch (NumberFormatException e) {
                console.println("Ошибка. Поле y должно быть типа float. Повторите попытку.");
            } catch (Exception e) {console.println(e.toString());}
        }
    }

    private static long Askarea(Console console) {
        while (true) {
            try {
                console.print("area: ");
                String area = console.readln().trim();
                if (area.isEmpty()) throw new InvalidInput("Поле area не может быть пустым.");
                if (0 < parseLong(area) && parseLong(area) <= 593) return parseLong(area);
                throw  new InvalidInput("Максимальное значение поля area: 593, значение поля должно быть больше 0.");
            } catch (InvalidInput e) {
                console.println(e.printExc());
            } catch (NumberFormatException e) {
                console.println("Ошибка. Поле area должно иметь тип long. Повторите попытку");
            }
        }
    }

    private static Long AsknumberOfRooms(Console console) {
        while (true) {
            try {
                console.print("number of rooms: ");
                String numb = console.readln().trim();
                if (numb.isEmpty()) return null;
                if (0 < parseLong(numb)) return parseLong(numb);
                throw new InvalidInput("Поле number of rooms должно иметь значение больше 0.");
            } catch (InvalidInput e) {
                console.println(e.printExc());
            } catch (NumberFormatException e) {
                console.println("Ошибка. Поле number of rooms должно иметь тип long. Повторите попытку");
            }
        }
    }

    private static Integer Askheight(Console console) {
        while (true) {
            try {
                console.print("height: ");
                String numb = console.readln().trim();
                if (numb.isEmpty()) return null;
                if (0 < parseInt(numb)) return parseInt(numb);
                throw new InvalidInput("Значение поля должно быть больше 0. Повторите попытку");
            } catch (InvalidInput e) {
                console.println("Ошибка. " + e.printExc() + " Повторите попытку ввода");
            } catch (NumberFormatException e) {
                console.println("Ошибка. Поле number of rooms должно иметь тип long. Повторите попытку");
            }
        }
    }

    private static Furnish AskFurnish(Console console) {
        var s = new StringBuilder();
        for (Furnish furnish : Furnish.values()) {
            s.append(furnish.getDescription()).append(" ,");
        }
        var x = s.substring(0, s.length() - 2);
        while (true) {
            try {
                console.print("furnish: (" + x + "):");
                String numb = console.readln().trim();
                for (Furnish furnish : Furnish.values()) {
                    if (furnish.getDescription().equals(numb)) return furnish;
                }
                throw new InvalidInput("Некорректное значение поля furnish.");
            } catch (InvalidInput e) {
                console.println(e.printExc());
            }
        }
    }

    private static View Askview(Console console) {
        var s = new StringBuilder();
        for (View view : View.values()) {
            s.append(view.getDescription()).append(" ,");
        }
        var x = s.substring(0, s.length() - 2);
        while (true) {
            try {
                console.print("view: (" + x + "):");
                String numb = console.readln().trim();
                for (View view : View.values()) {
                    if (view.getDescription().equals(numb)) return view;
                }
                throw new InvalidInput("Значение поля некорректно, повторите попытку");
            } catch (InvalidInput e) {
                console.println(e.printExc());
            }
        }
    }
    private static House AskHouse(Console console) {
        String name;
        while (true) {
            console.print("house name: ");
            name = console.readln().trim();
            try {
                if (name.isEmpty()) throw new InvalidInput("Поле name не может быть пустым.");
                break;
            } catch (InvalidInput e) {
                console.println(e.printExc());
            }
        }

        String year;
        while (true) {
            console.print("house year: ");
            year = console.readln().trim();
            try {
                if (0 >= parseInt(year)) throw new InvalidInput("Поле year должно быть больше 0.");
                break;
            } catch (InvalidInput e) {
                console.println(e.printExc());
            } catch (NumberFormatException e) {
                console.println("Поле year должно быть типа int.");
            }
        }

        String numb;
        while (true) {
            console.print("number of floors: ");
            numb = console.readln().trim();
            try {
                if (0 >= parseInt(numb)) throw new InvalidInput("Поле numb должно быть больше 0.");
                break;
            } catch (InvalidInput e) {
                console.println(e.printExc());
            } catch (NumberFormatException e) {
                console.println("Поле numb должно быть типа int.");
            }
        }
        return new House(name, parseInt(year), parseInt(numb));
    }
}