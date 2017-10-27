package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.ICustomerService;

@Controller
public class customerController {

	@Autowired
	ICustomerService service;
	
	
	
	public ICustomerService getService() {
		return service;
	}

	public void setService(ICustomerService service) {
		this.service = service;
	}

	@RequestMapping("/index")
	public String goindex()
	{
		return "index";
	}
	@RequestMapping("/start")
	public String goToStart(Model model){
		model.addAttribute("customer", new Customer());
		return "customerRegForm";
	}
	
	@RequestMapping("/reg")
	public String registration(@ModelAttribute("customer") @Valid Customer customer,BindingResult result,Model model){
		if(result.hasErrors())
		{
			return  "customerRegForm";
		}
		else{
		service.addDetails(customer);
		model.addAttribute("k", customer);
		return "customerSuccess";
		}
	}
	
	
	
	
	@RequestMapping("/goFind")
	/*public String goToFind(){
		return "custIdFind";
	}
	*/
	public ModelAndView goToFind(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	} 
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	
	
	
	
	@RequestMapping("/goDelete")
	/*public String goToDelete(){
		return "custIdDelete";
	}
	*/
	public ModelAndView goToDelete(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdDelete", "idList", idList);
	} 
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int custId){
		Customer cust = service.retrieveById(custId);
		service.deleteDetails(cust);
		return "deleteCust";
	}
	
	@RequestMapping("/ByName")
	public String goName()
	{
		return "DeleteByName";
	}
	
	@RequestMapping("/BynameId")
public ModelAndView retrieveByName(@RequestParam("custName") String custName){
		
		Customer cust = service.retrieveByName(custName);
		return new ModelAndView("findName", "p", cust);
	
}
	
}
