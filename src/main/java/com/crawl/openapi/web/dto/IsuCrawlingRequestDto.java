package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IsuCrawlingRequestDto {
    private String admcd;
    private String basin;
    private String admnm;
    private String estcnt;
    private String bsnara;
    private String ecpqty;
    private String fullara;
    private String pemara;
    private String sumara;
    private String nirara;
    private String pirara;
    private String oirara;
    private String mtcnt;
    private String mxvol;
    private String totirara;
    private String itqty;
    private String address;
    private String opymd;
    private String plmaxdrngblue;
    private String plmaxdrngrain;
    private String pumpname;
    private String plmax;
    private String wastwpcnt;
    private String rainwpcal;
    private String wastwpcal;
    private String wastwpdrng;
    private String rainwpdrng;
    private String rainwpcnt;
    private String elecppyn;
    private String deodoriyn;
    private String addr;
    private String bsncd;
    private String bsnnm;
    private String drfq;
    private String edyr;
    private String estnm;
    private String esttype;
    private String mggvnm;
    private String mwsnm;
    private String wsdv;

    @Builder
    public IsuCrawlingRequestDto(String wsdv, String mwsnm, String mggvnm, String esttype, String estnm, String edyr, String drfq, String bsnnm, String bsncd, String addr, String bsnara, String admnm, String admcd, String estcnt, String ecpqty, String fullara, String pemara, String sumara, String nirara, String pirara, String oirara, String mtcnt, String mxvol, String totirara, String itqty, String address, String opymd, String plmaxdrngblue, String plmaxdrngrain, String pumpname, String plmax, String wastwpcnt, String rainwpcal, String wastwpcal, String wastwpdrng, String rainwpdrng, String rainwpcnt, String elecppyn, String deodoriyn){
        if(wsdv!="" && wsdv != null) this.wsdv = wsdv; else this.wsdv = "-";
        if(mwsnm!="" && mwsnm != null) this.mwsnm = mwsnm; else this.mwsnm = "-";
        if(mggvnm!="" && mggvnm != null) this.mggvnm = mggvnm; else this.mggvnm = "-";
        if(esttype!="" && esttype != null) this.esttype = esttype; else this.esttype = "-";
        if(estnm!="" && estnm != null) this.estnm = estnm; else this.estnm = "-";
        if(edyr!="" && edyr != null) this.edyr = edyr; else this.edyr = "-";
        if(drfq!="" && drfq != null) this.drfq = drfq; else this.drfq = "-";
        if(bsnnm!="" && bsnnm != null) this.bsnnm = bsnnm; else this.bsnnm = "-";
        if(bsncd!="" && bsncd != null) this.bsncd = bsncd; else this.bsncd = "-";
        if(addr!="" && addr != null) this.addr = addr; else this.addr = "-";
        if(deodoriyn!="" && deodoriyn != null) this.deodoriyn = deodoriyn; else this.deodoriyn = "-";
        if(elecppyn!="" && elecppyn != null) this.elecppyn = elecppyn; else this.elecppyn = "-";
        if(rainwpcnt!="" && rainwpcnt != null) this.rainwpcnt = rainwpcnt; else this.rainwpcnt = "-";
        if(rainwpdrng!="" && rainwpdrng != null) this.rainwpdrng = rainwpdrng; else this.rainwpdrng = "-";
        if(wastwpdrng!="" && wastwpdrng != null) this.wastwpdrng = wastwpdrng; else this.wastwpdrng = "-";
        if(wastwpcal!="" && wastwpcal != null) this.wastwpcal = wastwpcal; else this.wastwpcal = "-";
        if(rainwpcal!="" && rainwpcal != null) this.rainwpcal = rainwpcal; else this.rainwpcal = "-";
        if(wastwpcnt!="" && wastwpcnt != null) this.wastwpcnt = wastwpcnt; else this.wastwpcnt = "-";
        if(plmax!="" && plmax != null) this.plmax = plmax; else this.plmax = "-";
        if(plmaxdrngrain!="" && plmaxdrngrain != null) this.plmaxdrngrain = plmaxdrngrain; else this.plmaxdrngrain = "-";
        if(pumpname!="" && pumpname != null) this.pumpname = plmaxdrngrain; else this.pumpname = "-";
        if(plmaxdrngblue!="" && plmaxdrngblue != null) this.plmaxdrngblue = plmaxdrngblue; else this.plmaxdrngblue = "-";
        if(bsnara!="" && bsnara != null) this.bsnara = bsnara; else this.bsnara = "-";
        if(admnm!="" && admnm != null) this.admnm = admnm; else this.admnm = "-";
        if(admcd!="" && admcd != null) this.admcd = admcd; else this.admcd = "-";
        if(estcnt!="" && estcnt != null) this.estcnt = estcnt; else this.estcnt = "-";
        if(ecpqty!="" && ecpqty != null) this.ecpqty = ecpqty; else this.ecpqty = "-";
        if(fullara!="" && fullara != null) this.fullara = fullara; else this.fullara = "-";
        if(pemara!="" && pemara != null) this.pemara = pemara; else this.pemara = "-";
        if(sumara!="" && sumara != null) this.sumara = sumara; else this.sumara = "-";
        if(nirara!="" && nirara != null) this.nirara = nirara; else this.nirara = "-";
        if(pirara!="" && pirara != null) this.pirara = pirara; else this.pirara = "-";
        if(oirara!="" && oirara != null) this.oirara = oirara; else this.oirara = "-";
        if(mtcnt!="" && mtcnt != null) this.mtcnt = mtcnt; else this.mtcnt = "-";
        if(mxvol!="" && mxvol != null) this.mxvol = mxvol; else this.mxvol = "-";
        if(totirara!="" && totirara != null) this.totirara = totirara; else this.totirara = "-";
        if(itqty!="" && itqty != null) this.itqty = itqty; else this.itqty = "-";
        if(address!="" && address != null) this.address = address; else this.address = "-";
        if(opymd!="" && opymd != null) this.opymd = opymd; else this.opymd = "-";
    }
}
