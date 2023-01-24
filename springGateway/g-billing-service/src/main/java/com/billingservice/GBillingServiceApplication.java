package com.billingservice;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.billingservice.entities.Bill;
import com.billingservice.entities.ProductItem;
import com.billingservice.models.Customer;
import com.billingservice.models.Product;
import com.billingservice.repository.BillRepo;
import com.billingservice.repository.ProductItemRepo;
import com.billingservice.service.CustomerService;
import com.billingservice.service.InventoryService;

@SpringBootApplication
@EnableFeignClients
public class GBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GBillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BillRepo billRepo,ProductItemRepo itemRepo,CustomerService customerService,InventoryService item) {
		return argz->{
				Customer c1 = customerService.findCustomerById(1L);
				System.out.println("***********************");
				System.out.println("id =" + c1.getId() + " name = " + c1.getName());
				System.out.println("******************************");
				Bill b1 = billRepo.save(new Bill(null,new Date(),c1.getId(),null,null));
				
				PagedModel<Product> products = item.findAllProducts();
				products.getContent().forEach(p->{
					itemRepo.save(new ProductItem(null,p.getId(),null,p.getPrice(),30,b1));
				});
			
 
		};
	}

}
