package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WksCrawlingRequestDto;
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
@RequestMapping("wks")
public class WksController {

    private final CrawlingService crawlingService;

    @GetMapping("/w38")
    public String w38(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w38",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w38";
    }

    @GetMapping("/w39")
    public String w39(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w39",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w39";
    }

    @GetMapping("/w40")
    public String w40(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w40",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w40";
    }

    @GetMapping("/w41")
    public String w41(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w41",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w41";
    }

    @GetMapping("/w42")
    public String w42(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w42",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w42";
    }

    @GetMapping("/w43")
    public String w43(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w43",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w43";
    }

    @GetMapping("/w44")
    public String w44(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w44",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w44";
    }

    @GetMapping("/w45")
    public String w45(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w45",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w45";
    }

    @GetMapping("/w46")
    public String w46(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w46",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w46";
    }

    @GetMapping("/w48")
    public String w48(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w48",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w48";
    }

    @GetMapping("/w49")
    public String w49(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w49",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w49";
    }

    @GetMapping("/w50")
    public String w50(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w50",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w50";
    }

    @GetMapping("/w51")
    public String w51(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w51",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w51";
    }

    @GetMapping("/w52")
    public String w52(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w52",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w52";
    }

    @GetMapping("/w53")
    public String w53(Model model) throws Exception {
        WksCrawlingRequestDto dto = new WksCrawlingRequestDto();

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w53",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w53";
    }


    @PostMapping("/search/w38")
    public String searchW38Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w38");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w38",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w38";
    }

    @PostMapping("/search/w39")
    public String searchW39Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w39");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w39",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w39";
    }

    @PostMapping("/search/w40")
    public String searchW40Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w40");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w40",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w40";
    }

    @PostMapping("/search/w41")
    public String searchW41Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w41");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w41",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w41";
    }

    @PostMapping("/search/w42")
    public String searchW42Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w42");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w42",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w42";
    }

    @PostMapping("/search/w43")
    public String searchW43Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w43");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w43",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w43";
    }

    @PostMapping("/search/w44")
    public String searchW44Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w44");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w44",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w44";
    }

    @PostMapping("/search/w45")
    public String searchW45Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w45");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w45",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w45";
    }

    @PostMapping("/search/w46")
    public String searchW46Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w46");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w46",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w46";
    }

    @PostMapping("/search/w48")
    public String searchW48Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w48");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w48",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w48";
    }

    @PostMapping("/search/w49")
    public String searchW49Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w49");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w49",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w49";
    }

    @PostMapping("/search/w50")
    public String searchW50Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w50");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w50",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w50";
    }

    @PostMapping("/search/w51")
    public String searchW51Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w51");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w51",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w51";
    }

    @PostMapping("/search/w52")
    public String searchW52Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w52");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w52",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w52";
    }

    @PostMapping("/search/w53")
    public String searchW53Data(Model model, @RequestBody WksCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w53");

        List<WksCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWksData("w53",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w53";
    }

}
