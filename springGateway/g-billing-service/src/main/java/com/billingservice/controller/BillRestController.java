package com.billingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.billingservice.entities.Bill;
import com.billingservice.repository.BillRepo;
import com.billingservice.repository.ProductItemRepo;
import com.billingservice.service.CustomerService;
import com.billingservice.service.InventoryService;

@RestController
public class BillRestController {
	@Autowired
	private BillRepo billRepo;
	@Autowired
	private ProductItemRepo itemRepo;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/fullBill/{id}")
	public Bill getBill(@PathVariable(name = "id" )Long id) {
		Bill b1 = billRepo.findById(id).get();
		b1.setCustomer(customerService.findCustomerById(b1.getCustomerId()));
		b1.getProductItems().forEach(pi->{
			pi.setProduct(inventoryService.findProductById(pi.getProductId()));
		});
		return b1;
		
	}
	
}
