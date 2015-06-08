package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import com.mrk.snake.util.Global;

public class Snake {
	//蛇身，由一组点构成
	private LinkedList<Point> body = new LinkedList<Point>();
	//蛇的长度，默认设置为4
	private int length = 4;
	//蛇的颜色，默认为红色
	private Color color = Color.red;
	/**
	 * 构造蛇，尾巴在面板中心，头在右边，默认为4个格子长度，红色
	 */
	public Snake() {
		init();
	}
	private void init() {
		//先清除所有点
		body.clear();
		//从面板中间开始
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		//四个点长度，头在右边
		for(int i=0; i<length; i++) {
			body.addFirst(new Point(x++,y));
		}
	}
	/**
	 * 用画笔绘制蛇
	 * @param g 接受Graphics对象
	 */
	public void drawMe(Graphics g) {
		//蛇身体上的每一个点
		for(Point p : body) {
			//画什么颜色
			g.setColor(color);
			//怎么画，已点为基准，往下画高度，往右画宽度，形成矩形
			g.fill3DRect(p.x * Global.CELL_WIDTH, p.y * Global.CELL_HEIGHT, 
					Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
		}
	}

}
