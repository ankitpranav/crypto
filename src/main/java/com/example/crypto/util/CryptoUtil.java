package com.example.crypto.util;

import com.example.crypto.model.CryptoRecordVO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;

@Service
public class CryptoUtil {

    HashMap<String,Double> bitcoinMap = new HashMap<>();

    public HashMap<String,Double> createCSV() {
        String dirName = "/home/pranavankit/Downloads/";

        try {
            saveFileFromUrlWithJavaIO(
                    dirName + "bitcurexUSD.csv.gz",
                    "http://api.bitcoincharts.com/v1/csv/bitcurexUSD.csv.gz");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processAndPersistFile();
    }

    public void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
            throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null)
                in.close();
            if (fout != null)
                fout.close();
        }
    }

    public HashMap<String,Double> processAndPersistFile() {

        HashMap<String,Double> bitMap = new HashMap<>();
        GZIPInputStream gzip = null;
        try {
            gzip = new GZIPInputStream(
                    new FileInputStream("/home/pranavankit/Downloads/bitcurexUSD.csv.gz"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(gzip));
        try {
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");
                bitMap = createRecords(attributes);
//                cryptoRecords.add(cryptoRecord);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitMap;
    }


    private HashMap<String, Double> createRecords(String[] metadata) {
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").
                format(new Date(Long.parseLong(metadata[0])));
        Double price = Double.parseDouble(metadata[1]);
        bitcoinMap.put(date,price);
        return bitcoinMap;
    }
}
