package com.cdsoft.integrator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ps_feature_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductFeaturesValues {

    @EmbeddedId
    ProductFeatureValueKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    ProductDetails productDetails;

    @ManyToOne
    @MapsId("featureId")
    @JoinColumn(name = "id_feature")
    Feature feature;

    @ManyToOne
    @MapsId("featureValueId")
    @JoinColumn(name = "id_feature_value")
    FeatureValue featureValue;
}
