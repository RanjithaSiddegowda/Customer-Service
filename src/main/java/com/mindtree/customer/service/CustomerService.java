package com.mindtree.customer.service;

import java.util.List;

import com.mindtree.customer.dto.Customer;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	public List<Customer> getCustomerList();

	/**
	 * Adds the customer.
	 *
	 * @param customerDetails the customer details
	 * @return the customer
	 */
	public Customer addCustomer(Customer customerDetails);
}
