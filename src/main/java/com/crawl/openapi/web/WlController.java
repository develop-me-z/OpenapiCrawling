package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WlCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WlCrawlingRequestDto;
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
@RequestMapping("wl")
public class WlController {

    private final WlCrawlingService crawlingService;

    @GetMapping("/w6")
    public String w6(Model model) throws Exception {
        WlCrawlingRequestDto dto = new WlCrawlingRequestDto();

        List<WlCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWlData("w6",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wl/w6";
    }

    @GetMapping("/w7")
    public String w7() {

        return "wl/w7";
    }

    @GetMapping("/w8")
    public String w8() {

        return "wl/w8";
    }

    @GetMapping("/w9")
    public String w9() {

        return "wl/w9";
    }

    //@ResponseBody
    @PostMapping("/search/w6")
    public String searchRfW1Data(Model model, @RequestBody WlCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wl/w6");

        List<WlCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWlData("w6",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wl/w6";
    }

    @PostMapping("/search/w7")
    public String searchRfW2Data(Model model, @RequestBody WlCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wl/w7");

        List<WlCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWlData("w7",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wl/w7";
    }

    @PostMapping("/search/w8")
    public String searchRfW3Data(Model model, @RequestBody WlCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wl/w8");

        List<WlCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWlData("w8",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wl/w8";
    }

    @PostMapping("/search/w9")
    public String searchRfW4Data(Model model, @RequestBody WlCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wl/w9");

        List<WlCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWlData("w9",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wl/w9";
    }


}
