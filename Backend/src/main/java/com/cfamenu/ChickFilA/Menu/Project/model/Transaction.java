package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Transaction {

    private int id;
    private Date date;
    private BigDecimal total;
    private List<Item> transactionItems;

    public Transaction() {
    }

    public Transaction(int transactionId, Date transactionDate, BigDecimal total, List<Item> transactionItems) {
        this.id = transactionId;
        this.date = transactionDate;
        this.total = total;
        this.transactionItems = transactionItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Item> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(List<Item> transactionItems) {
        this.transactionItems = transactionItems;
    }
}
