package com.xor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xor.entity.Customer;
import com.xor.exception.CustomerNotFoundException;
import com.xor.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> findAllCustomers() {
		log.info("Inside CustomerServiceImpl.findAllCustomers()");
		return repository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		log.info("Inside CustomerServiceImpl.saveCustomer()");
		return repository.save(customer);
	}

	@Override
	public Customer saveOrUpdateCustomer(Customer customer, Long id) {
		log.info("Inside CustomerServiceImpl.saveOrUpdateCustomer()");
		return repository.findById(id).map(x -> {
			x.setFirstName(customer.getFirstName());
			x.setLastName(customer.getLastName());
			x.setCity(customer.getCity());
			x.setAddress(customer.getAddress());
			return repository.save(x);
		}).orElseGet(() -> {
			customer.setId(id);
			return repository.save(customer);
		});
	}

	@Override
	public Customer findCustomerById(Long id) {
		log.info("Inside CustomerServiceImpl.findCustomerById()");
		return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@Override
	public void deleteCustomerById(Long id) {
		log.info("Inside CustomerServiceImpl.deleteCustomerById()");
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new CustomerNotFoundException(id);
		}
	}
}