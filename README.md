# springboot-rest-jwt
Spring Boot REST with JWT authentication Example

## 1. How to start

1. To run the application start StartCustomerApplication.java

2. Call signin API using below URL from postman to get token

 	 URL      - http://localhost:8080/auth/signin
 	 Type     - POST
 	 Headers  - Content-Type - application/json
 	 Body     -      
 	 	        		
				{
					"username":"user",
					"password":"password"
				}
			
 	  Response - 	  
   
			    {
					"username": "user",
					"token": eyJhbGciOiJIUzI1NiJ9.
					eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0s
					ImlhdCI6MTU2MzUyNzI1MiwiZXhwIjoxNTYzNTMwODUyfQ.
					EW2o6rklAr4RbqJ3sxEmmzs5njdOspdRlwxQ8SVWJv8"
			    }

 	  
3. Use the response token to call remaining customer API using Postman /any other Http client

4. Create Customer API URL - http://localhost:8080/customers
   Type                    - POST
   Headers                 - Content-Type - application/json
   			               - Authorization - Bearer token
   Body                    -   
         
				          {                  
								"firstName":"Amit",
								"lastName":"Jadhav",
								"city":"Pune",
								"address":"Magarpatta"
							}   	


5. Get All Customer API URL   - http://localhost:8080/customers
   Type                       - GET
   Headers                    - Authorization - Bearer token
   
   
6. Get Customer By Id API URL - http://localhost:8080/customers/1
   Type 					  - GET
   Headers                    - Authorization - Bearer token  
     

7. Update Customer API URL - http://localhost:8080/customers/1
   Type                    - PUT
   Headers                 - Authorization - Bearer token
   						   - Content-Type - application/json
   Body                    - 
          
				         {                  
								"firstName":"Amit",
								"lastName":"Jadhav",
								"city":"Pune",
								"address":"Magarpatta"
							}   	

8. Delete Customer By Id API URL - http://localhost:8080/customers/1
   Type                          - DELETE
   Headers                       - Authorization - Bearer token  			
