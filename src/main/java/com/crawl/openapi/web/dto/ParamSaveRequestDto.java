package com.crawl.openapi.web.dto;

import com.crawl.openapi.domain.param.Param;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParamSaveRequestDto {
    private String basin;
    private String oper;
    private String mngorg;
    private String obsknd;
    private String keynm;
    private String sort;


     public ParamSaveRequestDto(String basin, String oper, String mngorg, String obsknd, String keynm, String sort){
        this.basin = basin;
        this.oper = oper;
        this.mngorg = mngorg;
        this.obsknd = obsknd;
        this.keynm =keynm;
        this.sort = sort;

    }

    public Param toEntity(){
        return Param.builder()
                .basin(basin)
                .oper(oper)
                .mngorg(mngorg)
                .obsknd(obsknd)
                .keynm(keynm)
                .sort(sort)
                .build();
    }
}
