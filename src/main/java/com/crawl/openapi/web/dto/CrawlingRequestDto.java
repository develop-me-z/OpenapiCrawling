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
    private String wlobscd;
    private String mggvcd;
    private String bbsncd;
    private String obsopndt;
    private String obskdcd;
    private String rivnm;
    private String bsnara;
    private String bedslp;
    private String rvwdt;
    private String rvmjctdis;
    private String wsrdis;
    private String tmx;
    private String tmy;
    private String gdt;
    private String wltel;
    private String tdeyn;
    private String mxgrd;
    private String sistartobsdh;
    private String siendobsdh;
    private String olstartobsdh;
    private String olendobsdh;
    private String wl;


    @Builder
    public CrawlingRequestDto(String bbsnnm, String obscd, String obsnm, String clsyn, String obsknd, String sbsncd, String mngorg, String ym, String dtrf, String obsnmeng, String opendt, String addr, String lon, String lat, String shgt, String hrdtstart, String hrdtend, String dydtstart, String dydtend, String ymdh, String rf, String ymd, String wlobscd, String mggvcd, String bbsncd, String obsopndt, String obskdcd, String rivnm, String bsnara, String rvwdt, String bedslp, String rvmjctdis, String wsrdis, String tmx, String tmy, String gdt, String wltel, String tdeyn, String mxgrd, String sistartobsdh, String siendobsdh, String olstartobsdh, String olendobsdh, String wl){
        if(bbsnnm!="" && bbsnnm != null) this.bbsnnm = bbsnnm; else this.bbsnnm = "-";
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
        if(ymd!="" && ymd != null) this.ymd = ymd; else this.ymd = "-";
        if(wlobscd!="" && wlobscd != null) this.wlobscd = wlobscd; else this.wlobscd = "-";
        if(mggvcd!="" && mggvcd != null) this.mggvcd = mggvcd; else this.mggvcd = "-";
        if(bbsncd!="" && bbsncd != null) this.bbsncd = bbsncd; else this.bbsncd = "-";
        if(obsopndt!="" && obsopndt != null) this.obsopndt = obsopndt; else this.obsopndt = "-";
        if(obskdcd!="" && obskdcd != null) this.obskdcd = obskdcd; else this.obskdcd = "-";
        if(rivnm!="" && rivnm != null) this.rivnm = rivnm; else this.rivnm = "-";
        if(bsnara!="" && bsnara != null) this.bsnara = bsnara; else this.bsnara = "-";
        if(rvwdt!="" && rvwdt != null) this.rvwdt = rvwdt; else this.rvwdt = "-";
        if(bedslp!="" && bedslp != null) this.bedslp = bedslp; else this.bedslp = "-";
        if(rvmjctdis!="" && rvmjctdis != null) this.rvmjctdis = rvmjctdis; else this.rvmjctdis = "-";
        if(wsrdis!="" && wsrdis != null) this.wsrdis = wsrdis; else this.wsrdis = "-";
        if(tmx!="" && tmx != null) this.tmx = tmx; else this.tmx = "-";
        if(tmy!="" && tmy != null) this.tmy = tmy; else this.tmy = "-";
        if(gdt!="" && gdt != null) this.gdt = gdt; else this.gdt = "-";
        if(wltel!="" && wltel != null) this.wltel = wltel; else this.wltel = "-";
        if(tdeyn!="" && tdeyn != null) this.tdeyn = tdeyn; else this.tdeyn = "-";
        if(mxgrd!="" && mxgrd != null) this.mxgrd = mxgrd; else this.mxgrd = "-";
        if(sistartobsdh!="" && sistartobsdh != null) this.sistartobsdh = sistartobsdh; else this.sistartobsdh = "-";
        if(siendobsdh!="" && siendobsdh != null) this.siendobsdh = siendobsdh; else this.siendobsdh = "-";
        if(olstartobsdh!="" && olstartobsdh != null) this.olstartobsdh = olstartobsdh; else this.olstartobsdh = "-";
        if(olendobsdh!="" && olendobsdh != null) this.olendobsdh = olendobsdh; else this.olendobsdh = "-";
        if(wl!="" && wl != null) this.wl = wl; else this.wl = "-";
    }
}
