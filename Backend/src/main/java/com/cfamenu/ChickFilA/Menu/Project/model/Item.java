package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Item {

    private int id;
    private String name;
    private String picture;
    private int calories;
    private List<String> toppings;
    private String type;
    private BigDecimal price;

    public Item() {
    }

    public Item(int itemId, String itemName, String picture, int calories, List<String> toppings, String itemType, BigDecimal price) {
        this.id = itemId;
        this.name = itemName;
        this.picture = picture;
        this.calories = calories;
        this.toppings = toppings;
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

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setToppingsFromObject(Object toppings) throws SQLException {
        this.toppings = (List<String>) convertObjectToList(toppings);
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

    private static List<String> convertObjectToList(Object obj) throws SQLException {
        List<String> result = new ArrayList<>();
        if (obj != null) {
            Array a = (Array) obj;
            Object[] ar = (Object[])a.getArray();
            for (Object ob : ar) {
                result.add(String.valueOf(ob));
            }
        }
        return result;
    }
}
