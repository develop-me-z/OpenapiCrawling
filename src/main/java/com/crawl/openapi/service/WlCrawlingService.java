package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
import com.crawl.openapi.web.dto.WlCrawlingRequestDto;
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
public class WlCrawlingService {

    public List<WlCrawlingRequestDto> getWlData(String dev, WlCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;
        String menu = null;

        if("w6".equals(dev)){ // 수위 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_dubwlobs?";
        } else if("w7".equals(dev)){ // 관측소 제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_obsinfo?";
        } else if("w8".equals(dev)){ // 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_hrdata?";
        } else if("w9".equals(dev)){ // 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_dtdata?";
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


        List<WlCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WlCrawlingRequestDto param){

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


    public List<WlCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WlCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

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
                String wlobscd = (String) listbody.get("wlobscd");
                String mggvcd = (String) listbody.get("mggvcd");
                String bbsncd = (String) listbody.get("bbsncd");
                String obsopndt = (String) listbody.get("obsopndt");
                String obskdcd = (String) listbody.get("obskdcd");
                String rivnm = (String) listbody.get("rivnm");
                String bsnara = (String) listbody.get("bsnara");
                String rvwdt = (String) listbody.get("rvwdt");
                String bedslp = (String) listbody.get("bedslp");
                String rvmjctdis = (String) listbody.get("rvmjctdis");
                String wsrdis = (String) listbody.get("wsrdis");
                String addr = (String) listbody.get("addr");
                String lon = (String) listbody.get("lon");
                String lat = (String) listbody.get("lat");
                String tmx = (String) listbody.get("tmx");
                String tmy = (String) listbody.get("tmy");
                String gdt = (String) listbody.get("gdt");
                String wltel = (String) listbody.get("wltel");
                String tdeyn = (String) listbody.get("tdeyn");
                String mxgrd = (String) listbody.get("mxgrd");
                String sistartobsdh = (String) listbody.get("sistartobsdh");
                String siendobsdh = (String) listbody.get("siendobsdh");
                String olstartobsdh = (String) listbody.get("olstartobsdh");
                String olendobsdh = (String) listbody.get("olendobsdh");
                String wl = (String) listbody.get("wl");
                String ymdh = (String) listbody.get("ymdh");
                if(ymdh != null)
                    ymdh = ymdh.substring(0,4) + "년 " + ymdh.substring(4,6) + "월 " + ymdh.substring(6,8) + "일 " + ymdh.substring(8,10) + "시";
                String ymd = (String) listbody.get("ymd");
                if(ymd != null)
                    ymd = ymd.substring(0,4) + "년 " + ymd.substring(4,6) + "월 " + ymd.substring(6,8) + "일";


                WlCrawlingRequestDto dto = new WlCrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg, obsnmeng, addr, lon, lat, ymdh, ymd, wlobscd, mggvcd, bbsncd, obsopndt, obskdcd, rivnm, bsnara, rvwdt, bedslp, rvmjctdis, wsrdis, tmx, tmy, gdt, wltel, tdeyn, mxgrd, sistartobsdh, siendobsdh, olstartobsdh, olendobsdh, wl);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }


}
