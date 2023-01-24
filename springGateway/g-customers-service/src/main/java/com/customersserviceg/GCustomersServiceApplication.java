package com.customersserviceg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.customersserviceg.entities.Customer;
import com.customersserviceg.repository.CustomerRepo;

@SpringBootApplication
public class GCustomersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GCustomersServiceApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepo customerRepo,RepositoryRestConfiguration configuration) {
		return argz->{
			configuration.exposeIdsFor(Customer.class);
			customerRepo.save(new Customer(null,"eric","eric@hotmail.fr"));
			customerRepo.save(new Customer(null,"mathieu","mathieu@hotmail.fr"));
			customerRepo.save(new Customer(null,"laurant","laurant@hotmail.fr"));
			customerRepo.findAll().forEach(System.out::println);
			
		};
	}

}
