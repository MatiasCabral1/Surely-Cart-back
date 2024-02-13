/**
 * 
 */
package com.surely.surely.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dozer Configuration
 */
@Configuration
public class DozerConfig {
	   @Bean
	    DozerBeanMapper dozerBeanMapper() {
	        DozerBeanMapper mapper = new DozerBeanMapper();	
	        return mapper;
	    }
}
