package com.mrk.snake.game;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.mrk.snake.controller.Controllor;
import com.mrk.snake.model.Snake;
import com.mrk.snake.util.Global;
import com.mrk.snake.view.GamePanel;

public class MainFrame extends JFrame {
	public MainFrame(Controllor controller){
		//设置窗口名称
		this.setTitle("贪吃蛇游戏");
		//设置窗口的关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的大小
		this.setSize(Global.WIDTH * Global.CELL_WIDTH  + 10,
				Global.HEIGHT * Global.CELL_HEIGHT + 35);
		//设置窗口不能拉伸
		this.setResizable(false);
		//显示窗口
		this.setVisible(true);	
		
		//给窗口添加内容面板
		this.add(controller.gamePanel,BorderLayout.CENTER);	
	}
	public static void main(String[] args) {
		//创建蛇对象
		Snake snake = new Snake();
		//创建内容面板
		GamePanel gamePanel = new GamePanel();
		Controllor controller = new Controllor(snake,gamePanel);
		new MainFrame(controller);
		
		//开始游戏
		controller.newGame();
	}
}
