package models;

import daos.carDTO;

public class Car implements carDTO {
    private int id;
    private String make;
    private String model;
    private Integer yearOfModel;
    private String Color;

    public Car(int id, String make, String model, Integer yearOfModel, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfModel = yearOfModel;
        Color = color;
    }

    public Car() {

    }

    public Car(String make, String model, Integer yearOfModel, String color) {
        this.make = make;
        this.model = model;
        this.yearOfModel = yearOfModel;
        Color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfModel() {
        return yearOfModel;
    }

    public void setYearOfModel(Integer yearOfModel) {
        this.yearOfModel = yearOfModel;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
