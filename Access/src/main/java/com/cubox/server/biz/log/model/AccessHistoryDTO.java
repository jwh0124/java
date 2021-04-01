package com.cubox.server.biz.log.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AccessHistoryDTO {
    
    private UUID id;

    private String deviceId;

    private String userId;

    private String accessType;

    private String authType;

    private LocalDateTime accessTime;
}
