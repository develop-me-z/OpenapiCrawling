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

    //@PostConstruct
    public List<CrawlingRequestDto> getRfW1Data(CrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String urlStr = paramUrl(param);

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

    public String paramUrl(CrawlingRequestDto param){

        String urlStr = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs?";

        String basin = param.getBasin();
        String oper = param.getOper();
        String mngorg = param.getMngorg();
        String obsknd = param.getObsknd();
        String keynm = param.getKeynm();
        String SORT = param.getSort();
        String output = param.getOutput();

        // if(basin!=null || !"".equals(basin)) urlStr += "&basin="+basin;
        // if(oper!=null || !"".equals(oper)) urlStr += "&oper="+oper;
        // if(mngorg!=null || !"".equals(mngorg)) urlStr += "&mngorg="+mngorg;
        // if(obsknd!=null || !"".equals(obsknd)) urlStr += "&obsknd="+obsknd;
        // if(keynm!=null || !"".equals(keynm)) urlStr += "&keynm="+keynm;
        // if(sort!=null || !"".equals(sort)) urlStr += "&sort="+sort;
        // if(output!=null || !"".equals(output)) urlStr += "&output="+output;

        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(oper!=null) {
            if(!"".equals(oper)) urlStr += "&oper="+oper;
        }
        if(mngorg!=null) {
            if(!"".equals(mngorg)) urlStr += "&mngorg="+mngorg;
        }
        if(obsknd!=null) {
            if(!"".equals(obsknd)) urlStr += "&obsknd="+obsknd;
        }
        if(keynm!=null) {
            if(!"".equals(keynm)) urlStr += "&keynm="+keynm;
        }
        if(SORT!=null) {
            if(!"".equals(SORT)) urlStr += "&sort="+SORT;
        }
        if(output!=null) {
            if(!"".equals(output)) urlStr += "&output="+output;
        }

        return urlStr;
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
