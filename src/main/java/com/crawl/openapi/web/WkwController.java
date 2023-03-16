package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WkwCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WkwCrawlingRequestDto;
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
@RequestMapping("wkw")
public class WkwController {

    private final WkwCrawlingService crawlingService;

    @GetMapping("/w16")
    public String w16(Model model) throws Exception {
        WkwCrawlingRequestDto dto = new WkwCrawlingRequestDto();

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w16",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkw/w16";
    }

    @GetMapping("/w17")
    public String w17() {

        return "wkw/w17";
    }

    @GetMapping("/w18")
    public String w18(Model model) throws Exception {
        WkwCrawlingRequestDto dto = new WkwCrawlingRequestDto();

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w18",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkw/w18";
    }

    @GetMapping("/w19")
    public String w19() {

        return "wkw/w19";
    }


    //@ResponseBody
    @PostMapping("/search/w16")
    public String searchRfW1Data(Model model, @RequestBody WkwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w16");

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w16",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w16";
    }

    @PostMapping("/search/w17")
    public String searchRfW2Data(Model model, @RequestBody WkwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w17");

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w17",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w17";
    }

    @PostMapping("/search/w18")
    public String searchW18Data(Model model, @RequestBody WkwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w18");

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w18",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w18";
    }

    @PostMapping("/search/w19")
    public String searchW19Data(Model model, @RequestBody WkwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w19");

        List<WkwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkwData("w19",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w19";
    }

}
