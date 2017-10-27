package com.cg.customer.dao;

import java.util.List;

import com.cg.customer.model.Customer;
//import com.cg.customer.exception.CustomerException;

public interface ICustomerDao {

	Customer addDetails(Customer bean);

	//Customer retrieveById(int id);

	List<Customer> retrieveDetails();

	void deleteDetails(Customer bean);

	Customer retrieveByName(String custName);

	List<Integer> retrieveIds();

	Customer retrieveById(int id);

//	void findDetails(Customer bean);

	//void deleteDetails(Customer bean);

	/*
	Customer retrieveByMobile(Long mobile);
	void updateDetails(Customer bean);
	*/


}
