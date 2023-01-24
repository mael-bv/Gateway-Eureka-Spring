package com.billingservice.projection;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.billingservice.entities.Bill;
import com.billingservice.entities.ProductItem;

@Projection(name = "fullBill", types = Bill.class)
public interface BillProjection {
	public long getId();
	public Date getBillingDate();
	public Long getCustomerId();
	public Collection<ProductItem> getProductItems();

}
