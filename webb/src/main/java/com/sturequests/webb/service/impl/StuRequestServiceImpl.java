package com.sturequests.webb.service.impl;

import com.sturequests.webb.dto.StuRequestDto;
import com.sturequests.webb.models.StuRequest;
import com.sturequests.webb.repository.StuRequestRepository;
import com.sturequests.webb.service.StuRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.sturequests.webb.mapper.StuRequestMapper.mapToStuRequest;
import static com.sturequests.webb.mapper.StuRequestMapper.mapToStuRequestDto;

@Service
public class StuRequestServiceImpl implements StuRequestService {

    private StuRequestRepository sturequestRepository;


    @Autowired
    public StuRequestServiceImpl(StuRequestRepository sturequestRepository){
        this.sturequestRepository = sturequestRepository;
    }


    @Override
    public StuRequest saveRequest(StuRequestDto sturequestDto) {
        StuRequest sturequest = mapToStuRequest(sturequestDto);
        return sturequestRepository.save(sturequest);
    }



    @Override
    public List<StuRequestDto> findAllRequests() {
        List<StuRequest> stuRequests = sturequestRepository.findAll();
        return stuRequests.stream().map((stuRequest) -> mapToStuRequestDto(stuRequest)).collect(Collectors.toList());
    }

    @Override
    public StuRequestDto findRequestById(Long requId) {
        StuRequest stuRequest = sturequestRepository.findById(requId).get();
        return mapToStuRequestDto(stuRequest);
    }

    @Override
    public void updateRequest(StuRequestDto stuReq) {
        StuRequest stuRequest = mapToStuRequest(stuReq);
        sturequestRepository.save(stuRequest);
    }
}
