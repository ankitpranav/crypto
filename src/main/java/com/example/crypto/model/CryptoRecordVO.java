package com.example.crypto.model;

public class CryptoRecordVO {

    private String timeStamp;

    private Double rate;

    private Double quantity;

    public CryptoRecordVO(String timeStamp, Double rate, Double quantity) {
        this.timeStamp = timeStamp;
        this.rate = rate;
        this.quantity = quantity;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CryptoRecordVO{" +
                "timeStamp='" + timeStamp + '\'' +
                ", rate=" + rate +
                ", quantity=" + quantity +
                '}';
    }
}
