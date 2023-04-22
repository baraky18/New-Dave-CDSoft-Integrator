package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductFeatureValueKey implements Serializable {

    @Column(name = "id_product")
    Long productId;

    @Column(name = "id_feature")
    Long featureId;

    @Column(name = "id_feature_value")
    Long featureValueId;
}
