package com.mrk.snake.controller;

import com.mrk.snake.model.Snake;
import com.mrk.snake.view.GamePanel;

public class Controllor {

	private Snake snake;
	private GamePanel gamePanel;
	
	public Controllor(Snake snake, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.gamePanel = gamePanel;
	}
	/**
	 * ∆Ù∂Ø”Œœ∑
	 */
	public void newGame() {
		gamePanel.redisplay(snake);
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
}
