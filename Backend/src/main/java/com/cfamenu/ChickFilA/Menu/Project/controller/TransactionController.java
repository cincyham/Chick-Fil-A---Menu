package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.TransactionDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import com.cfamenu.ChickFilA.Menu.Project.controller.TransactionItemController;
import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path ="/transaction/new", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Date date, BigDecimal total, List<Item> order) {
        Transaction transaction = new Transaction(date, total, order);
        Transaction newTransaction = transactionDao.createTransaction(transaction);
        List<Item> itemList = new ArrayList<>();
        for (Item item : transaction.getTransactionItems()) {
            itemList.add(item);
        }
        transactionItemController.createTransactionItemFromList(itemList, transaction.getId());
        return newTransaction;
    }
}
