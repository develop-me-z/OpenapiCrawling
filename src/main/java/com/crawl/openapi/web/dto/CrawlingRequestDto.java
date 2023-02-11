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
    private String output;

    private String bbsnnm;
    private String obscd;
    private String obsnm;
    private String clsyn;
    private String sbsncd;

    @Builder
    public CrawlingRequestDto(String bbsnm, String obscd, String obsnm, String clsyn, String obsknd, String sbsncd, String mngorg){
        this.bbsnnm = bbsnm;
        this.obscd = obscd;
        this.obsnm = obsnm;
        this.clsyn = clsyn;
        this.obsknd = obsknd;
        this.sbsncd = sbsncd;
        this.mngorg = mngorg;
    }
}
