package com.crawl.openapi.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RadarCrawlingRequestDto {
    private String width;
    private String height;
    private String minx;
    private String miny;
    private String maxx;
    private String maxy;
    private String time;

}
