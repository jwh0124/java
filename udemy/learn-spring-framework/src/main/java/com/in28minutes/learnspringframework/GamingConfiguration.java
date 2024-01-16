package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PackageName    : com.in28minutes.learnspringframework
 * Author         : circle
 * Date           : 1/16/24
 * FileName       : IntelliJ IDEA
 * Name           : GamingConfiguration
 * Description    :
 */
@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game(){
		var game = new PacmanGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
