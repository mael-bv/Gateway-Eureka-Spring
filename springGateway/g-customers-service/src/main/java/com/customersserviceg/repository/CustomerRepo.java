package com.customersserviceg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.customersserviceg.entities.Customer;


@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
