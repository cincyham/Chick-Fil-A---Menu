package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ItemDao {

    Item getItemByName(String itemName);

    List<Item> getAllItems();

    Item getItemById(int id);
}
