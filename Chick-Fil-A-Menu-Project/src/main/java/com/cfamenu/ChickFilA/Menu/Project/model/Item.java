package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;

public class Item {

    private int itemId;
    private String itemName;
    private int calories;
    private String itemType;
    private BigDecimal price;

    public Item() {
    }

    public Item(int itemId, String itemName, int calories, String itemType, BigDecimal price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.calories = calories;
        this.itemType = itemType;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
