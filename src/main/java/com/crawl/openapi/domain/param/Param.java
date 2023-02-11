package com.crawl.openapi.domain.param;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String basin;
    private String oper;
    private String mngorg;
    private String obsknd;
    private String keynm;
    private String sort;
    private String output;

    @Builder
    public Param(String basin, String oper, String mngorg, String obsknd, String keynm, String sort, String output){
        this.basin = basin;
        this.oper = oper;
        this.mngorg = mngorg;
        this.obsknd = obsknd;
        this.keynm =keynm;
        this.sort = sort;
        this.output = output;
    }
}
