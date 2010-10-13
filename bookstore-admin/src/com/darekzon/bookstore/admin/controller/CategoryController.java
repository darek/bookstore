package com.darekzon.bookstore.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darekzon.bookstore.domain.Category;
import com.darekzon.bookstore.service.CatalogService;

@Controller
public class CategoryController {

	@Autowired
	CatalogService cService;
	
	@RequestMapping(value = "/category")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/category/index");
		mav.addObject("categories",cService.getTopCategories()	);
		return mav;
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("/category/add");
		mav.addObject("category", new Category());
		mav.addObject("categories",cService.getTopCategories());
		return mav;
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ModelAndView add(@Valid Category category, BindingResult result) {
		ModelAndView mav = new ModelAndView("redirect:/category.html");
		if(!result.hasErrors()){
			cService.saveCategory(category);
			return mav;
		}
		mav.setViewName("/category/add");
		mav = add();
		mav.addObject("category",category);
		return mav;
		
	}
	
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value="id") Integer id){
		Category category = cService.findCategory(id);
		ModelAndView mav = new ModelAndView("/category/add");
		mav.addObject("category", category);
		mav.addObject("categories",cService.getTopCategories());
		return mav;	
	}
	
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id,@Valid Category category, BindingResult result){
		ModelAndView mav = new ModelAndView("redirect:/category");
		if(category.getParentId().equals(id)){
			result.addError(new FieldError("category","parent_id","Cannot set parent to itself"));
		}
		if(!result.hasErrors()){
			category.setId(id);
			cService.updateCategory(category);
			return mav;
		}
		mav.setViewName("/category/add");
		mav.addObject("category", category);
		mav.addObject("categories",cService.getTopCategories());
		return mav;	
	}

}
