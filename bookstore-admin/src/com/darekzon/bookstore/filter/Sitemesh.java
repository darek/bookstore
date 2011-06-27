package com.darekzon.bookstore.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class Sitemesh extends ConfigurableSiteMeshFilter {
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/login.html", "/views/layout/login.jsp");
		builder.addDecoratorPath("/*", "/views/layout/default.jsp");
	}
	
	
}
