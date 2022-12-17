package com.cfamenu.ChickFilA.Menu.Project.model;

public class TransactionItem {

    private int transactionItemId;
    private int itemId;
    private int transactionId;

    public TransactionItem() {
    }

    public TransactionItem(int transactionItemId, int itemId, int transactionId) {
        this.transactionItemId = transactionItemId;
        this.itemId = itemId;
        this.transactionId = transactionId;
    }

    public int getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(int transactionItemId) {
        this.transactionItemId = transactionItemId;
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
