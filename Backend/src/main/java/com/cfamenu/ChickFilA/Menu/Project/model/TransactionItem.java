package com.cfamenu.ChickFilA.Menu.Project.model;

public class TransactionItem {

    private int id;
    private int itemId;

    private Item item;
    private int transactionId;

    public TransactionItem() {
    }

    public TransactionItem(int transactionItemId, int itemId, Item item, int transactionId) {
        this.id = transactionItemId;
        this.itemId = itemId;
        this.item = item;
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

    public int setItemId(int itemId) {
        this.itemId = itemId;
        return itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
