package com.sturequests.webb.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;


@Data
@Builder
public class StuRequestDto {
    private Long ident;
    private String email;
    private String typeOfRequest;
    private String requestStatus;
    private String studentId;
    private String lecturerResponse;
    private String examOfficerResponse;
    private String hodResponse;
    private byte[] requiredDocs;
    private LocalDateTime submittedOn;
    private LocalDateTime recentUpdatedOn;



}
