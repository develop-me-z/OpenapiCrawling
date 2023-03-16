package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WkwCrawlingRequestDto {
    private String basin;
    private String mngorg;
    private String obscd;
    private String startyear;
    private String endyear;
    private String obsymd;
    private String obssthm;
    private String obsedhm;
    private String stwl;
    private String edwl;
    private String rivwith;
    private String flw;
    private String obsway;
    private String docnm;
    private String wlobscd;
    private String obsnm;
    private String wlcd;
    private String obsymdhn;
    private String surcnt;
    private String capdsy;
    private String flqsv;

    @Builder
    public WkwCrawlingRequestDto(String flqsv, String capdsy, String surcnt, String obsymdhn, String wlcd, String wlobscd, String obsnm, String obsymd, String obssthm, String obsedhm, String stwl, String edwl, String rivwith, String flw, String obsway, String docnm){

        if(flqsv!="" && flqsv != null) this.flqsv = flqsv; else this.flqsv = "-";
        if(capdsy!="" && capdsy != null) this.capdsy = capdsy; else this.capdsy = "-";
        if(surcnt!="" && surcnt != null) this.surcnt = surcnt; else this.surcnt = "-";
        if(obsymdhn!="" && obsymdhn != null) this.obsymdhn = obsymdhn; else this.obsymdhn = "-";
        if(wlcd!="" && wlcd != null) this.wlcd = wlcd; else this.wlcd = "-";
        if(obsnm!="" && obsnm != null) this.obsnm = obsnm; else this.obsnm = "-";
        if(wlobscd!="" && wlobscd != null) this.wlobscd = wlobscd; else this.wlobscd = "-";
        if(obsymd!="" && obsymd != null) this.obsymd = obsymd; else this.obsymd = "-";
        if(obssthm!="" && obssthm != null) this.obssthm = obssthm; else this.obssthm = "-";
        if(obsedhm!="" && obsedhm != null) this.obsedhm = obsedhm; else this.obsedhm = "-";
        if(stwl!="" && stwl != null) this.stwl = stwl; else this.stwl = "-";
        if(edwl!="" && edwl != null) this.edwl = edwl; else this.edwl = "-";
        if(rivwith!="" && rivwith != null) this.rivwith = rivwith; else this.rivwith = "-";
        if(flw!="" && flw != null) this.flw = flw; else this.flw = "-";
        if(obsway!="" && obsway != null) this.obsway = obsway; else this.obsway = "-";
        if(docnm!="" && docnm != null) this.docnm = docnm; else this.docnm = "-";

    }
}
