package com.mabalde.demo.model;

import java.util.List;

public class RewardPointsRequestBody {

    private List<Transaction> transactions;

    public RewardPointsRequestBody() {
        super();
    }
    public RewardPointsRequestBody(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }





}
