package com.cdsoft.integrator.mappers;

import com.cdsoft.integrator.dtos.FeatureValueDto;
import com.cdsoft.integrator.entities.ProductFeaturesValues;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductFeaturesValuesToFeatureValuesDtoMapper implements Mapper<List<FeatureValueDto>, List<ProductFeaturesValues>>{

    public List<FeatureValueDto> map(List<ProductFeaturesValues> productFeaturesValues) {
        List<FeatureValueDto> featureValueDtoList = new ArrayList<>();
        productFeaturesValues.stream().distinct().forEach(p -> featureValueDtoList.add(
                FeatureValueDto.builder()
                        .featureName(p.getFeature().getFeatureName())
                        .featureValue(p.getFeatureValue().getFeatureValueName())
                        .build()));
        return featureValueDtoList;
    }
}
