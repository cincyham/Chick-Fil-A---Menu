package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.TransactionDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private TransactionDao transactionDao;

    public TransactionController(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @RequestMapping(path ="/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable int id){
        return transactionDao.getTransactionById(id);
    }

    @RequestMapping(path ="/new-transaction", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction inputTransaction){
        Transaction transaction = transactionDao.createTransaction(inputTransaction);
        return transaction;
    }
}
