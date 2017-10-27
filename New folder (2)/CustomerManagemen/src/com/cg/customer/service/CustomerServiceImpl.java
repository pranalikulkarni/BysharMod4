package com.cg.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customer.model.Customer;
import com.cg.customer.dao.ICustomerDao;
//import com.cg.customer.exception.CustomerException;

@Service
@Transactional	//This annotation will make automatic transaction management  
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao dao;

	public ICustomerDao getDao() {
		return dao;
	}

	public void setDao(ICustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public Customer addDetails(Customer bean) {
		// TODO Auto-generated method stub
		return dao.addDetails(bean);
	}

	@Override
	public List<Customer> retrieveDetails() {
		// TODO Auto-generated method stub
		return dao.retrieveDetails();
	}

	@Override
	public Customer retrieveById(int id){
		// TODO Auto-generated method stub
		return dao.retrieveById(id);
	}

	public List<Integer> retrieveIds() {
		// TODO Auto-generated method stub
		return dao.retrieveIds();
	}
	/*@Override
	public Customer retrieveByMobile(Long mobile){
		// TODO Auto-generated method stub
		return dao.retrieveByMobile(mobile);
	}

	*/
	@Override
	public void deleteDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.deleteDetails(bean);
	}
/*
	@Override
	public void updateDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.updateDetails(bean);
	}*/

	@Override
	public Customer retrieveByName(String custName) {
		// TODO Auto-generated method stub
		return dao.retrieveByName(custName);
	}

	

	/*@Override
	public void findDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.findDetails(bean);
	}*/
}
