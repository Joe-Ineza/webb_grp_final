package com.sturequests.webb.mapper;

import com.sturequests.webb.dto.StuRequestDto;
import com.sturequests.webb.models.StuRequest;

public class StuRequestMapper {
    public static StuRequest mapToStuRequest(StuRequestDto stuRequest)
    {
        StuRequest stuRequestDto = StuRequest.builder()
                .ident(stuRequest.getIdent())
                .email(stuRequest.getEmail())
                .typeOfRequest(stuRequest.getTypeOfRequest())
                .requestStatus(stuRequest.getRequestStatus())
                .studentId(stuRequest.getStudentId())
                .lecturerResponse(stuRequest.getLecturerResponse())
                .examOfficerResponse(stuRequest.getExamOfficerResponse())
                .hodResponse(stuRequest.getHodResponse())
                .requiredDocs(stuRequest.getRequiredDocs())
                .submittedOn(stuRequest.getSubmittedOn())
                .recentUpdatedOn(stuRequest.getRecentUpdatedOn())
                .build();
        return stuRequestDto;
    }

    public static StuRequestDto mapToStuRequestDto(StuRequest stuRequest)
    {
        StuRequestDto stuRequestDto = StuRequestDto.builder()
                .ident(stuRequest.getIdent())
                .email(stuRequest.getEmail())
                .typeOfRequest(stuRequest.getTypeOfRequest())
                .requestStatus(stuRequest.getRequestStatus())
                .studentId(stuRequest.getStudentId())
                .lecturerResponse(stuRequest.getLecturerResponse())
                .examOfficerResponse(stuRequest.getExamOfficerResponse())
                .hodResponse(stuRequest.getHodResponse())
                .requiredDocs(stuRequest.getRequiredDocs())
                .submittedOn(stuRequest.getSubmittedOn())
                .recentUpdatedOn(stuRequest.getRecentUpdatedOn())
                .build();
        return stuRequestDto;
    }

}
