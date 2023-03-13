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
@RequestMapping("wks")
public class WksController {

    private final CrawlingService crawlingService;

    @GetMapping("/w20")
    public String w20(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w20",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w20";
    }

    @GetMapping("/w21")
    public String w21(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w21",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w21";
    }

    @GetMapping("/w22")
    public String w22(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w22",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w22";
    }

    @GetMapping("/w23")
    public String w23(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w23",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w23";
    }

    @GetMapping("/w24")
    public String w24(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w24",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w24";
    }

    @GetMapping("/w25")
    public String w25(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w25",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w25";
    }

    @GetMapping("/w26")
    public String w26(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w26",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w26";
    }

    @GetMapping("/w27")
    public String w27(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w27",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w27";
    }

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
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w44",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w44";
    }

    @GetMapping("/w45")
    public String w45(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w45",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w45";
    }

    @GetMapping("/w46")
    public String w46(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w46",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w46";
    }

    @GetMapping("/w48")
    public String w48(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w48",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w48";
    }

    @GetMapping("/w49")
    public String w49(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w49",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w49";
    }

    @GetMapping("/w50")
    public String w50(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w50",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w50";
    }

    @GetMapping("/w51")
    public String w51(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w51",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w51";
    }

    @GetMapping("/w52")
    public String w52(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w52",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w52";
    }

    @GetMapping("/w53")
    public String w53(Model model) throws Exception {
        CrawlingRequestDto dto = new CrawlingRequestDto();

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w53",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "wks/w53";
    }


    @PostMapping("/search/w20")
    public String searchW20Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w20");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w20",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w20";
    }

    @PostMapping("/search/w21")
    public String searchW21Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w21");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w21",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w21";
    }

    @PostMapping("/search/w22")
    public String searchW22Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w22");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w22",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w22";
    }

    @PostMapping("/search/w23")
    public String searchW23Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w23");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w23",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w23";
    }

    @PostMapping("/search/w24")
    public String searchW24Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w24");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w24",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w24";
    }

    @PostMapping("/search/w25")
    public String searchW25Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w25");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w25",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w25";
    }

    @PostMapping("/search/w26")
    public String searchW26Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w26");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w26",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w26";
    }

    @PostMapping("/search/w27")
    public String searchW27Data(Model model, @RequestBody CrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("wks/w27");

        List<CrawlingRequestDto> crawlingRequestDtoList = crawlingService.getRfData("w27",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "wks/w27";
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

}
