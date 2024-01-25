package com.in28minutes.learnspringframework.game;

/**
 * PackageName    : com.in28minutes.learnspringframework.game
 * Author         : circle
 * Date           : 1/14/24
 * FileName       : IntelliJ IDEA
 * Name           : SuperCotraGame
 * Description    :
 */
public class SuperContraGame implements GamingConsole{
	@Override
	public void up() {
		System.out.println("Jump");
	}
	@Override
	public void down() {
		System.out.println("Sit down");
	}
	@Override
	public void left() {
		System.out.println("Go back");
	}
	@Override
	public void right() {
		System.out.println("Shoot a bullet");
	}
}