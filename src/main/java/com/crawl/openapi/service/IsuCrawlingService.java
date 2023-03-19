package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.IsuCrawlingRequestDto;
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
public class IsuCrawlingService {

    //@PostConstruct
    public List<IsuCrawlingRequestDto> getIsuData(String dev, IsuCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;
        String menu = null;

        if("w20".equals(dev)){ // 저수지시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_arssat_lst?";
        } else if("w21".equals(dev)){ // 양수장시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_apusat_lst?";
        } else if("w22".equals(dev)){ // 양배수장시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_aprsat_lst?";
        } else if("w23".equals(dev)){ // 보시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_admsat_lst?";
        } else if("w24".equals(dev)){ // 집수암거시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_abxsat_lst?";
        } else if("w25".equals(dev)){ // 관정시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_ahlsat_lst?";
        } else if("w26".equals(dev)){ // 중계펌프장
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_facmpumpas_lst?";
        } else if("w27".equals(dev)){ // 기타시설제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wks/wks_aetcsas_lst?";
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


        List<IsuCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }


    public String paramUrl(String url, IsuCrawlingRequestDto param){

        String urlStr = url;

        String admcd = param.getAdmcd();
        String basin = param.getBasin();

        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(admcd!=null) {
            if(!"".equals(admcd)) urlStr += "&admcd="+admcd;
        }

        return urlStr;
    }


    public List<IsuCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<IsuCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String admnm = (String) listbody.get("admnm");
                String admcd = (String) listbody.get("admcd");
                String estcnt = (String) listbody.get("estcnt");
                String bsnara = (String) listbody.get("bsnara");
                String ecpqty = (String) listbody.get("ecpqty");
                String fullara = (String) listbody.get("fullara");
                String pemara = (String) listbody.get("pemara");
                String sumara = (String) listbody.get("sumara");
                String nirara = (String) listbody.get("nirara");
                String pirara = (String) listbody.get("pirara");
                String oirara = (String) listbody.get("oirara");
                String mtcnt = (String) listbody.get("mtcnt");
                String mxvol = (String) listbody.get("mxvol");
                String totirara = (String) listbody.get("totirara");
                String itqty = (String) listbody.get("itqty");
                String address = (String) listbody.get("address");
                String opymd = (String) listbody.get("opymd");
                String plmaxdrngblue = (String) listbody.get("plmaxdrngblue");
                String plmaxdrngrain = (String) listbody.get("plmaxdrngrain");
                String pumpname = (String) listbody.get("pumpname");
                String plmax = (String) listbody.get("plmax");
                String wastwpcnt = (String) listbody.get("wastwpcnt");
                String rainwpcal = (String) listbody.get("rainwpcal");
                String wastwpcal = (String) listbody.get("wastwpcal");
                String wastwpdrng = (String) listbody.get("wastwpdrng");
                String rainwpdrng = (String) listbody.get("rainwpdrng");
                String rainwpcnt = (String) listbody.get("rainwpcnt");
                String elecppyn = (String) listbody.get("elecppyn");
                String deodoriyn = (String) listbody.get("deodoriyn");
                String addr = (String) listbody.get("addr");
                String bsncd = (String) listbody.get("bsncd");
                String bsnnm = (String) listbody.get("bsnnm");
                String drfq = (String) listbody.get("drfq");
                String edyr = (String) listbody.get("edyr");
                String estnm = (String) listbody.get("estnm");
                String esttype = (String) listbody.get("esttype");
                String mggvnm = (String) listbody.get("mggvnm");
                String mwsnm = (String) listbody.get("mwsnm");
                String wsdv = (String) listbody.get("wsdv");


                IsuCrawlingRequestDto dto = new IsuCrawlingRequestDto(wsdv, mwsnm, mggvnm, esttype, estnm, edyr, drfq, bsnnm, bsncd, addr, bsnara, admnm, admcd, estcnt, ecpqty, fullara, pemara, sumara, nirara, pirara, oirara, mtcnt, mxvol, totirara, itqty, address, opymd, plmaxdrngblue, plmaxdrngrain, pumpname, plmax, wastwpcnt, rainwpcal, wastwpcal, wastwpdrng, rainwpdrng, rainwpcnt, elecppyn, deodoriyn);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }



}
