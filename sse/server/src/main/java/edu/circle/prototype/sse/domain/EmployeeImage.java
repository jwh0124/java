package edu.circle.prototype.sse.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeImage {

    @Id @GeneratedValue
    private Long id;

    @Column(columnDefinition = "BYTEA")
    private byte[] data;

    private String contentType;

    private Long size;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
