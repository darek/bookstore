package test;

/**
 *  dzieki statycznemu importowi mozemy wywolywac metody jakby byly zaimplementowane w klasie
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.darekzon.bookstore.controller.IndexController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/WebContent/WEB-INF/web.xml"})
public class IndexControllerTest extends AbstractJUnit4SpringContextTests{

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testIndex(){
		IndexController ic = new IndexController();
		assertEquals("index/index", ic.index());
	}
}
