package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ps_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long productId;

    @ManyToMany
    @JoinTable(name = "ps_category_product",
            joinColumns = {@JoinColumn(name = "id_product")},
            inverseJoinColumns = {@JoinColumn(name = "id_category")})
    private List<ProductCategoryDetails> productCategoryDetails;

    @Column(name = "available_for_order")
    private int isInStock;

    @OneToOne
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;

    @Column(name = "price")
    private double price;
}
