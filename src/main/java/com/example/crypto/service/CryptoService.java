package com.example.crypto.service;

import com.example.crypto.model.CryptoResponse;
import com.example.crypto.util.CryptoUtil;
import com.google.gwt.thirdparty.json.JSONException;
import com.google.gwt.thirdparty.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CryptoService {

    @Autowired
    private CryptoResponse cryptoResponse;

    @Autowired
    private CryptoUtil cryptoUtil;

    HashMap<String,Double> cryptoRecordMap;


    public CryptoService(CryptoUtil cryptoUtil) throws IOException, JSONException {
        this.cryptoUtil = cryptoUtil;
        cryptoRecordMap = cryptoUtil.createCSV();
    }

    public Double meanOfPrices(int minutes){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime _now = LocalDateTime.now();
        LocalDateTime _then = _now.minusMinutes(minutes);
        String now=_now.format(dtf);
        String then = _then.format(dtf);
        int dataSet =0;
        double totalPrice = 0;
        double max = 0;
        double min = 0;
        for (Map.Entry<String, Double> entry : cryptoRecordMap.entrySet()) {
            if (entry.getKey().compareTo(then)>0 || entry.getKey().compareTo(now)<0){
                if (max < entry.getValue()){
                    max = entry.getValue();
                }
                if (min > entry.getValue()){
                    min = entry.getValue();
                }
                dataSet = dataSet+1;
                totalPrice = totalPrice + entry.getValue();
            }
        }
        return 0 == totalPrice || dataSet ==0? 0 : totalPrice/dataSet;
    }

    public CryptoResponse minMaxOfPrices(int minutes){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime _now = LocalDateTime.now();
        LocalDateTime _then = _now.minusMinutes(minutes);
        String now=_now.format(dtf);
        String then = _then.format(dtf);
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (Map.Entry<String, Double> entry : cryptoRecordMap.entrySet()) {
            if (entry.getKey().compareTo(then)>0 || entry.getKey().compareTo(now)<0){
                if (max < entry.getValue()){
                    max = entry.getValue();
                }
                if (min > entry.getValue()){
                    min = entry.getValue();
                }
            }
        }
        cryptoResponse.setMinValue(min);
        cryptoResponse.setMaxValue(max);
        return cryptoResponse;
    }

    public String getCurrPrice(String currency) throws IOException, JSONException {
        return cryptoUtil.getCurrPrice(currency);
    }

}
