package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ps_feature_value_lang")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FeatureValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feature_value")
    private Long featureValueId;

    @Column(name = "value")
    private String featureValueName;

    @Column(name = "id_lang")
    private Long languageValue;

    @OneToMany(mappedBy = "featureValue")
    private List<ProductFeaturesValues> productFeaturesValues;
}
