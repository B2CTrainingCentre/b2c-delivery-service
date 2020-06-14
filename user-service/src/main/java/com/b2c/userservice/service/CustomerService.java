package com.b2c.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.userservice.model.Customer;
import com.b2c.userservice.persist.ICustomerDao;

import lombok.Data;
@Data
@Service
public class CustomerService {
	@Autowired
	private ICustomerDao iCustomerDao;
	
	public int insertCustomerData(Customer customer) {
		return iCustomerDao.saveCustomer(customer);
	}
	
	public Customer getCustomerData(int id) {
		return iCustomerDao.getCustomerRseResult(id);
	}
	
	public Customer updateCustomerData(int id, String email) {
		return iCustomerDao.updateCustomerResult1(id, email);
			
	}
	
	public Customer deleteCustomerData(int id) {
		return iCustomerDao.deleteCustomerResult2(id);
			
	}

}
