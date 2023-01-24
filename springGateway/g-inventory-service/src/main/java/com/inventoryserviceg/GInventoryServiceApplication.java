package com.inventoryserviceg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.inventoryserviceg.entities.Product;
import com.inventoryserviceg.repository.ProductRepo;

@SpringBootApplication
public class GInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GInventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepo productRepo,
											RepositoryRestConfiguration restConfiguration) {
		return argz->{
			restConfiguration.exposeIdsFor(Product.class);
			productRepo.save(new Product(null,"PS5",499));
			productRepo.save(new Product(null,"Xbox",399));
			productRepo.save(new Product(null,"Nitendo switch",299));
			productRepo.findAll().forEach(System.out::println);
		};
	}

}
