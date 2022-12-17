package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;

public interface TransactionDao {

    Transaction getTransactionById(int transactionId);

    Transaction createTransaction(Transaction transaction);

}
