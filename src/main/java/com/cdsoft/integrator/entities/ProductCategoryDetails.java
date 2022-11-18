package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ps_category_lang")
@NoArgsConstructor
@AllArgsConstructor
@Data
@PrimaryKeyJoinColumn(name = "id_category")
public class ProductCategoryDetails extends ProductCategory {

    @Column(name = "name")
    private String categoryName;

    @Column(name = "id_lang")
    private String idLang;
}
