package com.tutorial.configs;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

@Configuration
public class JsfConfig extends SpringBootServletInitializer implements ServletContextAware {

	@Override
	public void setServletContext(ServletContext servletContext) {
		   servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServlet() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>();
		registration.setServlet(new FacesServlet());
		registration.setUrlMappings(Arrays.asList("*.xhtml","*.jsf"));
		registration.setLoadOnStartup(1);
		return registration;
	}



}
