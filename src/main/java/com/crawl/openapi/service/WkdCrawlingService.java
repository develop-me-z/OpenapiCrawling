package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WkdCrawlingRequestDto;
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
public class WkdCrawlingService {

    //@PostConstruct
    public List<WkdCrawlingRequestDto> getWkdData(String dev, WkdCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w34".equals(dev)){ // 댐검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_dammain?";
        } else if("w35".equals(dev)){ // 댐수문정보 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_hrdata?";
        } else if("w36".equals(dev)){ // 댐수문정보 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_dtdata?";
        } else if("w37".equals(dev)){ // 댐수문정보 월자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_mndata?";
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


        List<WkdCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WkdCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String mngorg = param.getMngorg();
        String keynm = param.getKeynm();
        String SORT = param.getSort();
        String startdt = param.getStartdt();
        String enddt = param.getEnddt();
        String damcd = param.getDamcd();


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
        if(startdt!=null) {
            if(!"".equals(startdt)) urlStr += "&startdt="+startdt;
        }
        if(enddt!=null) {
            if(!"".equals(enddt)) urlStr += "&enddt="+enddt;
        }
        if(damcd!=null) {
            if(!"".equals(damcd)) urlStr += "&damcd="+damcd;
        }

        return urlStr;
    }

    public List<WkdCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WkdCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String bbsnnm = (String) listbody.get("bbsnnm");
                String sbsncd = (String) listbody.get("sbsncd");
                String bbsncd = (String) listbody.get("bbsncd");
                String obsymd = (String) listbody.get("obsymd");
                String itqty = (String) listbody.get("itqty");
                String damcd = (String) listbody.get("damcd");
                String damnm = (String) listbody.get("damnm");
                String obsdh = (String) listbody.get("obsdh");
                String rwl = (String) listbody.get("rwl");
                String ospilwl = (String) listbody.get("ospilwl");
                String rsqty = (String) listbody.get("rsqty");
                String rsrt = (String) listbody.get("rsrt");
                String iqty = (String) listbody.get("iqty");
                String etqty = (String) listbody.get("etqty");
                String tdqty = (String) listbody.get("tdqty");
                String edqty = (String) listbody.get("edqty");
                String spdqty = (String) listbody.get("spdqty");
                String otltdqty = (String) listbody.get("otltdqty");
                String dambsarf = (String) listbody.get("dambsarf");
                String mnwl = (String) listbody.get("mnwl");
                String avwl = (String) listbody.get("avwl");
                String mxwl = (String) listbody.get("mxwl");
                String mniqty = (String) listbody.get("mniqty");
                String aviqty = (String) listbody.get("aviqty");
                String mxiqty = (String) listbody.get("mxiqty");
                String mntdqty = (String) listbody.get("mntdqty");
                String avtdqty = (String) listbody.get("avtdqty");
                String mxtdqty = (String) listbody.get("mxtdqty");
                String mnsqty = (String) listbody.get("mnsqty");
                String mxsqty = (String) listbody.get("mxsqty");
                String mnrf = (String) listbody.get("mnrf");
                String avrf = (String) listbody.get("avrf");
                String mxrf = (String) listbody.get("mxrf");
                String avsqty = (String) listbody.get("avsqty");
                String mggvnm = (String) listbody.get("mggvnm");
                String rf = (String) listbody.get("rf");
                String mngorg = (String) listbody.get("mngorg");



                WkdCrawlingRequestDto dto = new WkdCrawlingRequestDto(rf, mggvnm, bbsnnm, sbsncd, mngorg, bbsncd, obsymd, itqty, damcd, damnm, obsdh, rwl, ospilwl, rsqty, rsrt, iqty, etqty, tdqty, edqty, spdqty, otltdqty, dambsarf, mnwl, avwl, mxwl, mniqty, aviqty, mxiqty, mntdqty, avtdqty, mxtdqty, mnsqty, mxsqty, mnrf, avrf, mxrf, avsqty);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }

}
