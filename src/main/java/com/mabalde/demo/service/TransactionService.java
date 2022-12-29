package com.mabalde.demo.service;

import com.mabalde.demo.model.CustomerRewardPoints;
import com.mabalde.demo.model.RewardPoints;
import com.mabalde.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    public int calculateRewardPoints(Transaction transaction) {
        int points = 0;
        if (transaction.getAmount() > 100) {
            points += 2 * (transaction.getAmount() - 100);
        }
        if (transaction.getAmount() > 50) {
            points += 1 * (transaction.getAmount() - 50);
        }
        return points;
    }

    private Map<Integer, Map<String, Integer>> calculateCustomerMonthlyRewardPoint(List<Transaction> transactions){
      return  transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId, Collectors.groupingBy(t -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(t.getDate());
                    return cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
                }, Collectors.summingInt(this::calculateRewardPoints))));
    }

    public List<CustomerRewardPoints> calculateRewards(List<Transaction> transactions) {
        Map<Integer, Map<String, Integer>> customerMonthlyRewardPoints = calculateCustomerMonthlyRewardPoint(transactions);
        List<CustomerRewardPoints> result = customerMonthlyRewardPoints.entrySet().stream().map(
                entry -> {
                    int customerId = entry.getKey();
                    List<RewardPoints> rewardPointsList = entry.getValue().entrySet().stream().map(
                            rewardEntry -> new RewardPoints(rewardEntry.getKey(), rewardEntry.getValue())
                    ).collect(Collectors.toList());
                    double totalRewardPoints = rewardPointsList.stream().mapToDouble(rp -> rp.getPoints())
                            .sum();
                    CustomerRewardPoints customerRewardPoints = new CustomerRewardPoints(customerId, rewardPointsList, totalRewardPoints);
                    return customerRewardPoints;
                }).collect(Collectors.toList());
        return result;
    }

}
