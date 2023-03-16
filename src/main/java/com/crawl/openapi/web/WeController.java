package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WeCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WeCrawlingRequestDto;
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
@RequestMapping("we")
public class WeController {

    private final WeCrawlingService crawlingService;

    @GetMapping("/w10")
    public String w10(Model model) throws Exception {
        WeCrawlingRequestDto dto = new WeCrawlingRequestDto();

        List<WeCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWeData("w10",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "we/w10";
    }

    @GetMapping("/w11")
    public String w11() {

        return "we/w11";
    }

    @GetMapping("/w12")
    public String w12() {

        return "we/w12";
    }

    @GetMapping("/w13")
    public String w13() {

        return "we/w13";
    }

    //@ResponseBody
    @PostMapping("/search/w10")
    public String searchRfW1Data(Model model, @RequestBody WeCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("we/w10");

        List<WeCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWeData("w10",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "we/w10";
    }

    @PostMapping("/search/w11")
    public String searchRfW2Data(Model model, @RequestBody WeCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("we/w11");

        List<WeCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWeData("w11",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "we/w11";
    }

    @PostMapping("/search/w12")
    public String searchRfW3Data(Model model, @RequestBody WeCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("we/w12");

        List<WeCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWeData("w12",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "we/w12";
    }

    @PostMapping("/search/w13")
    public String searchRfW4Data(Model model, @RequestBody WeCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("we/w13");

        List<WeCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWeData("w13",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "we/w13";
    }


}
