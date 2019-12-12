package com.mindtree.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.customer.dto.Customer;
import com.mindtree.customer.repository.CustomerRepository;
import com.mindtree.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class CustomerServiceImpl.
 */
@Service

/** The Constant log. */
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	/** The customer service repository. */
	@Autowired
	CustomerRepository customerServiceRepository;

	/* (non-Javadoc)
	 * @see com.mindtree.customer.service.CustomerService#getCustomerList()
	 */
	@Override
	public List<Customer> getCustomerList() {
		log.info("CustomerServiceImpl : getCustomerList {} entry");
		List<Customer> customerList = customerServiceRepository.findAll();
		log.info("CustomerServiceImpl : getCustomerList {} exit");
		return customerList;
	}

	/* (non-Javadoc)
	 * @see com.mindtree.customer.service.CustomerService#addCustomer(com.mindtree.customer.dto.Customer)
	 */
	@Override
	public Customer addCustomer(Customer customerDetails) {
		log.info("CustomerServiceImpl : addCustomer {} entry");
		Customer data = customerServiceRepository.save(customerDetails);
		log.info("CustomerServiceImpl : addCustomer {} exit");
		return data;
	}

}
