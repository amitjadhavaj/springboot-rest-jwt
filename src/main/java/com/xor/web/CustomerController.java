package com.xor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xor.entity.Customer;
import com.xor.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> findAll() {
		log.info("Inside CustomerController findAll()...");
		return customerService.findAllCustomers();
	}

	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody Customer customer) {
		log.info("Inside CustomerController save()...");
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/customers/{id}")
	public Customer findOne(@PathVariable Long id) {
		log.info("Inside CustomerController findOne()...");
		return customerService.findCustomerById(id);
	}

	@PutMapping("/customers/{id}")
	public Customer saveOrUpdate(@RequestBody Customer customer, @PathVariable Long id) {
		log.info("Inside CustomerController saveOrUpdate()...");
		return customerService.saveOrUpdateCustomer(customer, id);
	}

	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable Long id) {
		log.info("Inside CustomerController delete()...");
		customerService.deleteCustomerById(id);
	}
}