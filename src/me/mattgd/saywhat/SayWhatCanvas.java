package me.mattgd.saywhat;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SayWhatCanvas extends Canvas implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Rectangle rect = new Rectangle(0, 0, 100, 50);
	private int preX, preY;
	private boolean isFirstTime = true;
	private Rectangle area;
	private boolean pressOut = false;

	public SayWhatCanvas() {
		setBackground(Color.white);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		preX = rect.x - e.getX();
		preY = rect.y - e.getY();

		if (rect.contains(e.getX(), e.getY())) {
			updateLocation(e);
		} else {
			pressOut = true;
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!pressOut)
			updateLocation(e);
	}

	public void mouseReleased(MouseEvent e) {
		if (rect.contains(e.getX(), e.getY())) {
			updateLocation(e);
		} else {
			pressOut = false;
		}
	}

	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}

	public void updateLocation(MouseEvent e) {
		rect.setLocation(preX + e.getX(), preY + e.getY());
		checkRectangleBounds();
		repaint();
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension dim = getSize();
		int w = (int) dim.getWidth();
		int h = (int) dim.getHeight();

		if (isFirstTime) {
			area = new Rectangle(dim);
			rect.setLocation(w / 2 - 50, h / 2 - 25);
			isFirstTime = false;
		}

		// Clears the rectangle that was previously drawn.
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, w, h);

		g2.setColor(Color.red);
		g2.draw(rect);
		g2.fill(rect);
	}

	private boolean checkRectangleBounds() {
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

}