package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;

import java.util.List;

public interface TransactionItemDao {

    TransactionItem getTransactionItemById(int transactionItemId);

    List<TransactionItem> getAllTransactionItemsByTransactionId(int transactionId);

    List<TransactionItem> createTransactionItemsFromList(List<Item> transactionItems, int transactionId);
}
