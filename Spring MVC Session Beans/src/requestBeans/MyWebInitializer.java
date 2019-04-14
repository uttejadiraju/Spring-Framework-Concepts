package requestBeans;

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
/**
 * 
 * Open Declaration org.springframework.web.WebApplicationInitializer
 * 
 * 
 * Interface to be implemented in Servlet 3.0+ environments in order to
 * configure the ServletContext programmatically -- as opposed to (or possibly
 * in conjunctionwith) the traditional web.xml-based approach.
 * 
 * Implementations of this SPI will be detected automatically by
 * SpringServletContainerInitializer, which itself is bootstrapped
 * automaticallyby any Servlet 3.0 container. See itsJavadoc for details on this
 * bootstrapping mechanism.
 * 
 * Example
 * 
 * The traditional, XML-based approach Most Spring users building a web
 * application will need to register Spring's DispatcherServlet. For reference,
 * in WEB-INF/web.xml, this would typically be done asfollows: <servlet>
 * <servlet-name>dispatcher</servlet-name> <servlet-class>
 * org.springframework.web.servlet.DispatcherServlet </servlet-class>
 * <init-param> <param-name>contextConfigLocation</param-name>
 * <param-value>/WEB-INF/spring/dispatcher-config.xml</param-value>
 * </init-param> <load-on-startup>1</load-on-startup> </servlet>
 * 
 * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
 * <url-pattern>/</url-pattern> </servlet-mapping>
 * 
 * The code-based approach with WebApplicationInitializer Here is the equivalent
 * DispatcherServlet registration logic, WebApplicationInitializer-style: public
 * class MyWebAppInitializer implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext container) {
 *           XmlWebApplicationContext appContext = new
 *           XmlWebApplicationContext();
 *           appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
 * 
 *           ServletRegistration.Dynamic dispatcher =
 *           container.addServlet("dispatcher", new
 *           DispatcherServlet(appContext)); dispatcher.setLoadOnStartup(1);
 *           dispatcher.addMapping("/"); }
 * 
 *           } As an alternative to the above, you can also extend from
 *           org.springframework.web.servlet.support.AbstractDispatcherServletInitializer.As
 *           you can see, thanks to Servlet 3.0's new ServletContext.addServlet
 *           methodwe're actually registering an instance of the
 *           DispatcherServlet, andthis means that the DispatcherServlet can now
 *           be treated like any other object-- receiving constructor injection
 *           of its application context in this case. This style is both simpler
 *           and more concise. There is no concern for dealing withinit-params,
 *           etc, just normal JavaBean-style properties and constructor
 *           arguments. Youare free to create and work with your Spring
 *           application contexts as necessary beforeinjecting them into the
 *           DispatcherServlet.
 * 
 *           Most major Spring Web components have been updated to support this
 *           style ofregistration. You'll find that DispatcherServlet,
 *           FrameworkServlet, ContextLoaderListener and DelegatingFilterProxy
 *           all now supportconstructor arguments. Even if a component (e.g.
 *           non-Spring, other third party) has notbeen specifically updated for
 *           use within WebApplicationInitializers, they stillmay be used in any
 *           case. The Servlet 3.0 ServletContext API allows for
 *           settinginit-params, context-params, etc programmatically.
 * 
 *           A 100% code-based approach to configuration In the example above,
 *           WEB-INF/web.xml was successfully replaced with code inthe form of a
 *           WebApplicationInitializer, but the actual dispatcher-config.xml
 *           Spring configuration remained XML-based. WebApplicationInitializer
 *           is a perfect fit for use with Spring's code-based @Configuration
 *           classes. See @Configuration Javadoc forcomplete details, but the
 *           following example demonstrates refactoring to use Spring's
 *           AnnotationConfigWebApplicationContext in lieu of
 *           XmlWebApplicationContext, anduser-defined @Configuration classes
 *           AppConfig and DispatcherConfig instead of Spring XML files. This
 *           example also goes a bitbeyond those above to demonstrate typical
 *           configuration of the 'root' applicationcontext and registration of
 *           the ContextLoaderListener: public class MyWebAppInitializer
 *           implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext container) { // Create the
 *           'root' Spring application context
 *           AnnotationConfigWebApplicationContext rootContext = new
 *           AnnotationConfigWebApplicationContext();
 *           rootContext.register(AppConfig.class);
 * 
 *           // Manage the lifecycle of the root application context
 *           container.addListener(new ContextLoaderListener(rootContext));
 * 
 *           // Create the dispatcher servlet's Spring application context
 *           AnnotationConfigWebApplicationContext dispatcherContext = new
 *           AnnotationConfigWebApplicationContext();
 *           dispatcherContext.register(DispatcherConfig.class);
 * 
 *           // Register and map the dispatcher servlet
 *           ServletRegistration.Dynamic dispatcher =
 *           container.addServlet("dispatcher", new
 *           DispatcherServlet(dispatcherContext));
 *           dispatcher.setLoadOnStartup(1); dispatcher.addMapping("/"); }
 * 
 *           } As an alternative to the above, you can also extend from
 *           org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer.Remember
 *           that WebApplicationInitializer implementations are
 *           detectedautomatically -- so you are free to package them within
 *           your application as yousee fit. Ordering WebApplicationInitializer
 *           execution WebApplicationInitializer implementations may optionally
 *           be annotated at theclass level with Spring's @Orderannotation or
 *           may implement Spring's Orderedinterface. If so, the initializers
 *           will be ordered prior to invocation. This providesa mechanism for
 *           users to ensure the order in which servlet container
 *           initializationoccurs. Use of this feature is expected to be rare,
 *           as typical applications will likelycentralize all container
 *           initialization within a single WebApplicationInitializer. Caveats
 * 
 *           web.xml versioning
 * 
 *           WEB-INF/web.xml and WebApplicationInitializer use are not
 *           mutuallyexclusive; for example, web.xml can register one servlet,
 *           and a WebApplicationInitializer can register another. An
 *           initializer can even modify registrations performed in web.xml
 *           through methods such as
 *           ServletContext.getServletRegistration(String). However, if
 *           WEB-INF/web.xml is present in the application, its version
 *           attributemust be set to "3.0" or greater, otherwise
 *           ServletContainerInitializerbootstrapping will be ignored by the
 *           servlet container.
 * 
 *           Mapping to '/' under Tomcat
 * 
 *           Apache Tomcat maps its internal DefaultServlet to "/", and on
 *           Tomcat versions<= 7.0.14, this servlet mapping cannot be overridden
 *           programmatically.7.0.15 fixes this issue. Overriding the "/"
 *           servlet mapping has also been testedsuccessfully under GlassFish
 *           3.1.
 * 
 *           Since:3.1Author:Chris BeamsSee
 *           Also:SpringServletContainerInitializerorg.springframework.web.context.AbstractContextLoaderInitializerorg.springframework.web.servlet.support.AbstractDispatcherServletInitializerorg.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
 **/