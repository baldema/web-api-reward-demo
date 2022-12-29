package com.mabalde.demo.model;

import java.util.Date;

public class Transaction {
    private int customerId;
    private double amount;
    private Date date;

    public Transaction(int customerId, double amount, Date date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

