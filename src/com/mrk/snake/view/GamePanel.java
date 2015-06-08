package com.mrk.snake.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import com.mrk.snake.model.Snake;
import com.mrk.snake.util.Global;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Snake snake;
	public GamePanel() {
		//�������Ĵ�С
		this.setSize(Global.WIDTH * Global.CELL_WIDTH,
				Global.HEIGHT * Global.CELL_HEIGHT);
	}
	@Override
	public void paint(Graphics g) {
		//�ػ���屾���ɿ���Ч�ʣ�
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_WIDTH, 
				Global.HEIGHT * Global.CELL_HEIGHT);
		//�ػ���
		this.snake.drawMe(g);		
	}

	public void redisplay(Snake snake) {
		this.snake = snake;
		this.repaint();
	}
}
