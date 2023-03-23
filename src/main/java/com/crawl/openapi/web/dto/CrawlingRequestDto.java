package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CrawlingRequestDto {
    private String basin;
    private String oper;
    private String mngorg;
    private String obsknd;
    private String keynm;
    private String sort;
    private String bbsnnm;
    private String obscd;
    private String obsnm;
    private String clsyn;
    private String sbsncd;
    private String obsnmeng;
    private String opendt;
    private String addr;
    private String lon;
    private String lat;
    private String shgt;
    private String hrdtstart;
    private String hrdtend;
    private String dydtstart;
    private String dydtend;
    private String startdt;
    private String enddt;
    private String ymdh;
    private String rf;
    private String startyear;
    private String endyear;
    private String ym;
    private String dtrf;
    private String ymd;


    @Builder
    public CrawlingRequestDto(String bbsnnm, String obscd, String obsnm, String clsyn, String obsknd, String sbsncd, String mngorg, String ym, String dtrf, String obsnmeng, String opendt, String addr, String lon, String lat, String shgt, String hrdtstart, String hrdtend, String dydtstart, String dydtend, String ymdh, String rf, String ymd){
        if(bbsnnm!="" && bbsnnm != null) this.bbsnnm = bbsnnm; else this.bbsnnm = "-";
        if(ymd!="" && ymd != null) this.ymd = ymd; else this.ymd = "-";
        if(obscd!="" && obscd != null) this.obscd = obscd; else this.obscd = "-";
        if(obsnm!="" && obsnm != null) this.obsnm = obsnm; else this.obsnm = "-";
        if(clsyn!="" && clsyn != null) this.clsyn = clsyn; else this.clsyn = "-";
        if(obsknd!="" && obsknd != null) this.obsknd = obsknd; else this.obsknd = "-";
        if(sbsncd!="" && sbsncd != null) this.sbsncd = sbsncd; else this.sbsncd = "-";
        if(mngorg!="" && mngorg != null) this.mngorg = mngorg; else this.mngorg = "-";
        if(ym!="" && ym != null) this.ym = ym; else this.ym = "-";
        if(dtrf!="" && dtrf != null) this.dtrf = dtrf; else this.dtrf = "-";
        if(obsnmeng!="" && obsnmeng != null) this.obsnmeng = obsnmeng; else this.obsnmeng = "-";
        if(opendt!="" && opendt != null) this.opendt = opendt; else this.opendt = "-";
        if(addr!="" && addr != null) this.addr = addr; else this.addr = "-";
        if(lon!="" && lon != null) this.lon = lon; else this.lon = "-";
        if(lat!="" && lat != null) this.lat = lat; else this.lat = "-";
        if(shgt!="" && shgt != null) this.shgt = shgt; else this.shgt = "-";
        if(hrdtstart!="" && hrdtstart != null) this.hrdtstart = hrdtstart; else this.hrdtstart = "-";
        if(hrdtend!="" && hrdtend != null) this.hrdtend = hrdtend; else this.hrdtend = "-";
        if(dydtstart!="" && dydtstart != null) this.dydtstart = dydtstart; else this.dydtstart = "-";
        if(dydtend!="" && dydtend != null) this.dydtend = dydtend; else this.dydtend = "-";
        if(ymdh!="" && ymdh != null) this.ymdh = ymdh; else this.ymdh = "-";
        if(rf!="" && rf != null) this.rf = rf; else this.rf = "-";
    }
}
