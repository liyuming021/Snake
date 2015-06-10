package com.mrk.snake.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mrk.snake.listener.SnakeListener;
import com.mrk.snake.model.Food;
import com.mrk.snake.model.Ground;
import com.mrk.snake.model.Snake;
import com.mrk.snake.view.GamePanel;
/**
 * ���ʳ���������ʱ������������
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
				//�س���ո���ͣ/�ָ�
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
		//�߳Ե�ʳ��
		if(food.isSnakeEatFood(snake)) {
			snake.eatFood();
			food.setLocation(ground == null ? food.getNew() : ground.getFreePoint(snake));
			food.changeColor();
		//�߳Ե��ϰ���
		}else if(ground.isSnakeEatRock(snake)) {
			gamePanel.redisplay(snake,food,ground);
			stopGame();
		//�߳Ե��Լ�����
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
