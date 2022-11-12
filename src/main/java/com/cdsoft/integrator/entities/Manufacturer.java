package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ps_manufacturer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manufacturer")
    private Long manufacturerId;

    @Column(name = "name")
    private String manufacturerName;
}
