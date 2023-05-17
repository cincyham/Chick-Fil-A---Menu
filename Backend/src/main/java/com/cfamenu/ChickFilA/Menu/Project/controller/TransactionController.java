package com.cfamenu.ChickFilA.Menu.Project.controller;

import com.cfamenu.ChickFilA.Menu.Project.dao.TransactionDao;
import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionController {

    private TransactionDao transactionDao;

    private TransactionItemController transactionItemController;

    public TransactionController(TransactionDao transactionDao, TransactionItemController transactionItemController) {
        this.transactionDao = transactionDao;
        this.transactionItemController = transactionItemController;
    }

    @RequestMapping(path ="/transactions", method = RequestMethod.GET)
    public List<Transaction> getAllTransactions() throws JsonProcessingException {
        return transactionDao.getAllTransaction();
    }

    @RequestMapping(path ="/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable int id) throws JsonProcessingException {
        return transactionDao.getTransactionById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path ="/transaction/new", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction transaction) throws JsonProcessingException {
        Transaction finalTransaction = transactionDao.createTransaction(transaction);

        return finalTransaction;
    }
}
