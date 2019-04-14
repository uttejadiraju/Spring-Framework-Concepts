package requestBodyExample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigJava implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext apc = new AnnotationConfigWebApplicationContext();
		apc.register(BeanConfig.class);
		apc.setServletContext(servletContext);

		ServletRegistration.Dynamic disp = servletContext.addServlet("Dispatcherservlet", new DispatcherServlet(apc));
		disp.addMapping("/");
		disp.setLoadOnStartup(1);
	}

}
