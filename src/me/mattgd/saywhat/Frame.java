package me.mattgd.saywhat;

import java.awt.Container;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Frame() {
		setTitle("Say What");
		setSize(600, 600);
		setLocation(10, 200);
		
		Container contentPane = getContentPane();
		contentPane.add(new Panel()); 
		contentPane.add(new DragCircle());
	}
	
	public static void main(String[] args) {
		JFrame f = new Frame();
	    f.setVisible(true);
	}
	
}