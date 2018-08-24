package com.example.crypto.model;

import org.springframework.stereotype.Service;

@Service
public class CryptoResponse {

    private Double minValue;

    private Double maxValue;

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "CryptoResponse{" +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
