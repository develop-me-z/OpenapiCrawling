package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.RadarCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.RadarCrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("gis")
public class GisController {

    private final RadarCrawlingService crawlingService;

    @GetMapping("/radar")
    public String radar() throws Exception {

        return "gis/radar";
    }


    @PostMapping("/search/radar")
    public ModelAndView searchRadarData(@RequestBody RadarCrawlingRequestDto param) throws Exception {

        String url = crawlingService.getGisData("w20",param);
        url = "redirect:"+url;

        return new ModelAndView("redirect:"+url);
    }

}
