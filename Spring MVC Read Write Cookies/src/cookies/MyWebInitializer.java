package cookies;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext apc = new AnnotationConfigWebApplicationContext();
		apc.register(WebConfig.class);
		apc.setServletContext(servletContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("springDispatcherServlet",
				new DispatcherServlet(apc));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
