package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
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
public class WksCrawlingService {

    //@PostConstruct
    public List<WksCrawlingRequestDto> getWksData(String dev, WksCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w44".equals(dev)){ // 광역 및 공업용수도 취수장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wiplsaa_lst?";
        } else if("w45".equals(dev)){ // 광역 및 공업용수도 정수장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wcwpsaa_lst?";
        } else if("w46".equals(dev)){ // 광역 및 공업용수도 가압장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wprsaa_lst?";
        } else if("w48".equals(dev)){ // 지방상수도 취수장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_liplsas_lst?";
        } else if("w49".equals(dev)){ // 지방상수도 정수장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_lcwpsas_lst?";
        } else if("w50".equals(dev)){ // 지방상수도 가압장시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_lprsas_lst?";
        } else if("w51".equals(dev)){ // 지방상수도 배수지시설 현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_lwrsas_lst?";
        } else if("w52".equals(dev)){ // 간이상수도
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_ewssas_lst?";
        } else if("w53".equals(dev)){ // 전용상수도
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_pwssas_lst?";
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


        List<WksCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WksCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String admcd = param.getAdmcd();


        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(admcd!=null) {
            if(!"".equals(admcd)) urlStr += "&admcd="+admcd;
        }

        return urlStr;
    }

    public List<WksCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WksCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String admcd = (String) listbody.get("admcd");
                String basin = (String) listbody.get("basin");
                String afest = (String) listbody.get("afest");
                String cptyr = (String) listbody.get("cptyr");
                String estvol = (String) listbody.get("estvol");
                String spara = (String) listbody.get("spara");
                String usg = (String) listbody.get("usg");
                String wstype = (String) listbody.get("wstype");
                String bfest = (String) listbody.get("bfest");
                String cwtype = (String) listbody.get("cwtype");
                String cnt = (String) listbody.get("cnt");
                String hp = (String) listbody.get("hp");
                String phg = (String) listbody.get("phg");
                String type = (String) listbody.get("type");
                String elev = (String) listbody.get("elev");
                String emghr = (String) listbody.get("emghr");
                String mnws = (String) listbody.get("mnws");
                String mxws = (String) listbody.get("mxws");
                String wsara = (String) listbody.get("wsara");
                String dayuse = (String) listbody.get("dayuse");
                String rstype = (String) listbody.get("rstype");
                String wspop = (String) listbody.get("wspop");
                String wsmd = (String) listbody.get("wsmd");
                String addr = (String) listbody.get("addr");
                String bsncd = (String) listbody.get("bsncd");
                String bsnnm = (String) listbody.get("bsnnm");
                String edyr = (String) listbody.get("edyr");
                String estnm = (String) listbody.get("estnm");
                String rivnm = (String) listbody.get("rivnm");
                String estdv = (String) listbody.get("estdv");


                WksCrawlingRequestDto dto = new WksCrawlingRequestDto(afest,cptyr,estvol,spara,usg,wstype,bfest,cwtype,cnt,hp,phg,type,elev,emghr,mnws,mxws,wsara,dayuse,rstype,wspop,wsmd,addr, bsncd, bsnnm, edyr, estnm, rivnm, estdv);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }

}
