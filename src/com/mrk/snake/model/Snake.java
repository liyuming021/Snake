package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.mrk.snake.listener.SnakeListener;
import com.mrk.snake.util.Global;

public class Snake {
	private LinkedList<Point> body = new LinkedList<Point>();
	private Set<SnakeListener> listeners = new HashSet<SnakeListener>();
	public static final int UP = 1;
	public static final int DOWN = -1;
	public static final int LEFT = 2;
	public static final int RIGHT = -2;
	
	//方向
	private int oldDirection;
	private int newDirection;
	
	//是否暂停
	private boolean pause;
	//是否活着
	private boolean live = true;
	
	public Snake() {
		init();
	}
	
	private void init() {
		body.clear();
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		for(int i=0; i<4; i++) {
			body.addFirst(new Point(x++,y));
		}
		oldDirection = newDirection = RIGHT;
		pause = false;
	}
	
	/**
	 * 蛇移动
	 */
	private void move() {
		Point head = body.getFirst().getLocation();
		if(oldDirection + newDirection != 0) {
			oldDirection = newDirection;
		}
		switch(oldDirection) {
			case UP:	
				head.y--;
				if(head.y < 0) {
					head.y = Global.HEIGHT - 1;
				}
				break;
			case DOWN:	
				head.y++;
				if(head.y == Global.HEIGHT) {
					head.y = 0;
				}
				break;
			case LEFT:	
				head.x--;
				if(head.x < 0) {
					head.x = Global.WIDTH - 1;
				}
				break;
			case RIGHT:	
				head.x++;
				if(head.x == Global.WIDTH) {
					head.x = 0;
				}
				break;
		}
		body.addFirst(head);
		body.removeLast();
	}
	
	private class SnakeDirver implements Runnable {
		@Override
		public void run() {
			while(live) {
				if(!pause) {
					move();
					for(SnakeListener listener : listeners) {
						listener.snakeMoved();
					}
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void begin() {
		new Thread(new SnakeDirver()).start();
	}
	
	public void drawMe(Graphics g) {
		for(Point p : body) {
			g.setColor(Color.blue);
			g.fill3DRect(p.x * Global.CELL_HEIGHT, p.y * Global.CELL_HEIGHT, 
					Global.CELL_HEIGHT, Global.CELL_HEIGHT, true);
		}
	}
	
	public void addSnakeListener(SnakeListener listener) {
		listeners.add(listener);
	}
	
	public void changeDirection(int direction) {
		this.newDirection = direction;
	}
	
	public void changePause() {
		pause = !pause;		
	}
	
	public Point getHead() {
		return body.getFirst();
	}
	
	public void eatFood() {
		Point tail = body.getLast().getLocation();
		body.addLast(tail);
	}
	
	//让蛇死
	public void dead() {
		this.live = false;
	}
	
	public boolean isEatBody() {
		for(int i=1; i<body.size(); i++) {
			if(getHead().equals(body.get(i))) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断某点是否在蛇身上
	 * @param p
	 * @return
	 */
	public boolean isPointOnSnake(Point p) {
		for(Point point : body) {
			if(point.equals(p)) {
				return true;
			}
		}
		return false;
	}
}
