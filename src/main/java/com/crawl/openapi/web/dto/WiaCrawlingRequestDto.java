package com.crawl.openapi.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WiaCrawlingRequestDto {
    private String admcd;
    private String basin;
    private String year;
    private String total;
    private String wssum;
    private String indsum;
    private String afsum;
    private String wstot;
    private String wsuse;
    private String eluse;
    private String etuse;
    private String tsum;
    private String pwsu;
    private String fwsu;
    private String totflnd;
    private String totpdy;
    private String totls;


    @Builder
    public WiaCrawlingRequestDto(String year, String total, String wssum, String indsum, String afsum, String wstot, String wsuse, String eluse, String etuse, String tsum, String pwsu, String fwsu, String totflnd, String totpdy, String totls){
        if(totls!="" && totls != null) this.totls = totls; else this.totls = "-";
        if(totpdy!="" && totpdy != null) this.totpdy = totpdy; else this.totpdy = "-";
        if(totflnd!="" && totflnd != null) this.totflnd = totflnd; else this.totflnd = "-";
        if(fwsu!="" && fwsu != null) this.fwsu = fwsu; else this.fwsu = "-";
        if(pwsu!="" && pwsu != null) this.pwsu = pwsu; else this.pwsu = "-";
        if(tsum!="" && tsum != null) this.tsum = tsum; else this.tsum = "-";
        if(etuse!="" && etuse != null) this.etuse = etuse; else this.etuse = "-";
        if(eluse!="" && eluse != null) this.eluse = eluse; else this.eluse = "-";
        if(wsuse!="" && wsuse != null) this.wsuse = wsuse; else this.wsuse = "-";
        if(wstot!="" && wstot != null) this.wstot = wstot; else this.wstot = "-";
        if(afsum!="" && afsum != null) this.afsum = afsum; else this.afsum = "-";
        if(indsum!="" && indsum != null) this.indsum = indsum; else this.indsum = "-";
        if(wssum!="" && wssum != null) this.wssum = wssum; else this.wssum = "-";
        if(total!="" && total != null) this.total = total; else this.total = "-";
        if(year!="" && year != null) this.year = year; else this.year = "-";
        if(admcd!="" && admcd != null) this.admcd = admcd; else this.admcd = "-";
    }
}
