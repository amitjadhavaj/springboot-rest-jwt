package com.xor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xor.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
