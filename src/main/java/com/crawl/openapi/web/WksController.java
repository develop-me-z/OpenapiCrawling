package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WksCrawlingService;
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

    private final WksCrawlingService crawlingService;

    // 수도시설
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
