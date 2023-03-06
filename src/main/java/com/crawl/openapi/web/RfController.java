package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.ParamService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.ParamSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("rf")
public class RfController {

    private final CrawlingService crawlingService;

    @GetMapping("/w1")
    public String w1(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w1",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "rf/w1";
    }

    @GetMapping("/w2")
    public String w2(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        return "rf/w2";
    }

    @GetMapping("/w3")
    public String w3(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        return "rf/w3";
    }

    @GetMapping("/w4")
    public String w4(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        return "rf/w4";
    }

    @GetMapping("/w5")
    public String w5(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        return "rf/w5";
    }

    //@ResponseBody
    @PostMapping("/search/w1")
    public String searchRfW1Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w1");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w1",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w1";
    }

    @PostMapping("/search/w2")
    public String searchRfW2Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w2");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w2",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w2";
    }

    @PostMapping("/search/w3")
    public String searchRfW3Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w3");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w3",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w3";
    }

    @PostMapping("/search/w4")
    public String searchRfW4Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w4");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w4",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w4";
    }

    @PostMapping("/search/w5")
    public String searchRfW5Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w5");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w5",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w5";
    }

}
