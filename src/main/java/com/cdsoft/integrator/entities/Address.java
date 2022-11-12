package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ps_address")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long addressId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_mobile")
    private String mobilePhone;

    @ManyToOne()
    @JoinColumn(name = "id_customer")
    private Customer customerId;
}

