package com.mrk.snake.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mrk.snake.model.Food;
import com.mrk.snake.model.Ground;
import com.mrk.snake.model.Snake;
import com.mrk.snake.util.Global;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public GamePanel() {
		this.setSize(Global.WIDTH * Global.CELL_WIDTH,
				Global.HEIGHT * Global.CELL_HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		//�ػ���屾���ɿ���Ч�ʣ�
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_WIDTH, 
				Global.HEIGHT * Global.CELL_HEIGHT);
		//�ػ��ϰ���
		if(ground != null)
			this.ground.drawMe(g);
		//�ػ�ʳ��
		if(food != null)
			this.food.drawMe(g);
		//�ػ���
		if(snake != null)
			this.snake.drawMe(g);
		
				
	}

	public void redisplay(Snake snake,Food food,Ground ground) {
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.repaint();
	}
}
