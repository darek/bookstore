package com.darekzon.bookstore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	public String index() {
		return "index/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false, defaultValue = "false") boolean error) {
		ModelAndView mav = new ModelAndView("index/login");
		mav.addObject("isError", error);
		return mav;
	}

}
