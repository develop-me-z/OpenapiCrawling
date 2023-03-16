package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WeCrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeCrawlingService {

    public List<WeCrawlingRequestDto> getWeData(String dev, WeCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w10".equals(dev)){ // 기상 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_dwtwtobs?";
        } else if("w11".equals(dev)){ // 관측소 제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_obsinfo?";
        } else if("w12".equals(dev)){ // 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_hrdata?";
        } else if("w13".equals(dev)){ // 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_dtdata?";
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


        List<WeCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WeCrawlingRequestDto param){

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

        return urlStr;
    }


    public List<WeCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WeCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

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
                String addr = (String) listbody.get("addr");
                String wtobscd = (String) listbody.get("wtobscd");
                String obskdcd = (String) listbody.get("obskdcd");
                String mggvcd = (String) listbody.get("mggvcd");
                String opndt = (String) listbody.get("opndt");
                String lon = (String) listbody.get("lon");
                String lat = (String) listbody.get("lat");
                String tmx = (String) listbody.get("tmx");
                String tmy = (String) listbody.get("tmy");
                String bbsncd = (String) listbody.get("bbsncd");
                String obselm = (String) listbody.get("obselm");
                String thrmlhi = (String) listbody.get("thrmlhi");
                String prselm = (String) listbody.get("prselm");
                String wvmlhi = (String) listbody.get("wvmlhi");
                String hytmlhi = (String) listbody.get("hytmlhi");
                String nj = (String) listbody.get("nj");
                String ymdh = (String) listbody.get("ymdh");
                if(ymdh != null)
                    ymdh = ymdh.substring(0,4) + "년 " + ymdh.substring(4,6) + "월 " + ymdh.substring(6,8) + "일 " + ymdh.substring(8,10) + "시";
                String ta = (String) listbody.get("ta");
                String hm = (String) listbody.get("hm");
                String td = (String) listbody.get("td");
                String ps = (String) listbody.get("ps");
                String ws = (String) listbody.get("ws");
                String wd = (String) listbody.get("wd");
                String sihr1 = (String) listbody.get("sihr1");
                String catot = (String) listbody.get("catot");
                String sdtot = (String) listbody.get("sdtot");
                String sshr1 = (String) listbody.get("sshr1");
                String ymd = (String) listbody.get("ymd");
                if(ymd != null)
                    ymd = ymd.substring(0,4) + "년 " + ymd.substring(4,6) + "월 " + ymd.substring(6,8) + "일";
                String taavg = (String) listbody.get("taavg");
                String tamin = (String) listbody.get("tamin");
                String tamax = (String) listbody.get("tamax");
                String wsavg = (String) listbody.get("wsavg");
                String wsmax = (String) listbody.get("wsmax");
                String wdmax = (String) listbody.get("wdmax");
                String hmavg = (String) listbody.get("hmavg");
                String hmmin = (String) listbody.get("hmmin");
                String evs = (String) listbody.get("evs");
                String evl = (String) listbody.get("evl");
                String catotavg = (String) listbody.get("catotavg");
                String psavg = (String) listbody.get("psavg");
                String psmax = (String) listbody.get("psmax");
                String psmin = (String) listbody.get("psmin");
                String sdmax = (String) listbody.get("sdmax");
                String tdavg = (String) listbody.get("tdavg");
                String siavg = (String) listbody.get("siavg");
                String ssavg = (String) listbody.get("ssavg");


                WeCrawlingRequestDto dto = new WeCrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg, addr, lon, lat, ymdh, ymd, mggvcd, bbsncd, obskdcd, tmx, tmy, wtobscd, obselm, thrmlhi, prselm, wvmlhi, hytmlhi, nj, ta, hm, td, ps, ws, wd, sihr1, catot, sdtot, sshr1, taavg, tamin, tamax, wsavg, wsmax, wdmax, hmavg, hmmin, evs, evl, catotavg, psavg, psmax, psmin, sdmax, tdavg, siavg, ssavg, opndt);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }



}
