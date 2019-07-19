package com.xor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String city;
	private String address;
}