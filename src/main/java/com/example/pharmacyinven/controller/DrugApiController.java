package com.example.pharmacyinven.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class DrugApiController {

    @GetMapping("/api")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

            String urlStr = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?" +
                    "serviceKey=2HJESKpi%2FL%2FtcSWQmYe%2BA3cPvCNnqtavIl7NqpL7ESJful2B628ylQY8AuVMbDJvzkfmTaJZ2ZC3F38fYdSgqQ%3D%3D" +
                    "&numOfRows=50" +
                    "&type=json";

            URL url = new URL(urlStr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");

            BufferedReader br;

            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while((returnLine = br.readLine()) != null) {
                result.append(returnLine).append("\n\r");
            }

            urlConnection.disconnect();

        String jsonInfo = result.toString();

        System.out.println(jsonInfo);

        try {
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
            JSONObject jsonBody = (JSONObject) jsonObject.get("body");

            JSONArray infoArray = (JSONArray) jsonBody.get("items");


            System.out.println("* items *");

            for (int i = 0; i < infoArray.size(); i++) {
                System.out.println("item_" + (i + 1) + "========================");

                JSONObject itemObject = (JSONObject) infoArray.get(i);

                System.out.println("drugId ===> " + itemObject.get("itemSeq"));
                System.out.println("drugName ===> " + itemObject.get("itemName"));
                System.out.println("ingredient ===> " + itemObject.get("intrcQesitm"));
                System.out.println("dosage ===> " + itemObject.get("useMethodQesitm"));
                System.out.println("company ===> " + itemObject.get("entpName"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

}
