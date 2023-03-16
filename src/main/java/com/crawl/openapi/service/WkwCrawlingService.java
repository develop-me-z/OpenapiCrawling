package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
import com.crawl.openapi.web.dto.WkwCrawlingRequestDto;
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
public class WkwCrawlingService {

    //@PostConstruct
    public List<WkwCrawlingRequestDto> getWkwData(String dev, WkwCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w16".equals(dev)){ // 유량 측정성과 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_youardata?";
        } else if("w17".equals(dev)){ // 유량 측정성과
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_flwsrrslst?";
        }

        else if("w18".equals(dev)){ // 유사량 측정성과 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_ardata?";
        } else if("w19".equals(dev)){ // 유사량 측정성과
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_qsvsrrslst?";
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


        List<WkwCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }


    public String paramUrl(String url, WkwCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String mngorg = param.getMngorg();
        String obscd = param.getObscd();
        String startyear = param.getStartyear();
        String endyear = param.getEndyear();


        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }

        if(mngorg!=null) {
            if(!"".equals(mngorg)) urlStr += "&mngorg="+mngorg;
        }

        if(obscd!=null) {
            if(!"".equals(obscd)) urlStr += "&obscd="+obscd;
        }

        if(startyear!=null) {
            if(!"".equals(startyear)) urlStr += "&startyear="+startyear;
        }
        if(endyear!=null) {
            if(!"".equals(endyear)) urlStr += "&endyear="+endyear;
        }


        return urlStr;
    }


    public List<WkwCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WkwCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String wlobscd = (String) listbody.get("wlobscd");
                String obsnm = (String) listbody.get("obsnm");
                String obsymd = (String) listbody.get("obsymd");
                String obssthm = (String) listbody.get("obssthm");
                String obsedhm = (String) listbody.get("obsedhm");
                String stwl = (String) listbody.get("stwl");
                String edwl = (String) listbody.get("edwl");
                String rivwith = (String) listbody.get("rivwith");
                String flw = (String) listbody.get("flw");
                String obsway = (String) listbody.get("obsway");
                String docnm = (String) listbody.get("docnm");
                String flqsv = (String) listbody.get("flqsv");
                String capdsy = (String) listbody.get("capdsy");
                String surcnt = (String) listbody.get("surcnt");
                String obsymdhn = (String) listbody.get("obsymdhn");
                String wlcd = (String) listbody.get("wlcd");


                WkwCrawlingRequestDto dto = new WkwCrawlingRequestDto(flqsv, capdsy, surcnt, obsymdhn, wlcd, wlobscd, obsnm, obsymd, obssthm, obsedhm, stwl, edwl, rivwith, flw, obsway, docnm);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }



}
