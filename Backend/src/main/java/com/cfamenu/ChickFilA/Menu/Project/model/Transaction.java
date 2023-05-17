package com.cfamenu.ChickFilA.Menu.Project.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class Transaction {

    private int id;
    private LocalDate date;
    private BigDecimal total;
    private List<Item> order;

    public Transaction() {
    }

    public Transaction(int transactionId, LocalDate transactionDate, BigDecimal total, List<Item> order) {
        this.id = transactionId;
        this.date = transactionDate;
        this.total = total;
        this.order = order;
    }

    public Transaction(LocalDate date, BigDecimal total, List<Item> order) {
        this.date = date;
        this.total = total;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Item> getOrder() {
        return order;
    }

    public void setOrder(List<Item> transactionItems) {
        this.order = transactionItems;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", total=" + getTotal() +
                ", order=" + getOrder() +
                '}';
    }
}
