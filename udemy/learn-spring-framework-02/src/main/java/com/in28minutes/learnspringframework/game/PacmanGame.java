package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

/**
 * PackageName    : com.in28minutes.learnspringframework.game
 * Author         : circle
 * Date           : 1/14/24
 * FileName       : IntelliJ IDEA
 * Name           : Pacman
 * Description    :
 */
@Component
public class PacmanGame implements GamingConsole{
	@Override
	public void up() {
		System.out.println("up");
	}

	@Override
	public void down() {
		System.out.println("down");
	}

	@Override
	public void left() {
		System.out.println("left");
	}

	@Override
	public void right() {
		System.out.println("right");
	}
}
