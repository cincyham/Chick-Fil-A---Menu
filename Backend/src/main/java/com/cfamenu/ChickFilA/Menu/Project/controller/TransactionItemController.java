package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.TransactionItemDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionItemController {

    private TransactionItemDao transactionItemDao;

    public TransactionItemController(TransactionItemDao transactionItemDao) {
        this.transactionItemDao = transactionItemDao;
    }

    @RequestMapping(path = "/transaction-item", method = RequestMethod.GET)
    public TransactionItem getTransactionItemById(@RequestBody int transactionItemId){
        return transactionItemDao.getTransactionItemById(transactionItemId);
    }

    @RequestMapping(path = "/transaction-items", method = RequestMethod.GET)
    public List<TransactionItem> getTransactionItemsByTransactionId(@RequestBody int transactionId){
        return transactionItemDao.getAllTransactionItemsByTransactionId(transactionId);
    }

    @RequestMapping(path = "/transaction-item", method = RequestMethod.POST)
    public List<TransactionItem> createTransactionItemFromList(@RequestBody List<Item> itemList, int transactionId){
        List<TransactionItem> outgoingList = new ArrayList<>();

        outgoingList = transactionItemDao.createTransactionItemsFromList(itemList, transactionId);

        return outgoingList;
    }
}
