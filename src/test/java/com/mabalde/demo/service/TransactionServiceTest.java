package com.mabalde.demo.service;
import com.mabalde.demo.model.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TransactionServiceTest {
    private TransactionService transactionService = new TransactionService();

    @Test
    public void testCalculateRewardPoints() {
        // Test transaction amount less than $50
        Transaction t1 = new Transaction(1, 40, new Date());
        int points1 = transactionService.calculateRewardPoints(t1);
        assertEquals(0, points1);

        // Test transaction amount between $50 and $100
        Transaction t2 = new Transaction(1, 60, new Date());
        int points2 = transactionService.calculateRewardPoints(t2);
        assertEquals(10, points2);

        // Test transaction amount over $100
        Transaction t3 = new Transaction(1, 120, new Date());
        int points3 = transactionService.calculateRewardPoints(t3);
        assertEquals(110, points3);
    }
}

