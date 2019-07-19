package com.xor.constant;

public class Constants {
	public static final String USER = "user";
	public static final String ADMIN = "admin";
	public static final String USER_PASS = "password";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
  	public static final String ROLES = "roles";
  	public static final String USER_NAME = "username";
	public static final String TOKEN = "token";
    public static final String JWT_AUTH_FAILED = "Jwt authentication failed. ";
	public static final String JWT_INVALID_EXPIRED_TOKEN = "Expired or invalid JWT token";
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String JWT_AUTH_HEADER = "Authorization";
    public static final String JWT_AUTHNTICATION_HEADER = "Authentication";
    public static final String SIGN_UP_URL = "/auth/signin";
    public static final String CUSTOMER_NOT_FOUND ="Customer is not found : ";
    public static final String INVALID_CREDENTAILS ="Invalid username/password supplied.";
    
    private Constants() {
    	
    }
}
