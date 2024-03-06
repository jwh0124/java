package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * PackageName    : com.in28minutes.learnspringframework
 * Author         : circle
 * Date           : 1/12/24
 * FileName       : IntelliJ IDEA
 * Name           : AppGamingBasicJava
 * Description    :
 */
@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {
		try(var context =
				    new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(BusinessCalculationService.class).fineMax());
		}
	}
}
