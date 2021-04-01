package com.cubox.server.biz.identity.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cubox.server.common.BaseEntity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity{
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36)")
    @Type(type="uuid-char")
    private UUID id;

    private String employeeNo;

    private String employeeName;

    private String accessGroupId;

    private String employtypeId;

    private String organizationId;

    private String positionId;

    private String email;

    private String phoneNumber;

    private LocalDateTime startDt;

    private LocalDateTime endDt;
}
