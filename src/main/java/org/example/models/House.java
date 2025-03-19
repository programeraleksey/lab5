package org.example.models;

public class House {
    private String name; //Поле может быть null
    private Integer year; //Значение поля должно быть больше 0
    private int numberOfFloors; //Значение поля должно быть больше 0

    public House(String name, int i, int i1) {
        this.name = name;
        this.year = i;
        this.numberOfFloors = i1;
    }

    public String getName() {return name;}
    public Integer getYear() {return year;}
    public int getNumberOfFloors() {return numberOfFloors;}
}