package com.arya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.arya.dao.SneakerDAO;
import com.arya.dao.GetSneakers;

@Configuration
@EnableWebMvc
@ComponentScan
public class Config implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	ds.setUrl("jdbc:mysql://localhost:3306/images");
    	ds.setUsername("root");
    	ds.setPassword("//");
    	
    	return ds;
    	
    }
    
    @Bean
    public SneakerDAO getSneakerDao() {
    	return new SneakerDAO(getDataSource());
    }
}