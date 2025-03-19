package org.example.models;

public class Coordinates {
    private double x;
    private Float y; //Поле не может быть null

    public Coordinates(Double x, Float y) {
    this.x = x;
    this.y = y;
    }

    public double[] getCoordinates() {
        return new double[]{x, y};
    }
}