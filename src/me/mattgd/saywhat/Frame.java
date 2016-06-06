package me.mattgd.saywhat;

import java.awt.Container;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public Frame() {
		setTitle("Say What");
		setSize(1024, 768);
		setLocation(10, 200);

		Container contentPane = getContentPane();
		contentPane.add(new Panel());
		contentPane.add(new SayWhatCanvas());
		
		new PhraseLengthOptionPane(this);
	}

}