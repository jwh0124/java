package com.in28minutes.learnspringframework.game;

/**
 * PackageName    : com.in28minutes.learnspringframework.game
 * Author         : circle
 * Date           : 1/12/24
 * FileName       : IntelliJ IDEA
 * Name           : GameRunner
 * Description    :
 */
public class GameRunner {
	private GamingConsole game;

	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
