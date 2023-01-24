package com.billingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.billingservice.models.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryService {
	
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable(name = "id") Long id);
	
	@GetMapping("/products")
	public PagedModel<Product> findAllProducts();
	

}
