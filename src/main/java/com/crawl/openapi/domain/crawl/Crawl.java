package com.crawl.openapi.domain.crawl;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Crawl {

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

}
