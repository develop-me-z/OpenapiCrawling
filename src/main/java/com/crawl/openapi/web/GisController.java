package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.RadarCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.RadarCrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.net.URI;
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

    //@CrossOrigin(origins="*", methods = RequestMethod.POST)
    @PostMapping("/search/radar")
    public String searchRadarData(Model model, @RequestBody RadarCrawlingRequestDto param) throws Exception {

        String url = crawlingService.getGisData("w20",param);
        model.addAttribute("data", url);

        return "gis/radar";
    }

}
