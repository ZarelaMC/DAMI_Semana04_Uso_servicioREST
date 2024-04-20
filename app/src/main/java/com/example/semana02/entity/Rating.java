package com.example.semana02.entity;

import java.io.Serializable;

public class Rating implements Serializable {
    private Double rate;
    private Integer count;
    public Double getRate() {
        return rate;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}