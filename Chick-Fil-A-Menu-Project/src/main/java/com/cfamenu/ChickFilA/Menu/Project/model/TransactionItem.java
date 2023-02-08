package com.cfamenu.ChickFilA.Menu.Project.model;

public class TransactionItem {

    private int id;
    private int itemId;
    private int transactionId;

    public TransactionItem() {
    }

    public TransactionItem(int transactionItemId, int itemId, int transactionId) {
        this.id = transactionItemId;
        this.itemId = itemId;
        this.transactionId = transactionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
