package com.circle.demo.customer.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "username")
    private User user;


}
