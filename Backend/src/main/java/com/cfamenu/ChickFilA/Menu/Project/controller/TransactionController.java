package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.TransactionDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import com.cfamenu.ChickFilA.Menu.Project.controller.TransactionItemController;
import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionController {

    private TransactionDao transactionDao;

    private TransactionItemController transactionItemController;

    public TransactionController(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @RequestMapping(path ="/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable int id){
        return transactionDao.getTransactionById(id);
    }

    @RequestMapping(path ="/new-transaction", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction inputTransaction) {
        Transaction transaction = transactionDao.createTransaction(inputTransaction);
        List<Item> itemList = new ArrayList<>();
        for (Item item : inputTransaction.getTransactionItems()) {
            itemList.add(item);
        }
        transactionItemController.createTransactionItemFromList(itemList, inputTransaction.getId());
        return transaction;
    }
}
