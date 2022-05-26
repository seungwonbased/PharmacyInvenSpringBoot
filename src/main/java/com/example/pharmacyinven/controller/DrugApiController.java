//package com.example.pharmacyinven.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//@RestController
//public class DrugApiController {
//
//    @GetMapping("/api")
//    public String callApi() throws IOException {
//        StringBuilder result = new StringBuilder();
//
//            String urlStr = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService?" +
//                    "serviceKey=2HJESKpi%2FL%2FtcSWQmYe%2BA3cPvCNnqtavIl7NqpL7ESJful2B628ylQY8AuVMbDJvzkfmTaJZ2ZC3F38fYdSgqQ%3D%3D" +
//                    "&type=json";
//
//            URL url = new URL(urlStr);
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("GET");
//            urlConnection.setRequestProperty("Content-type", "application/json");
//            urlConnection.setRequestProperty("Accept", "application/json");
//
//            BufferedReader br;
//
//            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
//
//            String returnLine;
//
//            while((returnLine = br.readLine()) != null) {
//                result.append(returnLine + "\n\r");
//            }
//
//            urlConnection.disconnect();
//
//        return result.toString();
//
//    }
//
//}
