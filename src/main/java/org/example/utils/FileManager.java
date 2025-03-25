package org.example.utils;

import org.example.models.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * Класс для загрузки и сохранения коллекции в файл.
 */
public class FileManager {
    private Date lastSaveDate;
    private Date lastInitDate;
    private CollectionManager collectionManager;

    public FileManager(CollectionManager col) {
        lastSaveDate = null;
        lastInitDate = null;
        this.collectionManager = col;
    }

    /**
     * @return Время последнего сохранения.
     */
    public Date getLastSaveDate() {return lastSaveDate;}

    /**
     * @return Время последней инициализации.
     */
    public Date getLastInitDate() {return lastInitDate;}

    /**
     * Сохраняет коллекцию в однострочный json файл flats.json.
     * @return Успешность выполнения команды.
     */
    public boolean save() {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (Flat flat : collectionManager.getCollection()) {
            jsonBuilder.append("{\"id\":\"").append((String.valueOf(flat.getId()))).append("\",")
                    .append("\"name\":\"").append((flat.getName())).append("\",")
                    .append("\"coordinates\":\"").append((Arrays.toString(flat.getCoords()))).append("\",")
                    .append("\"creationDate\":\"").append((DateToString(flat.getCreationDate()))).append("\",")
                    .append("\"area\":\"").append((String.valueOf(flat.getArea()))).append("\",")
                    .append("\"numberOfRooms\":\"").append((String.valueOf(flat.getNumberOfRooms()))).append("\",")
                    .append("\"height\":\"").append((String.valueOf(flat.getHeight()))).append("\",")
                    .append("\"furnish\":\"").append((flat.getFurnish().getDescription())).append("\",")
                    .append("\"view\":\"").append((flat.getView().getDescription())).append("\",")
                    .append("\"house name\":\"").append((flat.getHouse().getName())).append("\",")
                    .append("\"house year\":\"").append((String.valueOf(flat.getHouse().getYear()))).append("\",")
                    .append("\"house numberOfFloors\":\"").append((String.valueOf(flat.getHouse().getNumberOfFloors()))).append("\"},");
        }
        String json = jsonBuilder.substring(0, jsonBuilder.length() - 1) + "]";

        try (FileOutputStream fos = new FileOutputStream("flats.json");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] jsonBytes = json.getBytes();
            bos.write(jsonBytes);
            lastSaveDate = new Date();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Загружает коллекцию из flats.json.
     * @return Успешность выполнения команды.
     */
    public boolean load() {
        StringBuilder contentBuilder = new StringBuilder();
        char[] buffer = new char[1024]; // Буфер для чтения данных

        try (FileReader reader = new FileReader("flats.json")) {
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                contentBuilder.append(buffer, 0, charsRead); // Добавляем прочитанные символы
            }
        } catch (IOException e) {
            return false;
        }
        String string = contentBuilder.substring(3, contentBuilder.length() - 3);
        String[] flats = string.split("\"},\\{\"");
        for (String flat: flats) {
            Map<String, String> map = new HashMap<>();
            String[] yach = flat.split("\",\"");
            for (String x: yach) {
                String key = x.split("\":\"")[0];
                String value = "";
                if (!(x.split("\":\"").length == 1)) {value = x.split("\":\"")[1];}
                map.put(key, value.replace("\\\"", "\""));
            }
            long id = parseLong(map.get("id"));
            String name = map.get("name");
            double x = parseDouble(map.get("coordinates").substring(1, map.get("coordinates").length() - 1).split(", ")[0]);
            Float y = parseFloat(map.get("coordinates").substring(1, map.get("coordinates").length() - 1).split(", ")[1]);
            Date date = StringToDate(map.get("creationDate"));
            long area = parseLong(map.get("area"));

            Long numb = null;
            if (!map.get("numberOfRooms").equals("null"))  numb = parseLong(map.get("numberOfRooms"));

            Integer height = parseInt(map.get("height"));

            Furnish furnish = null;
            for (Furnish f : Furnish.values()) {
                if (f.getDescription().equals(map.get("furnish"))) furnish = f;
            }

            View view = null;
            for (View v : View.values()) {
                if (v.getDescription().equals(map.get("view"))) view = v;
            }

            String housename = map.get("house name");
            Integer houseyear = parseInt(map.get("house year"));
            int housenumberOfFloors = parseInt(map.get("house numberOfFloors"));
            collectionManager.add(new Flat(id, name, new Coordinates(x, y), date, area, numb, height, furnish, view, new House(housename, houseyear, housenumberOfFloors)));
        }
        lastInitDate = new Date();
        return true;
    }

    private String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // Преобразуем Date в строку
        String dateString = sdf.format(date);

        // Выводим результат
        return dateString;
    }

    private Date StringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Date date = sdf.parse(dateString);
            return date;
        } catch (ParseException e) {return null;}
    }
}