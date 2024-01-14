package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * PackageName    : com.in28minutes.learnspringframework
 * Author         : circle
 * Date           : 1/12/24
 * FileName       : IntelliJ IDEA
 * Name           : AppGamingBasicJava
 * Description    :
 */
public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// 1: Launch a Spring Context
		var context =
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		// 2: Configure the things that we want Spring to manage - @Configuration
		// HelloWorldConfiguration - @Configuration
		// name - @Bean

		// 3: Retrieving Beans managed by spring
		System.out.println(context.getBean("name"));
	}
}
