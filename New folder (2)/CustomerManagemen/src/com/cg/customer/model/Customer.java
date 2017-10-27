package com.cg.customer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "Custome")
@NamedQueries({@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
	@NamedQuery(name = "getCustomerId", query = "SELECT custId FROM Customer")
		
})
public class Customer {

	@Id
	@NotNull(message="it should not be negative")
	private int custId;
	@NotEmpty
	@Pattern(regexp="[A-Z].*",message="Should start with capital letter")
	private String custName;
	@NotEmpty
	@Length(min=10,max=10,message="It should not be less than 10 characters")
	private String mobile;
	@NotEmpty(message="Please enter email id")
	private String email;
	@NotNull(message="please enter the date of birth")
	private Date birthDate;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
