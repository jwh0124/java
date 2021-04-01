package com.cubox.server.biz.log.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_access_histories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessHistory {

	@Id
    private UUID id;

    @Column
    private String deviceId;

    @Column
    private String userId;

    @Column
    private String accessType;

    @Column
    private String authType;

    @Column
    private LocalDateTime accessTime;

    
}
