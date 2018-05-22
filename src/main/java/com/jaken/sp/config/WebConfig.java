package com.jaken.sp.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.jaken.sp.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean(name="viewResolver")
	public ViewResolver getDefaultViewResolver() {
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/pages/");
		irv.setSuffix(".jsp");
		return irv;
	}
	
	@Bean(name="multipartResolver")
	public MultipartResolver getMultiPartResolver(){
		CommonsMultipartResolver cmr=new CommonsMultipartResolver();
		cmr.setMaxUploadSizePerFile(20000000);
		return cmr;
	}

	
	/**
	 * 配置静态资源访问
	 * */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler(pathPatterns)
//	}

	
	/**
	 * 配置json访问解析
	 * */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jsonconverter=new MappingJackson2HttpMessageConverter();
		converters.add(jsonconverter);
	}
	
	
}
