package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Transaction {

    private int transactionId;
    private Date transactionDate;
    private BigDecimal total;
    private List<Item> transactionItems;

    public Transaction() {
    }

    public Transaction(int transactionId, Date transactionDate, BigDecimal total) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.total = total;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
