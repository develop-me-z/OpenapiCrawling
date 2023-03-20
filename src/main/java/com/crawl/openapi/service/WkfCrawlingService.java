package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WkfCrawlingRequestDto;
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
public class WkfCrawlingService {

    //@PostConstruct
    public List<WkfCrawlingRequestDto> getWkfData(String dev, WkfCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;

        if("w28".equals(dev)){ // 제방현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_banksaa_lst?";
        } else if("w29".equals(dev)){ // 제방조서자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_banksiq_lst?";
        } else if("w30".equals(dev)){ // 내수배제시설현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_pumpsaa_lst?";
        } else if("w31".equals(dev)){ // 배수 조서
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_pumpsiq_lst?";
        } else if("w32".equals(dev)){ // 소규모치수시설물현황
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_sestsaa_lst?";
        } else if("w33".equals(dev)){ // 소규모치수시설물
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkf/wkf_sestsiq_lst?";
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


        List<WkfCrawlingRequestDto> crawlingRequestDtoList = Crawler(result.toString());
        return crawlingRequestDtoList;


    }

    public String paramUrl(String url, WkfCrawlingRequestDto param){

        String urlStr = url;

        String basin = param.getBasin();
        String admcd = param.getAdmcd();
        String code = param.getCode();


        if(basin!=null){
            if(!"".equals(basin)) urlStr += "&basin="+basin;
        }
        if(admcd!=null) {
            if(!"".equals(admcd)) urlStr += "&admcd="+admcd;
        }
        if(code!=null) {
            if(!"".equals(code)) urlStr += "&code="+code;
        }

        return urlStr;
    }

    public List<WkfCrawlingRequestDto> Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        List<WkfCrawlingRequestDto> crawlingRequestDtoList = new ArrayList<>();

        //CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/static/csv/rfw1.csv"));

        if(lists!=null){
            for(int i=0; i<lists.size(); i++){
                JSONObject listbody= (JSONObject) lists.get(i);

                String bankcd = (String) listbody.get("bankcd");
                String banklr = (String) listbody.get("banklr");
                String banknm = (String) listbody.get("banknm");
                String bankwith = (String) listbody.get("bankwith");
                String ebmttp = (String) listbody.get("ebmttp");
                String edaddr = (String) listbody.get("edaddr");
                String edch = (String) listbody.get("edch");
                String inslp = (String) listbody.get("inslp");
                String len = (String) listbody.get("len");
                String outslp = (String) listbody.get("outslp");
                String plfwl = (String) listbody.get("plfwl");
                String plfwv = (String) listbody.get("plfwv");
                String plrivwith = (String) listbody.get("plrivwith");
                String rivdv = (String) listbody.get("rivdv");
                String staddr = (String) listbody.get("staddr");
                String stch = (String) listbody.get("stch");
                String rivnm = (String) listbody.get("rivnm");
                String stchm = (String) listbody.get("stchm");
                String stchs = (String) listbody.get("stchs");
                String edchm = (String) listbody.get("edchm");
                String edchs = (String) listbody.get("edchs");
                String sttmx = (String) listbody.get("sttmx");
                String sttmy = (String) listbody.get("sttmy");
                String edtmx = (String) listbody.get("edtmx");
                String edtmy = (String) listbody.get("edtmy");
                String outstn = (String) listbody.get("outstn");
                String instn = (String) listbody.get("instn");
                String gatecnt = (String) listbody.get("gatecnt");
                String pgatecnt = (String) listbody.get("pgatecnt");
                String pipecnt = (String) listbody.get("pipecnt");
                String pumtcnt = (String) listbody.get("pumtcnt");
                String bodysf = (String) listbody.get("bodysf");
                String etcsf = (String) listbody.get("etcsf");
                String bkrdtp = (String) listbody.get("bkrdtp");
                String hgebmttp = (String) listbody.get("hgebmttp");
                String hgebmtst = (String) listbody.get("hgebmtst");
                String bedtp = (String) listbody.get("bedtp");
                String bedst = (String) listbody.get("bedst");
                String lwebmttp = (String) listbody.get("lwebmttp");
                String lwebmtst = (String) listbody.get("lwebmtst");
                String waystn = (String) listbody.get("waystn");
                String crstp = (String) listbody.get("crstp");
                String bedsoil = (String) listbody.get("bedsoil");
                String mnggv = (String) listbody.get("mnggv");
                String addr = (String) listbody.get("addr");
                String estcd = (String) listbody.get("estcd");
                String ndvol = (String) listbody.get("ndvol");
                String ofara = (String) listbody.get("ofara");
                String pumpvol = (String) listbody.get("pumpvol");
                String rivlevl = (String) listbody.get("rivlevl");
                String rndl = (String) listbody.get("rndl");
                String strtp = (String) listbody.get("strtp");
                String mpnt = (String) listbody.get("mpnt");
                String etcitm = (String) listbody.get("etcitm");
                String pumplr = (String) listbody.get("pumplr");
                String lon = (String) listbody.get("lon");
                String lat = (String) listbody.get("lat");
                String tmx = (String) listbody.get("tmx");
                String tmy = (String) listbody.get("tmy");
                String eststs = (String) listbody.get("eststs");
                String bsncd = (String) listbody.get("bsncd");
                String chain = (String) listbody.get("chain");
                String lrdv = (String) listbody.get("lrdv");
                String estlr = (String) listbody.get("estlr");
                String estdv = (String) listbody.get("estdv");
                String estnm = (String) listbody.get("estnm");
                String admcd = (String) listbody.get("admcd");
                String mngrdtp = (String) listbody.get("mngrdtp");

                WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto(mngrdtp, addr, lon, lat, rivnm, tmx, tmy, admcd, bsncd, estnm, bankcd, banklr, banknm, bankwith, ebmttp, edaddr, edch, inslp, len, outslp, plfwl, plfwv, plrivwith,rivdv, staddr, stch, stchm, stchs, edchm, edchs, sttmx, sttmy, edtmx, edtmy, outstn, instn, gatecnt, pgatecnt, pipecnt, pumtcnt, bodysf, etcsf, bkrdtp, hgebmttp, hgebmtst, bedtp, bedst, lwebmttp, lwebmtst, waystn, crstp, bedsoil, mnggv, estcd, ndvol, ofara, pumpvol, rivlevl, rndl, strtp, mpnt, etcitm, pumplr, eststs, chain, lrdv, estlr, estdv);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }

}
