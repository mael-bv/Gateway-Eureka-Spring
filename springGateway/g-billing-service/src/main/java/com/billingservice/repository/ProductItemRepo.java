package com.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.billingservice.entities.ProductItem;

@RepositoryRestResource
public interface ProductItemRepo extends JpaRepository<ProductItem, Long>{

}
