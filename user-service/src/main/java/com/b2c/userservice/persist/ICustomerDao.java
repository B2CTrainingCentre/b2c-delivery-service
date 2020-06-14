package com.b2c.userservice.persist;

import com.b2c.userservice.model.Customer;

public interface ICustomerDao {
	public int saveCustomer(Customer customer);
	public Customer getCustomerRseResult(int id);
	public Customer updateCustomerResult1(int id, String email);
	public Customer deleteCustomerResult2(int id);

}
