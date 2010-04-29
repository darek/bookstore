package com.darekzon.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darekzon.bookstore.domain.AccountRole;
import com.darekzon.bookstore.domain.Administrator;
import com.darekzon.bookstore.exception.UserExistsException;
import com.darekzon.bookstore.service.AccountService;

@Controller
public class AdministratorController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/administrator/add",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mav = new ModelAndView("/administrator/add");
		mav.addObject("administrator",new Administrator());
		
		return mav;
	}
	
	@RequestMapping(value="/administrator/add",method=RequestMethod.POST)
	public ModelAndView add(@Valid Administrator admin,BindingResult result){
		ModelAndView mav = new ModelAndView("administrator/add");
		if(!admin.getPassword().equals(admin.getRepeatedPassword())){
			result.addError(new FieldError("administrator", "repeatedPassword", "not.equal"));
		}
		if(result.hasErrors()){
			mav.addObject("administrator",admin);
			return mav;
		}
		List<AccountRole> ar = new ArrayList<AccountRole>();
		ar.add(new AccountRole("ROLE_ADMIN"));
		try {
			accountService.registerAccount(admin);
		} catch (UserExistsException e) {
			result.reject("user.exists");
			mav.addObject("administrator",admin);
		}
		return mav;
	}
	
}
