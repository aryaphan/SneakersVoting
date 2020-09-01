package com.arya.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.arya.servlet.ContinueVoting;

public class WebAppInitializer implements WebApplicationInitializer {
	 
	@Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx
          = new AnnotationConfigWebApplicationContext();
        ctx.register(Config.class);
        ctx.setServletContext(container);
 
//        ServletRegistration.Dynamic servlet = container.addServlet(
//          "dispatcher", new DispatcherServlet(ctx));
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/");
        
        ServletRegistration.Dynamic servlet = container.addServlet("ContinueVoting", ContinueVoting.class);
        servlet.setLoadOnStartup(2);
        servlet.addMapping("/ContinueVoting");
     }
}