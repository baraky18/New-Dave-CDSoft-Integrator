package com.cdsoft.integrator.repositories;

import com.cdsoft.integrator.dtos.FeatureValueDto;
import com.cdsoft.integrator.entities.ProductDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetails, String> {

    Optional<ProductDetails> getByProductName(String productName);

    Optional<List<ProductDetails>> getAllByProductFeaturesValuesIn(List<FeatureValueDto> featureValueDtoList);
}
