package com.alchemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sunny_Ghosh
 *
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.alchemy")
class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper om = new ObjectMapper();
		// Ignore null/empty objects (null/empty objects will not presented in
		// the JSON String)
		om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		// Ignore all Class properties (setters, getters, methods and
		// fields)
		// from Serialisation and Deserialization
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
		// include all fields in Serialisation and Deserialization
		om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		return om;
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter(objectMapper());
	}

}