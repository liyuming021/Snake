package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.mrk.snake.util.Global;

public class Ground {
	//����Щ�ϰ�
	private boolean[][] rocks = new boolean[Global.WIDTH][Global.HEIGHT];
	//������ɫ
	private Color color = new Color(0x666666);
	//�µ�ʳ��㣬�ų�ʯͷ��Ŀǰ��û���ų��ߵ�����
	private Point freePoint = new Point();
	//�����
	private Random random = new Random();
	
	public Ground() {
		init();
	}
	//��������ϰ�
	public void clear() {
		for(int i=0; i<Global.WIDTH; i++)
			for(int j=0; j<Global.HEIGHT; j++)
				rocks[i][j] = false;
	}
	//��ʼ��
	public void init() {
		clear();
		generateRocks_map1();
	}
	//Ĭ���ϰ�
	private void generateRocks_map1() {
		for(int i=0; i<Global.WIDTH; i++)
			rocks[i][0] = rocks[i][Global.HEIGHT-1] = true;
		for(int j=0; j<Global.HEIGHT; j++)
			rocks[0][j] = rocks[Global.WIDTH-1][j] = true;
	}
	//�ж����Ƿ�Ե�ʯͷ
	public boolean isSnakeEatRock(Snake snake) {
		return rocks[snake.getHead().x][snake.getHead().y];
	}
	/**
	 * ������Ч��ʳ���λ�ã�������Ҫ�󣺲������ϰ����ϣ����������Լ�����
	 * version4.1 ���Ӳ���snake,����while�ڶ�������
	 * @return
	 */
	public Point getFreePoint(Snake snake) {
		do {
			freePoint.x = random.nextInt(Global.WIDTH);
			freePoint.y = random.nextInt(Global.HEIGHT);
		}while(rocks[freePoint.x][freePoint.y] || snake.isPointOnSnake(freePoint));
		return freePoint;
	}
	
	public void drawMe(Graphics g) {
		for(int i=0; i<Global.WIDTH; i++)
			for(int j=0; j<Global.HEIGHT; j++) {
				if(rocks[i][j]) {
					g.setColor(color);
					g.fill3DRect(i * Global.CELL_WIDTH, j * Global.CELL_HEIGHT, 
							Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
				}
			}
	}
}
