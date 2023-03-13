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

        else if("w14".equals(dev)){ // 유량 자료 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/flw_dubobsif?";
        } else if("w15".equals(dev)){ // 실시간 일류량
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/flw_dtdata?";
        }

        else if("w16".equals(dev)){ // 유량 측정성과 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_youardata?";
        } else if("w17".equals(dev)){ // 유량 측정성과
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_flwsrrslst?";
        }

        else if("w18".equals(dev)){ // 유사량 측정성과 관측소 검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_ardata?";
        } else if("w19".equals(dev)){ // 유사량 측정성과
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/wkw_qsvsrrslst?";
        }

        else if("w20".equals(dev)){ // 저수지시설제원
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

        else if("w28".equals(dev)){ // 제방현황
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

        else if("w34".equals(dev)){ // 댐검색
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_dammain?";
        } else if("w35".equals(dev)){ // 댐수문정보 시자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_hrdata?";
        } else if("w36".equals(dev)){ // 댐수문정보 일자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_dtdata?";
        } else if("w37".equals(dev)){ // 댐수문정보 월자료
            paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/wkd/mn_mndata?";
        }

        else if("w38".equals(dev)){ // 용수이용량(유효우량 포함)
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
        String year = param.getYear();
        String admcd = param.getAdmcd();
        String code = param.getCode();
        String damcd = param.getDamcd();


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
        if(year!=null) {
            if(!"".equals(year)) urlStr += "&year="+year;
        }
        if(admcd!=null) {
            if(!"".equals(admcd)) urlStr += "&admcd="+admcd;
        }
        if(code!=null) {
            if(!"".equals(code)) urlStr += "&code="+code;
        }
        if(damcd!=null) {
            if(!"".equals(damcd)) urlStr += "&damcd="+damcd;
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
                String minyear = (String) listbody.get("minyear");
                String maxyear = (String) listbody.get("maxyear");
                String fw = (String) listbody.get("fw");
                String obsymdhn = (String) listbody.get("obsymdhn");
                String surcnt = (String) listbody.get("surcnt");
                String capdsy = (String) listbody.get("capdsy");
                String flqsv = (String) listbody.get("flqsv");
                String wlcd = (String) listbody.get("wlcd");
                String admnm = (String) listbody.get("admnm");
                String admcd = (String) listbody.get("admcd");
                String estcnt = (String) listbody.get("estcnt");
                String ecpqty = (String) listbody.get("ecpqty");
                String fullara = (String) listbody.get("fullara");
                String pemara = (String) listbody.get("pemara");
                String sumara = (String) listbody.get("sumara");
                String nirara = (String) listbody.get("nirara");
                String pirara = (String) listbody.get("pirara");
                String oirara = (String) listbody.get("oirara");
                String mtcnt = (String) listbody.get("mtcnt");
                String mxvol = (String) listbody.get("mxvol");
                String itqty = (String) listbody.get("itqty");
                String totirara = (String) listbody.get("totirara");
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
                String bsncd = (String) listbody.get("bsncd");
                String bsnnm = (String) listbody.get("bsnnm");
                String drfq = (String) listbody.get("drfq");
                String edyr = (String) listbody.get("edyr");
                String estnm = (String) listbody.get("estnm");
                String esttype = (String) listbody.get("esttype");
                String mggvnm = (String) listbody.get("mggvnm");
                String mwsnm = (String) listbody.get("mwsnm");
                String wsdv = (String) listbody.get("wsdv");
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
                String mngrdtp = (String) listbody.get("mngrdtp");
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
                String eststs = (String) listbody.get("eststs");
                String chain = (String) listbody.get("chain");
                String lrdv = (String) listbody.get("lrdv");
                String estlr = (String) listbody.get("estlr");
                String estdv = (String) listbody.get("estdv");
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


                CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg, ym, dtrf, obsnmeng, opendt, addr, lon, lat, shgt, hrdtstart, hrdtend, dydtstart, dydtend, ymdh, rf, ymd, wlobscd, mggvcd, bbsncd, obsopndt, obskdcd, rivnm, bsnara, rvwdt, bedslp, rvmjctdis, wsrdis, tmx, tmy, gdt, wltel, tdeyn, mxgrd, sistartobsdh, siendobsdh, olstartobsdh, olendobsdh, wl, wtobscd, obselm, thrmlhi, prselm, wvmlhi, hytmlhi, nj, ta, hm, td, ps, ws, wd, sihr1, catot, sdtot, sshr1, taavg, tamin, tamax, wsavg, wsmax, wdmax, hmavg, hmmin, evs, evl, catotavg, psavg, psmax, psmin, sdmax, tdavg, siavg, ssavg, opndt, obsymd, obssthm, obsedhm, stwl, edwl, avgwl, rivwith, care, wspd, flw, obsway, docnm, minyear, maxyear, fw, obsymdhn, surcnt, capdsy, flqsv, wlcd, admnm, admcd, estcnt, ecpqty, fullara, pemara, sumara, nirara, pirara, oirara, mtcnt, mxvol, totirara, itqty, address, opymd, plmaxdrngblue, plmaxdrngrain, pumpname, plmax, wastwpcnt, rainwpcal, wastwpcal, wastwpdrng, rainwpdrng, rainwpcnt, elecppyn, deodoriyn, bsncd, bsnnm, drfq, edyr, estnm, esttype, mggvnm, mwsnm, wsdv, bankcd, banklr, banknm, bankwith, ebmttp, edaddr, edch, inslp, len, outslp, plfwl, plfwv, plrivwith,rivdv, staddr, stch, stchm, stchs, edchm, edchs, sttmx, sttmy, edtmx, edtmy, outstn, instn, gatecnt, pgatecnt, pipecnt, pumtcnt, bodysf, etcsf, mngrdtp, bkrdtp, hgebmttp, hgebmtst, bedtp, bedst, lwebmttp, lwebmtst, waystn, crstp, bedsoil, mnggv, estcd, ndvol, ofara, pumpvol, rivlevl, rndl, strtp, mpnt, etcitm, pumplr, eststs, chain, lrdv, estlr, estdv, damcd, damnm, obsdh, rwl, ospilwl, rsqty, rsrt, iqty, etqty, tdqty, edqty, spdqty, otltdqty, dambsarf, mnwl, avwl, mxwl, mniqty, aviqty, mxiqty, mntdqty, avtdqty, mxtdqty, mnsqty, mxsqty, mnrf, avrf, mxrf, avsqty, year, total, wssum, indsum, afsum, wstot, wsuse, eluse, etuse, tsum, pwsu, fwsu, totflnd, totpdy, totls);
                crawlingRequestDtoList.add(dto);

                //writer.writeNext(new String[] {bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg});
            }
        }

        return crawlingRequestDtoList;
        //writer.close();
    }


}
