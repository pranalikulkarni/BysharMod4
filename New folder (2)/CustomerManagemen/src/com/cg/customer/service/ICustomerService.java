package com.cg.customer.service;

import java.util.List;

import com.cg.customer.model.Customer;

public interface ICustomerService {

	Customer addDetails(Customer bean);

	//Customer retrieveById(int id);

	List<Customer> retrieveDetails();

	void deleteDetails(Customer cust);

	Customer retrieveByName(String custName);

	List<Integer> retrieveIds();

	Customer retrieveById(int custId);

	//void findDetails(Customer cust);

	//void deleteDetails(Customer bean);
}
