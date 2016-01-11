package com.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(value = 1)
@Configuration
public class ApplicationInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		registerInContext(rootContext);
		rootContext.setDisplayName(getApplicationName());
		rootContext.scan(getBaseScanPackages());

		// servletContext.addListener(new ContextLoaderListener(rootContext));
		// //ContextLoaderListener can't be used with web.xml
		servletContext.addListener(new RequestContextListener());

		initJersey(servletContext);
	}

	private void registerInContext(
			AnnotationConfigWebApplicationContext rootContext) {
		rootContext.register(getClass());
	}

	private String[] getBaseScanPackages() {
		return new String[] { "com.test" };
	}

	private String getApplicationName() {
		return "spring boot jersey demo";
	}

	private String getApplicationClassName() {
		return Application.class.getName();
	}

	protected void initJersey(ServletContext servletContext) {

		final ServletRegistration.Dynamic dispatcher = servletContext
				.addServlet("jersey", new ServletContainer());

		dispatcher.setInitParameter("javax.ws.rs.Application",
				getApplicationClassName());
		dispatcher.setInitParameter(ServerProperties.WADL_FEATURE_DISABLE,
				"true");
		dispatcher.setInitParameter(ServerProperties.APPLICATION_NAME,
				getApplicationName());

		dispatcher.addMapping("/*");
		dispatcher.setLoadOnStartup(1);
	}
}