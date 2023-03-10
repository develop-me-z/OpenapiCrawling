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

}
