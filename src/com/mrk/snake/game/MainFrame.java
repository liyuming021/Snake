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
		//���ô�������
		this.setTitle("̰������Ϸ");
		//���ô��ڵĹر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڵĴ�С
		this.setSize(Global.WIDTH * Global.CELL_WIDTH  + 10,
				Global.HEIGHT * Global.CELL_HEIGHT + 35);
		//���ô��ڲ�������
		this.setResizable(false);
		//��ʾ����
		this.setVisible(true);	
		
		//����������������
		this.add(controller.gamePanel,BorderLayout.CENTER);	
	}
	public static void main(String[] args) {
		//�����߶���
		Snake snake = new Snake();
		//�����������
		GamePanel gamePanel = new GamePanel();
		Controllor controller = new Controllor(snake,gamePanel);
		new MainFrame(controller);
		
		//��ʼ��Ϸ
		controller.newGame();
	}
}
