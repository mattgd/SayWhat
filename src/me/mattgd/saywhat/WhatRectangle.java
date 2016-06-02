package me.mattgd.saywhat;

import java.awt.Rectangle;

public class WhatRectangle extends Rectangle {

	private static final long serialVersionUID = 1L;
	private int preX, preY;
	private boolean isFirstTime = true;
	private Rectangle area;
	private boolean pressOut = false;
	
	public WhatRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public int getPreX() {
		return preX;
	}
	
	public void setPreX(int preX) {
		this.preX = preX;
	}
	
	public int getPreY() {
		return preY;
	}
	
	public void setPreY(int preY) {
		this.preY = preY;
	}
	
	public boolean isFirstTime() {
		return isFirstTime;
	}
	
	public void setFirstTime(boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}
	
	public Rectangle getArea() {
		return area;
	}
	
	public void setArea(Rectangle rect) {
		this.area = rect;
	}
	
	public boolean pressOut() {
		return pressOut;
	}
	
	public void setPressOut(boolean pressOut) {
		this.pressOut = pressOut;
	}
	
}
