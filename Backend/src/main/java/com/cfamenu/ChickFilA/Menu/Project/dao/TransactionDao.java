package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface TransactionDao {

    List<Transaction> getAllTransaction() throws JsonProcessingException;

    Transaction getTransactionById(int transactionId) throws JsonProcessingException;

    Transaction createTransaction(Transaction transaction) throws JsonProcessingException;

}
