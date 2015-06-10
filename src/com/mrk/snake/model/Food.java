package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.mrk.snake.util.Global;

public class Food extends Point{

	private static final long serialVersionUID = 1L;
	
	//ʳ����ɫ
	private Color color = new Color(0xcc0033);
	
	public Food() {
	}
	
	public Food(Point p) {
		super(p);
	}
	/**
	 * �������巶Χ�ڲ���һ���µ㣬δ������������غ�����
	 * @return
	 */
	public Point getNew() {
		Random random = new Random();
		Point p = new Point();
		p.x = random.nextInt(Global.WIDTH);
		p.y = random.nextInt(Global.HEIGHT);
		return p;
	}
	
	/**
	 * �ж����Ƿ�Ե���ʳ�����ͷ�Ƿ���ʳ��Ϊͬһ����
	 * @param snake
	 * @return
	 */
	public boolean isSnakeEatFood(Snake snake) {
		return this.equals(snake.getHead());
	}
	
	/**
	 * ������ϻ���
	 * @param g
	 */
	public void drawMe(Graphics g) {
		g.setColor(color);
		g.fill3DRect(x * Global.CELL_WIDTH, y * Global.CELL_HEIGHT, 
				Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
	}
}
