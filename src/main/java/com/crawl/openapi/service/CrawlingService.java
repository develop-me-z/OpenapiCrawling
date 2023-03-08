package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
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

        else if("w6".equals(dev)){ // 수위 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_dubwlobs?";
        } else if("w7".equals(dev)){ // 관측소 제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_obsinfo?";
        } else if("w8".equals(dev)){ // 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_hrdata?";
        } else if("w9".equals(dev)){ // 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wl_dtdata?";
        }

        else if("w10".equals(dev)){ // 기상 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_dwtwtobs?";
        } else if("w11".equals(dev)){ // 관측소 제원
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_obsinfo?";
        } else if("w12".equals(dev)){ // 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_hrdata?";
        } else if("w13".equals(dev)){ // 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/we_dtdata?";
        }

        else if("w16".equals(dev)){ // 유량 측정성과 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_youardata?";
        } else if("w17".equals(dev)){ // 유량 측정성과
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_flwsrrslst?";
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
                String dtrf = (String) listbody.get("dtrf");
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
                String wtobscd = (String) listbody.get("wtobscd");
                String obselm = (String) listbody.get("obselm");
                String thrmlhi = (String) listbody.get("thrmlhi");
                String prselm = (String) listbody.get("prselm");
                String wvmlhi = (String) listbody.get("wvmlhi");
                String hytmlhi = (String) listbody.get("hytmlhi");
                String nj = (String) listbody.get("nj");
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
                String opndt = (String) listbody.get("opndt");
                String obsymd = (String) listbody.get("obsymd");
                String obssthm = (String) listbody.get("obssthm");
                String obsedhm = (String) listbody.get("obsedhm");
                String stwl = (String) listbody.get("stwl");
                String edwl = (String) listbody.get("edwl");
                String avgwl = (String) listbody.get("avgwl");
                String rivwith = (String) listbody.get("rivwith");
                String care = (String) listbody.get("care");
                String wspd = (String) listbody.get("wspd");
                String flw = (String) listbody.get("flw");
                String obsway = (String) listbody.get("obsway");
                String docnm = (String) listbody.get("docnm");
                String ymdh = (String) listbody.get("ymdh");
                if(ymdh != null)
                    ymdh = ymdh.substring(0,4) + "년 " + ymdh.substring(4,6) + "월 " + ymdh.substring(6,8) + "일 " + ymdh.substring(8,10) + "시";
                String rf = (String) listbody.get("rf");
                String ymd = (String) listbody.get("ymd");
                if(ymd != null)
                    ymd = ymd.substring(0,4) + "년 " + ymd.substring(4,6) + "월 " + ymd.substring(6,8) + "일";
                String ym = (String) listbody.get("ym");
                if(ym != null)
                    ym = ym.substring(0,4) + "년 " + ym.substring(4,6) + "월";


                //todo
                // 뷰단에서 조회 -> 다운로드하면 받아지게 만들기
                CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg, ym, dtrf, obsnmeng, opendt, addr, lon, lat, shgt, hrdtstart, hrdtend, dydtstart, dydtend, ymdh, rf, ymd, wlobscd, mggvcd, bbsncd, obsopndt, obskdcd, rivnm, bsnara, rvwdt, bedslp, rvmjctdis, wsrdis, tmx, tmy, gdt, wltel, tdeyn, mxgrd, sistartobsdh, siendobsdh, olstartobsdh, olendobsdh, wl, wtobscd, obselm, thrmlhi, prselm, wvmlhi, hytmlhi, nj, ta, hm, td, ps, ws, wd, sihr1, catot, sdtot, sshr1, taavg, tamin, tamax, wsavg, wsmax, wdmax, hmavg, hmmin, evs, evl, catotavg, psavg, psmax, psmin, sdmax, tdavg, siavg, ssavg, opndt, obsymd, obssthm, obsedhm, stwl, edwl, avgwl, rivwith, care, wspd, flw, obsway, docnm);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }


}
