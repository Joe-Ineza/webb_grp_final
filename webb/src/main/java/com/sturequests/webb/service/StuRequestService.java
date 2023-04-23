package com.sturequests.webb.service;

import com.sturequests.webb.dto.StuRequestDto;
import com.sturequests.webb.models.StuRequest;

import java.util.List;

public interface StuRequestService {
    StuRequest saveRequest(StuRequestDto sturequestDto);
//    void updateRequest(SturequestDto sturequest);
//    void deleteRequest(Long ident);

    List<StuRequestDto> findAllRequests();


}
