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
    private String startdt;
    private String enddt;
    private String startyear;
    private String endyear;
    private String ym;
    private String dtrf;
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
    private String ymdh;
    private String rf;
    private String ymd;

    @Builder
    public CrawlingRequestDto(String bbsnm, String obscd, String obsnm, String clsyn, String obsknd, String sbsncd, String mngorg, String ym, String dtrf, String obsnmeng, String opendt, String addr, String lon, String lat, String shgt, String hrdtstart, String hrdtend, String dydtstart, String dydtend, String ymdh, String rf, String ymd){
        this.bbsnnm = bbsnm;
        this.obscd = obscd;
        this.obsnm = obsnm;
        this.clsyn = clsyn;
        this.obsknd = obsknd;
        this.sbsncd = sbsncd;
        this.mngorg = mngorg;
        this.ym = ym;
        this.dtrf = dtrf;
        this.obsnmeng = obsnmeng;
        this.opendt = opendt;
        this.addr = addr;
        this.lon = lon;
        this.lat = lat;
        this.shgt = shgt;
        this.hrdtstart = hrdtstart;
        this.hrdtend = hrdtend;
        this.dydtstart = dydtstart;
        this.dydtend = dydtend;
        this.ymdh = ymdh;
        this.rf = rf;
        this.ymd = ymd;
    }
}
