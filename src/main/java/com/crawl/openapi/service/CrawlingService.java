package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
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
    public List<CrawlingRequestDto> getRfData(String dev, CrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;
        String menu = null;

        if("w1".equals(dev)){ // 강수량 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs?";
        } else if("w2".equals(dev)){ // 관측소 제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_obsinfo?";
        } else if("w3".equals(dev)){ // 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_hrdata?";
        } else if("w4".equals(dev)){ // 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dtdata?";
        } else if("w5".equals(dev)){ // 월자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_mndata?";
        }

        String urlStr = paramUrl(paramUrl, param);

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

    public String paramUrl(String url, CrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String oper = param.getOper();
        String mngorg = param.getMngorg();
        String obsknd = param.getObsknd();
        String keynm = param.getKeynm();
        String SORT = param.getSort();
        String obscd = param.getObscd();
        String startdt = param.getStartdt();
        String enddt = param.getEnddt();
        String startyear = param.getStartyear();
        String endyear = param.getEndyear();

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
        if(obscd!=null) {
            if(!"".equals(obscd)) urlStr += "&obscd="+obscd;
        }
        if(startdt!=null) {
            if(!"".equals(startdt)) urlStr += "&startdt="+startdt;
        }
        if(enddt!=null) {
            if(!"".equals(enddt)) urlStr += "&enddt="+enddt;
        }
        if(startyear!=null) {
            if(!"".equals(startyear)) urlStr += "&startyear="+startyear;
        }
        if(endyear!=null) {
            if(!"".equals(endyear)) urlStr += "&endyear="+endyear;
        }


        return urlStr;
    }

    public List<CrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<CrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String bbsnnm = (String) listbody.get("bbsnnm");
                String obscd = (String) listbody.get("obscd");
                String obsnm = (String) listbody.get("obsnm");
                String clsyn = (String) listbody.get("clsyn");
                String obsknd = (String) listbody.get("obsknd");
                String sbsncd = (String) listbody.get("sbsncd");
                String mngorg = (String) listbody.get("mngorg");
                String obsnmeng = (String) listbody.get("obsnmeng");
                String opendt = (String) listbody.get("opendt");
                String addr = (String) listbody.get("addr");
                String lon = (String) listbody.get("lon");
                String lat = (String) listbody.get("lat");
                String shgt = (String) listbody.get("shgt");
                String hrdtstart = (String) listbody.get("hrdtstart");
                String hrdtend = (String) listbody.get("hrdtend");
                String dydtstart = (String) listbody.get("dydtstart");
                String dydtend = (String) listbody.get("dydtend");
                String rf = (String) listbody.get("rf");
                String dtrf = (String) listbody.get("dtrf");
                String ymdh = (String) listbody.get("ymdh");
                if(ymdh != null)
                    ymdh = ymdh.substring(0,4) + "년 " + ymdh.substring(4,6) + "월 " + ymdh.substring(6,8) + "일 " + ymdh.substring(8,10) + "시";
                String ymd = (String) listbody.get("ymd");
                if(ymd != null)
                    ymd = ymd.substring(0,4) + "년 " + ymd.substring(4,6) + "월 " + ymd.substring(6,8) + "일";
                String ym = (String) listbody.get("ym");
                if(ym != null)
                    ym = ym.substring(0,4) + "년 " + ym.substring(4,6) + "월";

                CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg, ym, dtrf, obsnmeng, opendt, addr, lon, lat, shgt, hrdtstart, hrdtend, dydtstart, dydtend, ymdh, rf, ymd);
                crawlingRequestDtoList.add(dto);
            }
        }

        return crawlingRequestDtoList;
    }

}
