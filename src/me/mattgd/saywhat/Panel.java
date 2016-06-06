package me.mattgd.saywhat;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel() {}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Font f = new Font("SansSerif", Font.BOLD, 14);
		FontMetrics fm = g.getFontMetrics(f);

		int cx = Frame.WIDTH / 2;
		int cy = 20;

		g.setFont(f);
		g.drawString("Say What!", cx, cy);

		cx += fm.stringWidth("Say What!");
	}

}
