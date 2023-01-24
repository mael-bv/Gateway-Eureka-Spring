package com.billingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.billingservice.models.Customer;

@FeignClient(name="CUSTOMERS-SERVICE")
public interface CustomerService {
	
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable(name = "id") Long id);

}
