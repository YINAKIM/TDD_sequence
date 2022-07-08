package com.example.tdd_sequence.chap03;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;

    private PayData(){}

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    // getter (don't use setter)
    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    // Builder class
    public static class Builder {
        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate){
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount){
            data.payAmount = payAmount;
            return this;
        }

        public PayData build(){
            return data;
        }
    }

    // Builder method
    public static Builder builder(){
        return new Builder();
    }
}
