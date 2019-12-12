package com.mindtree.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.customer.dto.Customer;
import com.mindtree.customer.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController{
	
	/** The customer service. */
	@Autowired
	CustomerService customerService;
	
	private static final String FAILURE_MESSAGE = "Oops! Something went wrong. Try again after sometime";
	
	/**
	 * Gets the customer details.
	 *
	 * @return the customer details
	 */
	@GetMapping("")
	@HystrixCommand(fallbackMethod = "failure")
	public ResponseEntity<List<Customer>> getCustomerDetails() {
		log.info("CustomerController :: getCustomerDetails {} :: entry");
		List<Customer> result = customerService.getCustomerList();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public String failure() {
		return FAILURE_MESSAGE;
	}

	/**
	 * Adds the customer.
	 *
	 * @param customerDetails the customer details
	 * @return the response entity
	 */
	@PostMapping("")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customerDetails) {
		Customer result = customerService.addCustomer(customerDetails);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
}