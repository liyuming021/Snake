package com.mrk.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import com.mrk.snake.util.Global;

public class Snake {
	//������һ��㹹��
	private LinkedList<Point> body = new LinkedList<Point>();
	//�ߵĳ��ȣ�Ĭ������Ϊ4
	private int length = 4;
	//�ߵ���ɫ��Ĭ��Ϊ��ɫ
	private Color color = Color.red;
	/**
	 * �����ߣ�β����������ģ�ͷ���ұߣ�Ĭ��Ϊ4�����ӳ��ȣ���ɫ
	 */
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
		for(int i=0; i<length; i++) {
			body.addFirst(new Point(x++,y));
		}
	}
	/**
	 * �û��ʻ�����
	 * @param g ����Graphics����
	 */
	public void drawMe(Graphics g) {
		//�������ϵ�ÿһ����
		for(Point p : body) {
			//��ʲô��ɫ
			g.setColor(color);
			//��ô�����ѵ�Ϊ��׼�����»��߶ȣ����һ���ȣ��γɾ���
			g.fill3DRect(p.x * Global.CELL_WIDTH, p.y * Global.CELL_HEIGHT, 
					Global.CELL_WIDTH, Global.CELL_HEIGHT, true);
		}
	}

}
