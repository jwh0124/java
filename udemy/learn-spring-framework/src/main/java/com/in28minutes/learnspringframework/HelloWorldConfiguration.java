package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PackageName    : com.in28minutes.learnspringframework
 * Author         : circle
 * Date           : 1/14/24
 * FileName       : IntelliJ IDEA
 * Name           : HelloWorldConfiguration
 * Description    :
 */
@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name(){
		return "Ranga";
	}
}
