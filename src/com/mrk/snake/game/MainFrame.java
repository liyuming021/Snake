package com.mrk.snake.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import com.mrk.snake.controller.Controllor;
import com.mrk.snake.model.Snake;
import com.mrk.snake.util.Global;
import com.mrk.snake.view.GamePanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame(Controllor controller){
		//���ô�������
		this.setTitle("̰������Ϸ");
		//���ô��ڵ�Ĭ�Ϲرղ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڵĴ�С������Ϸ����Դ�
		this.setSize(Global.WIDTH * Global.CELL_WIDTH  + 10,
				Global.HEIGHT * Global.CELL_HEIGHT + 35);
		//���ô��ڲ�������
		this.setResizable(false);
		//��ʾ����
		this.setVisible(true);	
		
		//����������������
		this.add(controller.getGamePanel(),BorderLayout.CENTER);	
	}
	
	public static void main(String[] args) {
		//�����߶���
		Snake snake = new Snake();
		//������Ϸ���
		GamePanel gamePanel = new GamePanel();
		Controllor controller = new Controllor(snake,gamePanel);
		new MainFrame(controller);
		
		//��ʼ��Ϸ
		controller.newGame();
	}
}
