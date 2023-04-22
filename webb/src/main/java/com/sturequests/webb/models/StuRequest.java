package com.sturequests.webb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="srequests")
public class StuRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ident;
    private String email;
    private String typeOfRequest;
    private String requestStatus;
    private String studentId;
    private String lecturerResponse;
    private String examOfficerResponse;
    private String hodResponse;
    private byte[] requiredDocs;

    @CreationTimestamp
    private LocalDateTime submittedOn;

    @UpdateTimestamp
    private LocalDateTime recentUpdatedOn;

//    public String getRequestStatus() {
//        return requestStatus;
//    }
//
//    public void setRequestStatus(String requestStatus) {
//        if(requestStatus != null)
//        {
//            this.requestStatus = requestStatus;
//        }
//        else
//        {
//            this.requestStatus = "PENDING";
//        }
//
//    }
//
//    public String getLecturerResponse() {
//        return lecturerResponse;
//    }
//
//    public void setLecturerResponse(String lecturerResponse) {
//        if(lecturerResponse != null)
//        {
//            this.lecturerResponse = lecturerResponse;
//        }
//        else
//        {
//            this.lecturerResponse = "PENDING";
//        }
//    }
//
//    public String getExamOfficerResponse() {
//
//        return examOfficerResponse;
//    }
//
//    public void setExamOfficerResponse(String examOfficerResponse) {
//        if(examOfficerResponse != null)
//        {
//            this.examOfficerResponse = examOfficerResponse;
//        }
//        else
//        {
//            this.examOfficerResponse = "PENDING";
//        }
//    }
//
//    public String getHodResponse() {
//        return hodResponse;
//    }
//
//    public void setHodResponse(String hodResponse) {
//        if(hodResponse != null)
//        {
//            this.hodResponse = hodResponse;
//        }
//        else
//        {
//            this.hodResponse = "PENDING";
//        }
//    }
}
