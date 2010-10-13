package com.darekzon.bookstore.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.darekzon.bookstore.domain.Book;
import com.darekzon.bookstore.service.CatalogService;

@Controller
public class BookController {

	@Autowired
	CatalogService cService;
	
	@RequestMapping(value = "/book")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/book/index");
		
		return mav;
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("/book/add");
		mav.addObject("book", new Book());
		mav.addObject("categories",cService.getTopCategories());
		return mav;
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public ModelAndView add(@Valid Book book, BindingResult result) {
		ModelAndView mav = new ModelAndView("redirect:/book.html");
		if(!result.hasErrors()){
			System.out.println("ins");
			cService.insertBook(book);
			return mav;
		}
		System.out.println(result.getAllErrors().get(0));
		mav.setViewName("/book/add");
		mav.addObject("categories",cService.getTopCategories());
		mav.addObject("book",book);
		return mav;
	}
	
	@RequestMapping(value = "/book/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value="id") Long id) {
		ModelAndView mav = new ModelAndView("/book/add");
		Book book = cService.getBook(id);
		if(book==null){
			mav.setViewName("redirect:/book.html");
		}
		mav.addObject("categories",cService.getTopCategories());
		mav.addObject("book",book);
		return mav;
	}
	
	@RequestMapping(value = "/book/edit/{id}",method = RequestMethod.POST)
	public ModelAndView edit(@Valid Book book, BindingResult result) {
		ModelAndView mav = new ModelAndView("redirect:/book.html");
		if(!result.hasErrors()){
			book.setId(100l);
			cService.updateBook(book);
			return mav;
		}
		System.out.println("sssss");
		mav.setViewName("/book/add");
		mav.addObject("book",book);
		mav.addObject("categories",cService.getTopCategories());
		return mav;
		
	}
	
	

}
