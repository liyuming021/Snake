package com.mrk.snake.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mrk.snake.listener.SnakeListener;
import com.mrk.snake.model.Food;
import com.mrk.snake.model.Ground;
import com.mrk.snake.model.Snake;
import com.mrk.snake.view.GamePanel;
/**
 * 解决食物随机产生时在蛇身上问题
 * @author Administrator
 *
 */
public class Controllor extends KeyAdapter implements SnakeListener{

	public Snake snake;	
	public Food food;
	public Ground ground;	
	public GamePanel gamePanel;
	public Controllor(Snake snake, Ground ground,GamePanel gamePanel,Food food) {
		super();
		this.snake = snake;
		this.gamePanel = gamePanel;
		this.food = food;
		this.ground = ground;
		food.setLocation(ground.getFreePoint(snake));
		this.snake.addSnakeListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				snake.changeDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.changeDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snake.changeDirection(Snake.RIGHT);
				break;
				//回车或空格，暂停/恢复
			case KeyEvent.VK_ENTER:
			case KeyEvent.VK_SPACE:	
				snake.changePause();
				break;
		}
	}
	public void newGame() {
		gamePanel.redisplay(snake,food,ground);
		snake.begin();
	}
	
	@Override
	public void snakeMoved() {
		//蛇吃到食物
		if(food.isSnakeEatFood(snake)) {
			snake.eatFood();
			food.setLocation(ground == null ? food.getNew() : ground.getFreePoint(snake));
			food.changeColor();
		//蛇吃到障碍物
		}else if(ground.isSnakeEatRock(snake)) {
			gamePanel.redisplay(snake,food,ground);
			stopGame();
		//蛇吃到自己身体
		}else if(snake.isEatBody()) {		
			stopGame();
		}
		if(gamePanel != null) {
			gamePanel.redisplay(snake,food,ground);
		}
	}
	
	public void stopGame() {
		snake.dead();
	}
}
