package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WksCrawlingRequestDto { // 수도시설
    private String admcd;
    private String basin;
    private String afest;
    private String cptyr;
    private String estvol;
    private String spara;
    private String usg;
    private String wstype;
    private String bfest;
    private String cwtype;
    private String cnt;
    private String hp;
    private String phg;
    private String type;
    private String elev;
    private String emghr;
    private String mnws;
    private String mxws;
    private String wsara;
    private String dayuse;
    private String rstype;
    private String wspop;
    private String wsmd;
    private String addr;
    private String bsncd;
    private String bsnnm;
    private String edyr;
    private String estnm;
    private String rivnm;
    private String estdv;

    @Builder
    public WksCrawlingRequestDto(String afest, String cptyr, String estvol, String spara, String usg, String wstype, String bfest, String cwtype, String cnt, String hp, String phg, String type, String elev, String emghr, String mnws, String mxws, String wsara, String dayuse, String rstype, String wspop, String wsmd, String addr, String bsncd, String bsnnm, String edyr, String estnm, String rivnm, String estdv){
        if(wsmd!="" && wsmd != null) this.wsmd = wsmd; else this.wsmd = "-";
        if(estdv!="" && estdv != null) this.estdv = estdv; else this.estdv = "-";
        if(rivnm!="" && rivnm != null) this.rivnm = rivnm; else this.rivnm = "-";
        if(estnm!="" && estnm != null) this.estnm = estnm; else this.estnm = "-";
        if(edyr!="" && edyr != null) this.edyr = edyr; else this.edyr = "-";
        if(bsnnm!="" && bsnnm != null) this.bsnnm = bsnnm; else this.bsnnm = "-";
        if(bsncd!="" && bsncd != null) this.bsncd = bsncd; else this.bsncd = "-";
        if(addr!="" && addr != null) this.addr = addr; else this.addr = "-";
        if(wspop!="" && wspop != null) this.wspop = wspop; else this.wspop = "-";
        if(rstype!="" && rstype != null) this.rstype = rstype; else this.rstype = "-";
        if(dayuse!="" && dayuse != null) this.dayuse = dayuse; else this.dayuse = "-";
        if(wsara!="" && wsara != null) this.wsara = wsara; else this.wsara = "-";
        if(mxws!="" && mxws != null) this.mxws = mxws; else this.mxws = "-";
        if(mnws!="" && mnws != null) this.mnws = mnws; else this.mnws = "-";
        if(emghr!="" && emghr != null) this.emghr = emghr; else this.emghr = "-";
        if(elev!="" && elev != null) this.elev = elev; else this.elev = "-";
        if(type!="" && type != null) this.type = type; else this.type = "-";
        if(phg!="" && phg != null) this.phg = phg; else this.phg = "-";
        if(hp!="" && hp != null) this.hp = hp; else this.hp = "-";
        if(cnt!="" && cnt != null) this.cnt = cnt; else this.cnt = "-";
        if(cwtype!="" && cwtype != null) this.cwtype = cwtype; else this.cwtype = "-";
        if(bfest!="" && bfest != null) this.bfest = bfest; else this.bfest = "-";
        if(wstype!="" && wstype != null) this.wstype = wstype; else this.wstype = "-";
        if(usg!="" && usg != null) this.usg = usg; else this.usg = "-";
        if(spara!="" && spara != null) this.spara = spara; else this.spara = "-";
        if(estvol!="" && estvol != null) this.estvol = estvol; else this.estvol = "-";
        if(cptyr!="" && cptyr != null) this.cptyr = cptyr; else this.cptyr = "-";
        if(afest!="" && afest != null) this.afest = afest; else this.afest = "-";

    }
}
