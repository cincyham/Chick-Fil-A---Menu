package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;

public class Item {

    private int id;
    private String name;
    private String picture;
    private int calories;
    private String type;
    private BigDecimal price;

    public Item() {
    }

    public Item(int itemId, String itemName, String picture, int calories, String itemType, BigDecimal price) {
        this.id = itemId;
        this.name = itemName;
        this.picture = picture;
        this.calories = calories;
        this.type = itemType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
