package com.mabalde.demo.controller;
import java.util.*;

import com.mabalde.demo.model.CustomerRewardPoints;
import com.mabalde.demo.model.RewardPointsRequestBody;
import com.mabalde.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RewardsController {

    @Autowired
    private TransactionService transactionService;

    public RewardsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/rewards")
    public List<CustomerRewardPoints> calculateRewardsResponse(@RequestBody RewardPointsRequestBody rewardPointsRequestBody) {
        return transactionService.calculateRewards(rewardPointsRequestBody.getTransactions());
    }
}
