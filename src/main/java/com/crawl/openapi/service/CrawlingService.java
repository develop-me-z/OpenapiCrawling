package com.crawl.openapi.service;

import com.opencsv.CSVWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CrawlingService {

    @PostConstruct
    public String getRfW1Data() throws Exception {
        StringBuilder result = new StringBuilder();
        StringBuffer reult = new StringBuffer();
        String urlStr = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs";

        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

        String returnLine;

        while((returnLine = br.readLine()) != null){
            result.append(returnLine+"\n\r");
        }
        urlConnection.disconnect();
        System.out.println(result.toString());
        Crawler(result.toString());

        return result.toString();
    }

    public void Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");

        CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        for(int i=0; i<lists.size(); i++){
            JSONObject listbody= (JSONObject) lists.get(i);

            String bbsnnm = (String) listbody.get("bbsnnm");
            String obscd = (String) listbody.get("obscd");
            String obsnm = (String) listbody.get("obsnm");
            String clsyn = (String) listbody.get("clsyn");
            String obsknd = (String) listbody.get("obsknd");
            String sbsncd = (String) listbody.get("sbsncd");
            String mngorg = (String) listbody.get("mngorg");

            //todo
            // 엑셀 다운로드 만들기
            // CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg);
            // CSVWriterBuilder builder = new CSVWriterBuilder(dto);
            writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
        }
        writer.close();
    }


}
