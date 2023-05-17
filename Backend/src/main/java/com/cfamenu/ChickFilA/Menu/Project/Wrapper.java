package com.cfamenu.ChickFilA.Menu.Project;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;

import java.util.List;

public class Wrapper {
    private List<Item> itemList;

    public Wrapper(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}