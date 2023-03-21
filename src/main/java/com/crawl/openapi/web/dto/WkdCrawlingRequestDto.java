package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WkdCrawlingRequestDto {
    private String basin;
    private String mngorg;
    private String damdvcd;
    private String keynm;
    private String sort;
    private String damcd;
    private String damnm;
    private String bbsncd;
    private String sbsncd;
    private String bbsnnm;
    private String mggvnm;
    private String startdt;
    private String enddt;
    private String obsdh;
    private String rwl;
    private String ospilwl;
    private String rsqty;
    private String rsrt;
    private String iqty;
    private String etqty;
    private String tdqty;
    private String edqty;
    private String spdqty;
    private String otltdqty;
    private String itqty;
    private String dambsarf;
    private String rf;
    private String obsymd;
    private String mnwl;
    private String avwl;
    private String mxwl;
    private String mniqty;
    private String aviqty;
    private String mxiqty;
    private String mntdqty;
    private String avtdqty;
    private String mxtdqty;
    private String mnsqty;
    private String avsqty;
    private String mxsqty;
    private String mnrf;
    private String avrf;
    private String mxrf;


    @Builder
    public WkdCrawlingRequestDto(String rf, String mggvnm, String bbsnnm, String sbsncd, String mngorg, String bbsncd, String obsymd, String itqty, String damcd, String damnm, String obsdh, String rwl, String ospilwl, String rsqty, String rsrt, String iqty, String etqty, String tdqty, String edqty, String spdqty, String otltdqty, String dambsarf, String mnwl, String avwl, String mxwl, String mniqty, String aviqty, String mxiqty, String mntdqty, String avtdqty, String mxtdqty, String mnsqty, String mxsqty, String mnrf, String avrf, String mxrf, String avsqty){
        if(bbsnnm!="" && bbsnnm != null) this.bbsnnm = bbsnnm; else this.bbsnnm = "-";
        if(avsqty!="" && avsqty != null) this.avsqty = avsqty; else this.avsqty = "-";
        if(mxrf!="" && mxrf != null) this.mxrf = mxrf; else this.mxrf = "-";
        if(avrf!="" && avrf != null) this.avrf = avrf; else this.avrf = "-";
        if(mnrf!="" && mnrf != null) this.mnrf = mnrf; else this.mnrf = "-";
        if(mxsqty!="" && mxsqty != null) this.mxsqty = mxsqty; else this.mxsqty = "-";
        if(mnsqty!="" && mnsqty != null) this.mnsqty = mnsqty; else this.mnsqty = "-";
        if(mxtdqty!="" && mxtdqty != null) this.mxtdqty = mxtdqty; else this.mxtdqty = "-";
        if(avtdqty!="" && avtdqty != null) this.avtdqty = avtdqty; else this.avtdqty = "-";
        if(mntdqty!="" && mntdqty != null) this.mntdqty = mntdqty; else this.mntdqty = "-";
        if(mxiqty!="" && mxiqty != null) this.mxiqty = mxiqty; else this.mxiqty = "-";
        if(aviqty!="" && aviqty != null) this.aviqty = aviqty; else this.aviqty = "-";
        if(mniqty!="" && mniqty != null) this.mniqty = mniqty; else this.mniqty = "-";
        if(mxwl!="" && mxwl != null) this.mxwl = mxwl; else this.mxwl = "-";
        if(avwl!="" && avwl != null) this.avwl = avwl; else this.avwl = "-";
        if(mnwl!="" && mnwl != null) this.mnwl = mnwl; else this.mnwl = "-";
        if(dambsarf!="" && dambsarf != null) this.dambsarf = dambsarf; else this.dambsarf = "-";
        if(otltdqty!="" && otltdqty != null) this.otltdqty = otltdqty; else this.otltdqty = "-";
        if(spdqty!="" && spdqty != null) this.spdqty = spdqty; else this.spdqty = "-";
        if(edqty!="" && edqty != null) this.edqty = edqty; else this.edqty = "-";
        if(tdqty!="" && tdqty != null) this.tdqty = tdqty; else this.tdqty = "-";
        if(etqty!="" && etqty != null) this.etqty = etqty; else this.etqty = "-";
        if(iqty!="" && iqty != null) this.iqty = iqty; else this.iqty = "-";
        if(rsrt!="" && rsrt != null) this.rsrt = rsrt; else this.rsrt = "-";
        if(rsqty!="" && rsqty != null) this.rsqty = rsqty; else this.rsqty = "-";
        if(ospilwl!="" && ospilwl != null) this.ospilwl = ospilwl; else this.ospilwl = "-";
        if(rwl!="" && rwl != null) this.rwl = rwl; else this.rwl = "-";
        if(obsdh!="" && obsdh != null) this.obsdh = obsdh; else this.obsdh = "-";
        if(damnm!="" && damnm != null) this.damnm = damnm; else this.damnm = "-";
        if(damcd!="" && damcd != null) this.damcd = damcd; else this.damcd = "-";
        if(mggvnm!="" && mggvnm != null) this.mggvnm = mggvnm; else this.mggvnm = "-";
        if(sbsncd!="" && sbsncd != null) this.sbsncd = sbsncd; else this.sbsncd = "-";
        if(mngorg!="" && mngorg != null) this.mngorg = mngorg; else this.mngorg = "-";
        if(rf!="" && rf != null) this.rf = rf; else this.rf = "-";
        if(bbsncd!="" && bbsncd != null) this.bbsncd = bbsncd; else this.bbsncd = "-";
        if(obsymd!="" && obsymd != null) this.obsymd = obsymd; else this.obsymd = "-";
        if(itqty!="" && itqty != null) this.itqty = itqty; else this.itqty = "-";

    }
}
