package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * PackageName    : com.in28minutes.learnspringframework
 * Author         : circle
 * Date           : 1/12/24
 * FileName       : IntelliJ IDEA
 * Name           : AppGamingBasicJava
 * Description    :
 */
@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

	public static void main(String[] args) {
		try(var context =
				    new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}
}
