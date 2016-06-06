package me.mattgd.saywhat;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;
	
	public Frame() {
		setTitle("Say What");
		setSize(WIDTH, HEIGHT);
		setLocation(10, 200);

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// Setup JPanel
		JPanel panel = new Panel();
		panel.setLayout(null);
		TextField k = new TextField("1", 3);
		k.setBounds(200, 50, 10, 10);
		Button a = new Button("HI");
		panel.add(k);
		panel.add(a);
		
		contentPane.add(panel);
		//contentPane.add(new SayWhatCanvas());
		
		new PhraseLengthOptionPane(this);
	}

}