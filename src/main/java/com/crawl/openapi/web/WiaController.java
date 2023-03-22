package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.WiaCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.WiaCrawlingRequestDto;
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
public class WiaController { // 이수

    private final WiaCrawlingService crawlingService;

    @GetMapping("/w38")
    public String w38(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w38",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w38";
    }

    @GetMapping("/w39")
    public String w39(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w39",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w39";
    }

    @GetMapping("/w40")
    public String w40(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w40",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w40";
    }

    @GetMapping("/w41")
    public String w41(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w41",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w41";
    }

    @GetMapping("/w42")
    public String w42(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w42",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w42";
    }

    @GetMapping("/w43")
    public String w43(Model model) throws Exception {
        WiaCrawlingRequestDto dto = new WiaCrawlingRequestDto();

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w43",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w43";
    }


    @PostMapping("/search/w38")
    public String searchW38Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w38");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w38",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w38";
    }

    @PostMapping("/search/w39")
    public String searchW39Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w39");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w39",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w39";
    }

    @PostMapping("/search/w40")
    public String searchW40Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w40");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w40",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w40";
    }

    @PostMapping("/search/w41")
    public String searchW41Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w41");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w41",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w41";
    }

    @PostMapping("/search/w42")
    public String searchW42Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w42");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w42",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w42";
    }

    @PostMapping("/search/w43")
    public String searchW43Data(Model model, @RequestBody WiaCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w43");

        List<WiaCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getWiaData("w43",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w43";
    }
}
