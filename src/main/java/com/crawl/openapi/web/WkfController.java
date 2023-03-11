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
@RequestMapping("wkf")
public class WkfController {

    private final CrawlingService crawlingService;

    @GetMapping("/w28")
    public String w28(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w28",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w28";
    }

    @GetMapping("/w29")
    public String w29(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w29",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w29";
    }

    @GetMapping("/w30")
    public String w30(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w30",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w30";
    }

    @GetMapping("/w31")
    public String w31(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w31",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w31";
    }

    @GetMapping("/w32")
    public String w32(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w32",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w32";
    }

    @GetMapping("/w33")
    public String w33(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w33",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wkf/w33";
    }


    @PostMapping("/search/w28")
    public String searchW28Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w28");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w28",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w20";
    }

    @PostMapping("/search/w29")
    public String searchW29Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w29");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w29",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w29";
    }

    @PostMapping("/search/w30")
    public String searchW30Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w30");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w30",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w30";
    }

    @PostMapping("/search/w31")
    public String searchW31Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w31");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w31",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w31";
    }

    @PostMapping("/search/w32")
    public String searchW32Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w32");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w32",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w32";
    }

    @PostMapping("/search/w33")
    public String searchW33Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wkf/w33");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w33",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wkf/w33";
    }

}
