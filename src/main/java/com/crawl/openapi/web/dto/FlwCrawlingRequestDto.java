package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FlwCrawlingRequestDto {
    private String basin;
    private String mngorg;
    private String keynm;
    private String sort;
    private String bbsnnm;
    private String obscd;
    private String obsnm;
    private String minyear;
    private String maxyear;
    private String sbsncd;
    private String year;
    private String ymd;
    private String fw;

    @Builder
    public FlwCrawlingRequestDto(String bbsnnm, String obscd, String obsnm, String sbsncd, String mngorg, String ymd, String minyear, String maxyear, String fw){
        if(bbsnnm!="" && bbsnnm != null) this.bbsnnm = bbsnnm; else this.bbsnnm = "-";
        if(obscd!="" && obscd != null) this.obscd = obscd; else this.obscd = "-";
        if(obsnm!="" && obsnm != null) this.obsnm = obsnm; else this.obsnm = "-";
        if(sbsncd!="" && sbsncd != null) this.sbsncd = sbsncd; else this.sbsncd = "-";
        if(mngorg!="" && mngorg != null) this.mngorg = mngorg; else this.mngorg = "-";
        if(ymd!="" && ymd != null) this.ymd = ymd; else this.ymd = "-";
        if(minyear!="" && minyear != null) this.minyear = minyear; else this.minyear = "-";
        if(maxyear!="" && maxyear != null) this.maxyear = maxyear; else this.maxyear = "-";
        if(fw!="" && fw != null) this.fw = fw; else this.fw = "-";

    }
}
