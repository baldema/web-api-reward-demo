package com.mabalde.demo.model;

import java.util.List;

public class CustomerRewardPoints {
    private int customerId;
    private List<RewardPoints> rewardPointsList;
    private double totalRewardPoints;

    public CustomerRewardPoints(int customerId, List<RewardPoints> rewardPointsList, double totalRewardPoints) {
        this.customerId = customerId;
        this.rewardPointsList = rewardPointsList;
        this.totalRewardPoints = totalRewardPoints;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<RewardPoints> getRewardPointsList() {
        return rewardPointsList;
    }

    public void setRewardPointsList(List<RewardPoints> rewardPointsList) {
        this.rewardPointsList = rewardPointsList;
    }

    public double getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(double totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }
}
