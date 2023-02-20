package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlingService {

    @PostConstruct
    public List<CrawlingRequestDto> getRfW1Data() throws Exception {
        StringBuilder result = new StringBuilder();

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

        List<CrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());

        return crawlingRequestDtoList;
    }

    public List<CrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<CrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

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
            // 뷰단에서 조회 -> 다운로드하면 받아지게 만들기
            CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg);
            crawlingRequestDtoList.add(dto);

            //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
        }
        return crawlingRequestDtoList;
        //writer.close();
    }


}
