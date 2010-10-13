package com.darekzon.bookstore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {

	@RequestMapping(value = "/catalog")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/catalog/index");
		
		return mav;
	}

}
