package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import com.mrk.snake.util.Global;

public class Snake {
	//������һ��㹹��
	private LinkedList<Point> body = new LinkedList<Point>();

	public Snake() {
		init();
	}
	private void init() {
		//��������е�
		body.clear();
		//������м俪ʼ
		int x = Global.WIDTH/2;
		int y = Global.HEIGHT/2;
		//�ĸ��㳤�ȣ�ͷ���ұ�
		for(int i=0; i<4; i++) {
			body.addFirst(new Point(x++,y));
		}
	}
	/**
	 * �û��ʻ�����
	 * @param g ����Graphics����
	 */
	public void drawMe(Graphics g) {
		//ÿһ�������ϵĵ�
		for(Point p : body) {
			//��ʲô��ɫ
			g.setColor(Color.red);
			//��ô�����ѵ�Ϊ��׼�����»��߶ȣ����һ���ȣ��γɾ���
			g.fill3DRect(p.x * Global.CELL_WIDTH, p.y * Global.CELL_HEIGHT, 
					Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
		}
	}

}
