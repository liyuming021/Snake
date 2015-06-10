package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.mrk.snake.util.Global;

public class Food extends Point{
	//食物颜色
	private Color[] colors = {Color.red,Color.blue,Color.pink,
							  Color.green,Color.orange,Color.black};
	private Color color = new Color(0xcc0033);
	//随机数
	private Random random = new Random();
	
	public Food() {
	}
	public Food(Point p) {
		super(p);
	}
	/**
	 * 随机在面板范围内产生一个新点，未考虑与蛇身的重合问题
	 * @return
	 */
	public Point getNew() {
		Point p = new Point();
		p.x = random.nextInt(Global.WIDTH);
		p.y = random.nextInt(Global.HEIGHT);
		
		return p;
	}
	/**
	 * 判断蛇是否吃到了食物，即蛇头是否与食物为同一个点
	 * @param snake
	 * @return
	 */
	public boolean isSnakeEatFood(Snake snake) {
		return this.equals(snake.getHead());
	}

	/**
	 * 在面板上画蛇
	 * @param g
	 */
	public synchronized void drawMe(Graphics g) {
		g.setColor(color);
		g.fill3DRect(x * Global.CELL_WIDTH, y * Global.CELL_HEIGHT, 
				Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
	}
	//改变食物颜色
	public void changeColor() {		
		color = colors[random.nextInt(colors.length)];
	}
}
