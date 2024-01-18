package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * PackageName    : com.in28minutes.learnspringframework.game
 * Author         : circle
 * Date           : 1/12/24
 * FileName       : IntelliJ IDEA
 * Name           : MarioGame
 * Description    :
 */
@Component
@Primary
public class MarioGame implements GamingConsole {

	@Override
	public void up() {
		System.out.println("Jump");
	}
	@Override
	public void down() {
		System.out.println("Go into a hole");
	}
	@Override
	public void left() {
		System.out.println("Go left");
	}
	@Override
	public void right() {
		System.out.println("Accelerate");
	}
}
