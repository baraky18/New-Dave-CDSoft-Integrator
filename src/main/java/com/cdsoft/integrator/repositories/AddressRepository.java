package com.cdsoft.integrator.repositories;

import com.cdsoft.integrator.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

    Optional<Address> findByPhone(String phoneNumber);
}
