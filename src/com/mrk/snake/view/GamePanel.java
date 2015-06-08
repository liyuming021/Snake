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
		//内容面板的大小
		this.setSize(Global.WIDTH * Global.CELL_WIDTH,
				Global.HEIGHT * Global.CELL_HEIGHT);
	}
	@Override
	public void paint(Graphics g) {
		//重绘面板本身（可考虑效率）
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_WIDTH, 
				Global.HEIGHT * Global.CELL_HEIGHT);
		//重绘蛇
		this.snake.drawMe(g);		
	}

	public void redisplay(Snake snake) {
		this.snake = snake;
		this.repaint();
	}
}
