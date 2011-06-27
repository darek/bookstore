package com.darekzon.bookstore.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darekzon.bookstore.service.CatalogService;

@Controller
public class SearchController {

	@Autowired
	CatalogService cService;
	
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/search/index");
		return mav;
	}

	@RequestMapping(value = "/search/find")
	public ModelAndView search(@RequestParam(value="phrase",required=true) String phrase) {
		ModelAndView mav = new ModelAndView("/search/search");
		mav.addObject("searchResults",cService.search(phrase));
		mav.addObject("phrase",phrase);
		return mav;
	}
	 
}
