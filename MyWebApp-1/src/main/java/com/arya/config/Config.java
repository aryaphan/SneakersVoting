package com.arya.config;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.arya.dao.SneakerDAO;
import com.arya.servlet.ContinueVoting;
import com.arya.dao.GetSneakers;

@Configuration
@EnableWebMvc
@ComponentScan
@ServletComponentScan(basePackages="com.arya.servlet")
public class Config implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//          .addResourceLocations("/resources/").setCachePeriod(3600)
//          .resourceChain(true).addResolver(new PathResourceResolver());
//    }
    @Bean	
    public ServletRegistrationBean<HttpServlet> votingServlet() {
 	   ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
 	   servRegBean.setServlet(new ContinueVoting());
 	   servRegBean.addUrlMappings("/ContinueVoting");
 	   servRegBean.setLoadOnStartup(1);
 	   return servRegBean;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/pages/");
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Bean
//    public DriverManagerDataSource getDataSource() {
//    	DriverManagerDataSource ds = new DriverManagerDataSource();
//    	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    	ds.setUrl("jdbc:mysql://localhost:3306/ebdb");
//    	ds.setUsername("/");
//    	ds.setPassword("/");
//
//    	return ds;
//
//    }
    
    @Bean
//    public SneakerDAO getSneakerDao() {
//    	return new SneakerDAO(getDataSource());
//    }
    public SneakerDAO getSneakerDao() {
        return new SneakerDAO();
    }
}