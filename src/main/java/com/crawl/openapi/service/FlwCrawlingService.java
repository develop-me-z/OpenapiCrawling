package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.FlwCrawlingRequestDto;
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
public class FlwCrawlingService {

    //@PostConstruct
    public List<FlwCrawlingRequestDto> getFlwData(String dev, FlwCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;
        String menu = null;

        if("w14".equals(dev)){ // 유량 자료 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/flw_dubobsif?";
        } else if("w15".equals(dev)){ // 실시간 일류량
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/flw_dtdata?";
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


        List<FlwCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, FlwCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String mngorg = param.getMngorg();
        String keynm = param.getKeynm();
        String SORT = param.getSort();
        String obscd = param.getObscd();
        String year = param.getYear();

        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(mngorg!=null) {
            if(!"".equals(mngorg)) urlStr += "&mngorg="+mngorg;
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
        if(year!=null) {
            if(!"".equals(year)) urlStr += "&year="+year;
        }

        return urlStr;
    }

    public List<FlwCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<FlwCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String bbsnnm = (String) listbody.get("bbsnnm");
                String obscd = (String) listbody.get("obscd");
                String obsnm = (String) listbody.get("obsnm");
                String minyear = (String) listbody.get("minyear");
                String maxyear = (String) listbody.get("maxyear");
                String sbsncd = (String) listbody.get("sbsncd");
                String mngorg = (String) listbody.get("mngorg");
                String fw = (String) listbody.get("fw");
                String ymd = (String) listbody.get("ymd");
                if(ymd != null)
                    ymd = ymd.substring(0,4) + "년 " + ymd.substring(4,6) + "월 " + ymd.substring(6,8) + "일";


                FlwCrawlingRequestDto dto = new FlwCrawlingRequestDto(bbsnnm, obscd, obsnm, sbsncd, mngorg, ymd, minyear, maxyear, fw);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }

}
