package com.crawl.openapi.web;

import com.crawl.openapi.service.CrawlingService;
import com.crawl.openapi.service.ParamService;
import com.crawl.openapi.web.dto.ParamSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("rf")
public class RfController {

    private final CrawlingService crawlingService;

    @GetMapping("/w1")
    public String w1() {return "rf/w1";}

    @SneakyThrows
    @PostMapping("/save/w1")
    public void getRfW1Data(@RequestBody ParamSaveRequestDto requestDto) throws Exception {

        crawlingService.getRfW1Data();
    }
}
