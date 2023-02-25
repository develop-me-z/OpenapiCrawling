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

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfW1Data(dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "rf/w1";
    }

    //@ResponseBody
    @PostMapping("/search/w1")
    public String searchRfW1Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("rf/w1");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfW1Data(param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "rf/w1";
    }

    @SneakyThrows
    @PostMapping("/save/w1")
    public String getRfW1Data(Model model) throws Exception {

        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfW1Data(dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "rf/w1";
    }
}
