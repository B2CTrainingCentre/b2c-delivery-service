package com.b2c.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.b2c.userservice.model.Customer;
import com.b2c.userservice.service.CustomerService;

@RestController
@RequestMapping("/v1/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "insertcustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insert(@RequestBody Customer request) {
		System.out.println("helloxyz");
		System.out.println(request.getEmail());
		Customer customer = new Customer(request.getName(), request.getMobile(), request.getEmail());
		// List<Customer> list = customerService.insertData();
		Integer value = customerService.insertCustomerData(customer);
		System.out.println("hello6");
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	@GetMapping("fetchcustomer/{id}")
	public ResponseEntity<Customer> fetch(@PathVariable int id) {
		Customer value = customerService.getCustomerData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// update record into database with input from postman
	@RequestMapping(path = "updatecustomer/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> update(@PathVariable int id, @RequestBody Customer request) {
		Customer value = customerService.updateCustomerData(id, request.getEmail());
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// deactivate record in database
	@DeleteMapping(path = "deactivecustomer/{id}")
	public ResponseEntity<Customer> delete(@PathVariable int id) {
		Customer value = customerService.deleteCustomerData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

}
