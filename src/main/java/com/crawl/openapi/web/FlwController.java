package com.crawl.openapi.web;

import com.crawl.openapi.service.FlwCrawlingService;
import com.crawl.openapi.web.dto.CrawlingRequestDto;
import com.crawl.openapi.web.dto.FlwCrawlingRequestDto;
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
@RequestMapping("flw")
public class FlwController {

    private final FlwCrawlingService crawlingService;

    @GetMapping("/w14")
    public String w14(Model model) throws Exception {
        FlwCrawlingRequestDto dto = new FlwCrawlingRequestDto();

        List<FlwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getFlwData("w14",dto);
        model.addAttribute("data", crawlingRequestDtoList);

        return "flw/w14";
    }

    @GetMapping("/w15")
    public String w15() {

        return "flw/w15";
    }


    //@ResponseBody
    @PostMapping("/search/w14")
    public String searchRfW1Data(Model model, @RequestBody FlwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("flw/w14");

        List<FlwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getFlwData("w14",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "flw/w14";
    }

    @PostMapping("/search/w15")
    public String searchRfW2Data(Model model, @RequestBody FlwCrawlingRequestDto param) throws Exception {

        ModelAndView mav = new ModelAndView("flw/w15");

        List<FlwCrawlingRequestDto> crawlingRequestDtoList = crawlingService.getFlwData("w15",param);
        //mav.addObject("data", crawlingRequestDtoList);
        model.addAttribute("data", crawlingRequestDtoList);

        //return model;
        return "flw/w15";
    }

}
