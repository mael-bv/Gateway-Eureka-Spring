package com.billingservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.billingservice.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long productId;
	@Transient
	private Product product;
	private double price;
	private double quantity;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Bill bill;
	

}
