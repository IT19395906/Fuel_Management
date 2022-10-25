package com.example.fuel_management;

import java.io.Serializable;

public class Customer implements Serializable {

    private int id;
    private String name;
    private String fuelType;
    private double litres;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getLitres() {
        return litres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setLitres(double litres) {
        this.litres = litres;
    }
}
