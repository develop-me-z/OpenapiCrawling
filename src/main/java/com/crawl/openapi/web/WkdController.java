package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WkdCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WkdCrawlingRequestDto;
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
@RequestMapping("wkd")
public class WkdController {

    private final WkdCrawlingService crawlingService;

    @GetMapping("/w34")
    public String w34(Model model) throws Exception {
        WkdCrawlingRequestDto dto = new WkdCrawlingRequestDto();

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w34",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkd/w34";
    }

    @GetMapping("/w35")
    public String w35(Model model) throws Exception {
        WkdCrawlingRequestDto dto = new WkdCrawlingRequestDto();

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w35",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkd/w35";
    }

    @GetMapping("/w36")
    public String w36(Model model) throws Exception {
        WkdCrawlingRequestDto dto = new WkdCrawlingRequestDto();

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w36",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkd/w36";
    }

    @GetMapping("/w37")
    public String w37(Model model) throws Exception {
        WkdCrawlingRequestDto dto = new WkdCrawlingRequestDto();

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w37",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkd/w37";
    }


    @PostMapping("/search/w34")
    public String searchW34Data(Model model, @RequestBody WkdCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkd/w34");

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w34",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkd/w34";
    }

    @PostMapping("/search/w35")
    public String searchW35Data(Model model, @RequestBody WkdCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkd/w35");

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w35",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkd/w35";
    }

    @PostMapping("/search/w36")
    public String searchW36Data(Model model, @RequestBody WkdCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkd/w36");

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w36",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkd/w36";
    }

    @PostMapping("/search/w37")
    public String searchW37Data(Model model, @RequestBody WkdCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkd/w37");

        List<WkdCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkdData("w37",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkd/w37";
    }

}
