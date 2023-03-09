package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
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

    private final CrawlingService crawlingService;

    @GetMapping("/w16")
    public String w16(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w16",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkw/w16";
    }

    @GetMapping("/w17")
    public String w17() {

        return "wkw/w17";
    }

    @GetMapping("/w18")
    public String w18(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w18",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkw/w18";
    }

    @GetMapping("/w19")
    public String w19() {

        return "wkw/w19";
    }


    //@ResponseBody
    @PostMapping("/search/w16")
    public String searchRfW1Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w16");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w16",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w16";
    }

    @PostMapping("/search/w17")
    public String searchRfW2Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w17");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w17",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w17";
    }

    @PostMapping("/search/w18")
    public String searchW18Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w18");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w18",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w18";
    }

    @PostMapping("/search/w19")
    public String searchW19Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkw/w19");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w19",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkw/w19";
    }

}
