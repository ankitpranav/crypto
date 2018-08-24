package com.example.crypto.controller;


import com.example.crypto.model.CryptoResponse;
import com.example.crypto.service.CryptoService;
import com.google.gwt.thirdparty.json.JSONException;
import com.google.gwt.thirdparty.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/crypto")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @RequestMapping(value = "/meanOfPrices", method = RequestMethod.GET)
    public Double meanOfPrices(@RequestParam("minutes") int minutes) throws IOException {
        return cryptoService.meanOfPrices(minutes);
    }

    @RequestMapping(value = "/minMaxOfPrices", method = RequestMethod.GET)
    public CryptoResponse minMaxOfPrices(@RequestParam("minutes") int minutes) throws IOException {
        return cryptoService.minMaxOfPrices(minutes);
    }

    @RequestMapping(value = "/getCurrentPrice", method = RequestMethod.GET)
    public String getCurrPrice(@RequestParam("currency") String currency) throws IOException, JSONException {
        return cryptoService.getCurrPrice(currency);
    }
}
