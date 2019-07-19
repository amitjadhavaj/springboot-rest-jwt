package com.xor.service;

import java.util.List;

import com.xor.entity.Customer;

public interface CustomerService {
	List<Customer> findAllCustomers();

	Customer saveCustomer(Customer customer);
	
	Customer saveOrUpdateCustomer(Customer customer,Long id);

	Customer findCustomerById(Long id);

	void deleteCustomerById(Long id);
}
