package com.mrk.snake.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.mrk.snake.controller.Controllor;
import com.mrk.snake.model.Food;
import com.mrk.snake.model.Ground;
import com.mrk.snake.model.Snake;
import com.mrk.snake.util.Global;
import com.mrk.snake.view.GamePanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame(Controllor controller){		
		this.setTitle("Ì°³ÔÉßÓÎÏ·");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Global.WIDTH * Global.CELL_WIDTH  + 10,
				Global.HEIGHT * Global.CELL_HEIGHT + 35);
		this.setResizable(false);
		//Ìí¼ÓÓÎÏ·Ãæ°å
		this.add(controller.gamePanel,BorderLayout.CENTER);	
		//Ìí¼Ó°´¼ü¼àÌýÆ÷
		this.addKeyListener(controller);
	}
	
	public static void main(String[] args) {
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		Controllor controller = new Controllor(snake,ground,gamePanel,food);
		MainFrame frame = new MainFrame(controller);
		frame.setVisible(true);		
		controller.newGame();
	}
}
