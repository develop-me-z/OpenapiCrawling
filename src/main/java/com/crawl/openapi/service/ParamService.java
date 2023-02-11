package com.crawl.openapi.service;

import com.crawl.openapi.domain.param.ParamRepository;
import com.crawl.openapi.web.dto.ParamSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ParamService {
    private final ParamRepository paramRepository;

    @Transactional
    public Long save(ParamSaveRequestDto requestDto){
        return paramRepository.save(requestDto.toEntity()).getId();
    }

}
