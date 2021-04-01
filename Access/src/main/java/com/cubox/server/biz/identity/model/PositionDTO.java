package com.cubox.server.biz.identity.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class PositionDTO {
    private UUID id;

    private String name;

    private String description;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;
}
