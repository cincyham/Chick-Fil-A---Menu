package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.ItemDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private ItemDao itemDao;

    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<Item> getAllItems(){
        List<Item> itemList = new ArrayList<>();

        itemList = itemDao.getAllItems();

        return itemList;
    }

    @RequestMapping(path = "/item", method = RequestMethod.GET)
    public Item getItemByName(@RequestBody String itemName){

        return itemDao.getItemByName(itemName);
    }
}
