package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WkfCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WkfCrawlingRequestDto;
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
@RequestMapping("wkf")
public class WkfController {

    private final WkfCrawlingService crawlingService;

    @GetMapping("/w28")
    public String w28(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w28",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w28";
    }

    @GetMapping("/w29")
    public String w29(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w29",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w29";
    }

    @GetMapping("/w30")
    public String w30(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w30",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w30";
    }

    @GetMapping("/w31")
    public String w31(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w31",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w31";
    }

    @GetMapping("/w32")
    public String w32(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w32",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w32";
    }

    @GetMapping("/w33")
    public String w33(Model model) throws Exception {
        WkfCrawlingRequestDto dto = new WkfCrawlingRequestDto();

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w33",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w33";
    }


    @PostMapping("/search/w28")
    public String searchW28Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w28");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w28",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w20";
    }

    @PostMapping("/search/w29")
    public String searchW29Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w29");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w29",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w29";
    }

    @PostMapping("/search/w30")
    public String searchW30Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w30");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w30",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w30";
    }

    @PostMapping("/search/w31")
    public String searchW31Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w31");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w31",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w31";
    }

    @PostMapping("/search/w32")
    public String searchW32Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w32");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w32",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w32";
    }

    @PostMapping("/search/w33")
    public String searchW33Data(Model model, @RequestBody WkfCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w33");

        List<WkfCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWkfData("w33",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w33";
    }

}
