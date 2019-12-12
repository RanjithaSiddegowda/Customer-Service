package com.mindtree.customer.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new customer.
 *
 * @param id the id
 * @param name the name
 * @param age the age
 * @param gender the gender
 * @param address the address
 */
@AllArgsConstructor

/**
 * Instantiates a new customer.
 */
@NoArgsConstructor
@Entity
public class Customer {

	/** The id. */
	@Id
	@GeneratedValue
	private int id;

	/** The name. */
	private String name;

	/** The age. */
	private int age;

	/** The gender. */
	private String gender;

	/** The address. */
	private String address;

}