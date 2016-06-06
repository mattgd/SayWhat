package me.mattgd.saywhat;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SayWhatCanvas extends Canvas implements MouseListener {
	private static final long serialVersionUID = 1L;

	private WhatRectangle[] rectangles;
	private Color[] colors = { Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta, Color.pink, Color.gray, Color.black };
	//private Rectangle rect = new Rectangle(0, 0, 100, 100);
	//private int preX, preY;
	//private boolean isFirstTime = true;
	//private Rectangle area;
	//private boolean pressOut = false;

	public SayWhatCanvas() {
		int words = 5;
		
		switch (GameRunner.getDifficulty()) {
		case 1: words = 7;
			break;
		case 2: words = 10;
			break;
		default: words = 5;
		}

		rectangles = new WhatRectangle[words];

		int startX = 0;
		for (int i = 0; i < words; i++) {
			rectangles[i] = new WhatRectangle(startX, 0, 100, 100);
			startX += 125;
		}
		
		setBackground(Color.white);
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}

	public void updateLocation(MouseEvent e) {
		WhatRectangle rect = selectRectangle(e.getPoint());
		if (rect == null) return;
		
		rect.setLocation(rect.getPreX() + e.getX(), rect.getPreY() + e.getY());
		checkRectangleBounds(rect);
		repaint();
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < rectangles.length; i++) {
			WhatRectangle rect = rectangles[i];
			
			g2.setColor(i < 10 ? colors[i] : colors[colors.length - 1]);
			g2.draw(rect);
			g2.fill(rect);
		}
	}

	private boolean checkRectangleBounds(WhatRectangle rect) {
		Rectangle area = rect.getArea();
		
		if (area == null)
			return false;
		if (area.contains(rect.x, rect.y, 100, 50))
			return true;

		int newX = rect.x;
		int newY = rect.y;

		if ((rect.x + 100) > area.getWidth())
			newX = (int) area.getWidth() - 99;
		if (rect.x < 0)
			newX = -1;
		if ((rect.y + 50) > area.getHeight())
			newY = (int) area.getHeight() - 49;
		if (rect.y < 0)
			newY = -1;

		rect.setLocation(newX, newY);
		return false;
	}
	
	private WhatRectangle selectRectangle(Point p) {
		for (WhatRectangle rect : rectangles) {
			if (rect.contains(p)) return rect;
		}
		
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}