package com.darekzon.bookstore.test;

/**
 *  dzieki statycznemu importowi mozemy wywolywac metody jakby byly zaimplementowane w klasie
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.darekzon.bookstore.controller.IndexController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/war/WEB-INF/web.xml"})
public class IndexControllerTest extends AbstractJUnit4SpringContextTests{

	/**
	 * Mock do testowania zadani http / na przyszlosc
	 */
	MockHttpServletRequest request;
	
	/**
	 * kontroler ktory bedzie testowany
	 */
	IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		indexController = new IndexController();
	}

	/**
	 *  narazie prosty niepotrzebny test, wkrótce dojdzie wyciąganie bestsellerów, nowosci etc.
	 */
	@Test
	public void testIndex(){
		
		ModelAndView mav = indexController.index();
		
		assertEquals("index/index",mav.getViewName());
	}
}
