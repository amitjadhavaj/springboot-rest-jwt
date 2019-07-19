package com.xor.exception;

import com.xor.constant.Constants;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(Long id) {
        super(Constants.CUSTOMER_NOT_FOUND + id);
    }
}