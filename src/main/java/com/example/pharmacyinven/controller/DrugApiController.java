package com.example.pharmacyinven.controller;

import com.example.pharmacyinven.mapper.DrugMapper;
import com.example.pharmacyinven.model.DrugVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class DrugApiController {

    @Autowired
    DrugMapper mapper;

    public DrugApiController(DrugMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/drug/{pharmaId}")
    public List<DrugVO> getDrugByPharmacy(@PathVariable("pharmaId") String pharmaId) {
        return mapper.getDrugByPharmacy(pharmaId);
    }

    @GetMapping("/api")
    public void callApi() throws IOException {
    	for (int k = 1; k <= 50; k++) {
	        StringBuilder result = new StringBuilder();
	
	        String urlStr = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?" +
	                "serviceKey=2HJESKpi%2FL%2FtcSWQmYe%2BA3cPvCNnqtavIl7NqpL7ESJful2B628ylQY8AuVMbDJvzkfmTaJZ2ZC3F38fYdSgqQ%3D%3D" +
	                "&pageNo="+ k +
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
	
	        try {
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
	
	            // json 파일이 header와 body로 이뤄져있음 -> json 안에 json
	            // body 부분의 items를 추출해야 하므로 body 먼저 가져옴
	            JSONObject jsonBody = (JSONObject) jsonObject.get("body");
	
	            // body 안의 items는 Json array 형태이므로 JSONArray 안에 get 해줌
	            JSONArray infoArray = (JSONArray) jsonBody.get("items");
	
	
	            System.out.println("* items *");
	
	            for (int i = 0; i < infoArray.size(); i++) {
	                System.out.println("item_" + (i + 1) + " =====================================");
	
	                JSONObject itemObject = (JSONObject) infoArray.get(i);
	
	                // 데이터의 쓸모 없는 문자를 제거하기 위함
	                String trim = "[<\\/p><p><sup><\\/sup>\\n]";
	
	                String drugId = itemObject.get("itemSeq").toString().replaceAll(trim, "");
	                String drugName = itemObject.get("itemName").toString().replaceAll(trim, "");
	                String dosage = itemObject.get("useMethodQesitm").toString().replaceAll(trim, "");
	                String company = itemObject.get("entpName").toString().replaceAll(trim, "");
	
	                mapper.insertDrugTest(String.valueOf(i + 1 + ((k - 1) * 10)), drugName, dosage, company);
	
	                System.out.println("drugId ===> " + itemObject.get("itemSeq").toString().replaceAll(trim, ""));
	                System.out.println("drugName ===> " + itemObject.get("itemName").toString().replaceAll(trim, ""));
	                System.out.println("dosage ===> " + itemObject.get("useMethodQesitm").toString().replaceAll(trim, ""));
	                System.out.println("company ===> " + itemObject.get("entpName").toString().replaceAll(trim, ""));
	
	            }
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

    	}

    }

}
