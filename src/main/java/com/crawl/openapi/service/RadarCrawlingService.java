package com.crawl.openapi.service;


import com.crawl.openapi.web.dto.RadarCrawlingRequestDto;
import org.springframework.stereotype.Service;

@Service
public class RadarCrawlingService {

    public String getGisData(String dev, RadarCrawlingRequestDto param) throws Exception {
        StringBuilder result = new StringBuilder();

        String paramUrl = null;
        String menu = null;


        paramUrl = "http://www.wamis.go.kr:8080/wamis/openapi/radar/radar_rainfall?";


        String urlStr = paramGisUrl(paramUrl, param);

        return urlStr;
    }


    public String paramGisUrl(String url, RadarCrawlingRequestDto param){

        String urlStr = url;

        String width = param.getWidth();
        String height = param.getHeight();
        String minx = param.getMinx();
        String miny = param.getMiny();
        String maxx = param.getMaxx();
        String maxy = param.getMaxy();
        String time = param.getTime();

        if(width!=null){
            if(!"".equals(width)) urlStr += "&width="+width;
        }
        if(height!=null) {
            if(!"".equals(height)) urlStr += "&height="+height;
        }
        if(minx!=null) {
            if(!"".equals(minx)) urlStr += "&minx="+minx;
        }
        if(miny!=null) {
            if(!"".equals(miny)) urlStr += "&miny="+miny;
        }
        if(maxx!=null) {
            if(!"".equals(maxx)) urlStr += "&maxx="+maxx;
        }
        if(maxy!=null) {
            if(!"".equals(maxy)) urlStr += "&maxy="+maxy;
        }
        if(time!=null) {
            if(!"".equals(time)) urlStr += "&time="+time;
        }

        return urlStr;
    }
    
}
