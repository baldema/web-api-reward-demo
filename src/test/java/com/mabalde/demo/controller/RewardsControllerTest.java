package com.mabalde.demo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mabalde.demo.model.CustomerRewardPoints;
import com.mabalde.demo.model.RewardPoints;
import com.mabalde.demo.model.RewardPointsRequestBody;
import com.mabalde.demo.model.Transaction;
import com.mabalde.demo.service.TransactionService;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.google.gson.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RewardsController.class)
public class RewardsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void testCalculateRewards() throws Exception {
        // Set up mock data
        Transaction t1 = new Transaction(1, 120, new Date(2022, 1, 15));
        Transaction t2 = new Transaction(1, 80, new Date(2022, 2, 5));
        Transaction t3 = new Transaction(2, 100, new Date(2022, 3, 10));
        Transaction t4 = new Transaction(2, 200, new Date(2022, 3, 15));
        List<Transaction> transactions = Arrays.asList(t1, t2, t3, t4);
        when(transactionService.calculateRewardPoints(any(Transaction.class))).thenReturn(90, 40, 30, 60);

        RewardPoints r1= new RewardPoints("January", 190);
        RewardPoints r2 = new RewardPoints("February", 40);
        RewardPoints r3 = new RewardPoints("February", 40);
        List<RewardPoints> rp1 = Arrays.asList(r1, r2);
        List<RewardPoints> rp2 = Arrays.asList(r3);
        CustomerRewardPoints c1 = new CustomerRewardPoints(1, rp1, 130);
        CustomerRewardPoints c2 = new CustomerRewardPoints(2, rp2, 90);
        List<CustomerRewardPoints>  customerRewardPoints = Arrays.asList(c1, c2);


        RewardPointsRequestBody rewardPointsRequestBody = new RewardPointsRequestBody();
        rewardPointsRequestBody.setTransactions(transactions);

        // Set up expected response
        when(transactionService.calculateRewards(any(List.class))).thenReturn(customerRewardPoints);
             ObjectMapper mapper = new ObjectMapper();
        String requestObject =  mapper.writeValueAsString(rewardPointsRequestBody);

        // Send request and verify response
        MvcResult result = mvc.perform(post("/rewards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestObject))
                .andExpect(status().isOk())
                .andReturn();
       assertNotNull(result.getResponse().getContentAsString());
    }
}

