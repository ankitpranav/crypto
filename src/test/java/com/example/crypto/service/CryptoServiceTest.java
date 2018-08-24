package com.example.crypto.service;

import com.example.crypto.model.CryptoResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CryptoServiceTest {

    @Autowired
    private CryptoService cryptoService;

    @Test
    public void meanOfPrices(){
        int minutes = 10;

        Double expected = cryptoService.meanOfPrices(minutes);

        Double actual = 556.1315489276154d;

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void minMaxOfPrices(){
        int minutes = 10;

        CryptoResponse cryptoResponseActual = new CryptoResponse();
        cryptoResponseActual.setMaxValue(333.7d);
        cryptoResponseActual.setMinValue(999.9899d);

        CryptoResponse cryptoResponse = cryptoService.minMaxOfPrices(minutes);

        Assert.assertEquals(cryptoResponseActual,cryptoResponse);
    }

}