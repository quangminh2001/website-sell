package com.devpro.karma.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MVCConf implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/fonts/");
		registry.addResourceHandler("/scss/**").addResourceLocations("classpath:/scss/");
	}
}
