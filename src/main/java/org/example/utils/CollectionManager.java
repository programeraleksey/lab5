package org.example.utils;

import org.example.models.Flat;

import java.util.*;

/**
 * Класс коллекции.
 * @author voisik
 */
public class CollectionManager {
    private long idCounter = 0;
    private Map<Long, Flat> flats = new HashMap<>();
    private LinkedList<Flat> collection = new LinkedList<>();
    private Date lastInitTime;
    private Date lastSaveTime;

    public CollectionManager() {}

    /**
     * Получить элемент коллекции по его id.
     * @param id id объекта.
     * @return Объект коллекции с переданным id.
     */
    public Flat byId(long id) {
        return flats.get(id);
    }

    /**
     * Удаляет элемент из коллекции по его id.
     * @param id id элемента.
     */
    public void removeById(long id){
        Flat el = byId(id);
        if (el == null) return;
        collection.remove(el);
        flats.remove(id);
        update();
    }

    /**
     * Добавляет объект в коллекцию.
     * @param el Объект класса Flat.
     */
    public void add(Flat el) {
        collection.add(el);
        flats.put(el.getId(), el);
        update();
    }

    /**
     * Сортирует коллекцию.
     */
    public void update() {
        Collections.sort(collection);
    }

    /**
     * @return Коллекция объектов.
     */
    public LinkedList<Flat> getCollection() {
        return collection;
    }

    /**
     * Получить свободный id для нового объекта.
     * @return id.
     */
    public long getFreeId() {
        while (true) {if (!flats.containsKey(++idCounter)) {return idCounter;}}
    }

    /**
     * Получить дату создания для нового объекта
     * @return Дата создания.
     */
    public Date getDate() {
        return new Date();
    }
}
