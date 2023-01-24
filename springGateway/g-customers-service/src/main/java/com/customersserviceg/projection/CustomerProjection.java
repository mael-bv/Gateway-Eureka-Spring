package com.customersserviceg.projection;

import org.springframework.data.rest.core.config.Projection;

import com.customersserviceg.entities.Customer;

@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection {
	//public Long getId();
	public String getName();
	
	

}
