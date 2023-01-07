package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ps_carrier")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrier")
    private Long carrierId;

    @Column(name = "name")
    private String carrierName;
}
