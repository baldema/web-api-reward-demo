package com.mabalde.demo.model;

public class RewardPoints {
    private String month;
    private double points;

    public RewardPoints(String month, double points) {
        this.month = month;
        this.points = points;
    }

    public String getMonth() {
        return month;
    }

    public double getPoints() {
        return points;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
