package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WiaCrawlingRequestDto;
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
public class WiaCrawlingService {

    public List<WiaCrawlingRequestDto> getWiaData(String dev, WiaCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w38".equals(dev)){ // 용수이용량(유효우량 포함)
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wiawaa_lst?";
        } else if("w39".equals(dev)){ // 용수이용량(유효우량 미포함)
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wiawtaa_lst?";
        } else if("w40".equals(dev)){ // 생활용수이용량
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_wsuaa_lst?";
        } else if("w41".equals(dev)){ // 공업용수이용량
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_induwaa_lst?";
        } else if("w42".equals(dev)){ // 농업용수이용량(유효우량 포함)
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_agrwaa_lst?";
        } else if("w43".equals(dev)){ // 농업용수이용량(유효우량 미포함)
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_agrwtaa_lst?";
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


        List<WiaCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WiaCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String year = param.getYear();
        String admcd = param.getAdmcd();

        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(year!=null) {
            if(!"".equals(year)) urlStr += "&year="+year;
        }
        if(admcd!=null) {
            if(!"".equals(admcd)) urlStr += "&admcd="+admcd;
        }

        return urlStr;
    }

    public List<WiaCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WiaCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String year = (String) listbody.get("year");
                String total = (String) listbody.get("total");
                String wssum = (String) listbody.get("wssum");
                String indsum = (String) listbody.get("indsum");
                String afsum = (String) listbody.get("afsum");
                String wstot = (String) listbody.get("wstot");
                String wsuse = (String) listbody.get("wsuse");
                String eluse = (String) listbody.get("eluse");
                String etuse = (String) listbody.get("etuse");
                String tsum = (String) listbody.get("tsum");
                String pwsu = (String) listbody.get("pwsu");
                String fwsu = (String) listbody.get("fwsu");
                String totflnd = (String) listbody.get("totflnd");
                String totpdy = (String) listbody.get("totpdy");
                String totls = (String) listbody.get("totls");


                WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto(year, total, wssum, indsum, afsum, wstot, wsuse, eluse, etuse, tsum, pwsu, fwsu, totflnd, totpdy, totls);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }

}
