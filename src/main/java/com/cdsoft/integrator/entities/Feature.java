package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ps_feature_lang")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feature")
    private Long featureId;

    @Column(name = "name")
    private String featureName;

    @Column(name = "id_lang")
    private Long languageValue;

    @OneToMany(mappedBy = "feature")
    private List<ProductFeaturesValues> productFeaturesValues;
}
