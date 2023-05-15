package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.ItemDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

    @RequestMapping(path = "/item/id", method = RequestMethod.GET)
    public Item getItemById(@RequestBody int id) {
        return itemDao.getItemById(id);
    }
}
