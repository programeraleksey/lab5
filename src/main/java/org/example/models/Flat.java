package org.example.models;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Flat implements Comparable<Flat> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Максимальное значение поля: 593, Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0
    private Integer height; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private View view; //Поле не может быть null
    private House house; //Поле не может быть null

    public Flat(long id, String name, Coordinates coordinates, Date date, long area, Long numberOfRooms, Integer height, Furnish furnish, View view, House house) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.height = height;
        this.furnish = furnish;
        this.view = view;
        this.house = house;
        this.creationDate = date;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat that = (Flat) o;
        return Objects.equals(id, that.id);
    }

    public int hashCode() {
        return Objects.hash(id, name, creationDate, coordinates, area, numberOfRooms, height, furnish, view, house);
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double[] getCoords(){
        return coordinates.getCoordinates();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getArea(){
        return area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public Integer getHeight() {
        return height;
    }

    public Furnish getFurnish(){
        return furnish;
    }

    public View getView() {
        return view;
    }

    @Override
    public int compareTo(Flat element) {
        return (int)(this.id - element.getId());
    }

    public House getHouse() {return house;}

    public String toString() {
        return "Flat{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"creationDate\": \"" + creationDate + "\", " +
                "\"coordinates\": \"" + Arrays.toString(coordinates.getCoordinates()) + "\", " +
                "\"area\": \"" + area + "\", " +
                "\"number of rooms\": \"" + numberOfRooms + "\", " +
                "\"height\": \"" + height + "\", " +
                "\"furnish\": \"" + furnish + "\", " +
                "\"view\": \"" + view + "\", " +
                "\"house name\": \"" + getHouse().getName() + "\", " +
                "\"house year\": \"" + getHouse().getYear() + "\", " +
                "\"number of house floor\": \"" + getHouse().getNumberOfFloors() + "\"}";
    }
}