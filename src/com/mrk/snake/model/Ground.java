package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import com.mrk.snake.util.Global;

public class Ground {
	//有哪些障碍
	private boolean[][] rocks = new boolean[Global.WIDTH][Global.HEIGHT];
	//背景颜色
	private Color color = new Color(0x666666);
	//新的食物点，排除石头，目前还没有排除蛇的身体
	private Point freePoint = new Point();
	//随机数
	private Random random = new Random();
	
	public Ground() {
		init();
	}
	//清除现有障碍
	public void clear() {
		for(int i=0; i<Global.WIDTH; i++)
			for(int j=0; j<Global.HEIGHT; j++)
				rocks[i][j] = false;
	}
	//初始化
	public void init() {
		clear();
		generateRocks_map1();
	}
	//默认障碍
	private void generateRocks_map1() {
		for(int i=0; i<Global.WIDTH; i++)
			rocks[i][0] = rocks[i][Global.HEIGHT-1] = true;
		for(int j=0; j<Global.HEIGHT; j++)
			rocks[0][j] = rocks[Global.WIDTH-1][j] = true;
	}
	//判断蛇是否吃到石头
	public boolean isSnakeEatRock(Snake snake) {
		return rocks[snake.getHead().x][snake.getHead().y];
	}
	/**
	 * 返回有效的食物的位置，有两个要求：不能在障碍物上，不能在蛇自己身上
	 * version4.1 增加参数snake,增加while第二个条件
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
