package com.cubox.server.biz.identity.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class EmployeeDTO {
    private UUID id;

    private String employeeNo;

    private String employeeName;

    private UUID accessGroupId;

    private UUID employtypeId;

    private UUID organizationId;

    private UUID positionId;

    private String email;

    private String phoneNumber;

    private LocalDateTime startDt;

    private LocalDateTime endDt;

    private LocalDateTime createDt;
    
    private LocalDateTime updateDt;
}
