package com.darekzon.bookstore.filter;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.builder.*;

public class Sitemesh extends ConfigurableSiteMeshFilter{
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
	    builder.addDecoratorPath("/*", "/views/layout/default.jsp");
	    builder.setMimeTypes("text/html");
	    
	  }
}
