package me.mattgd.saywhat;

import java.awt.Container;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;

	private JTextArea textArea;
	private JTextField textField;
	private JScrollPane scrollPane;

	public Frame() {
		setTitle("Say What");
		setSize(WIDTH, HEIGHT);
		setLocation(10, 200);

		Container contentPane = getContentPane();

		// Setup JPanel
		JPanel panel = new Panel();
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 30, WIDTH - 36, HEIGHT - 120);
		textArea.setEditable(false);
		panel.add(textArea);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 30, WIDTH - 36, HEIGHT - 120);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		PrintStream con = new PrintStream(new TextAreaOutputStream(textArea));
		System.setOut(con);
		System.setErr(con);
		
		textField = new JTextField("", 10);
		textField.setBounds(10, HEIGHT - 80, WIDTH - 37, 30);
	    TextFieldStreamer ts = new TextFieldStreamer(textField);
	    textField.addActionListener(ts);
	    panel.add(textField);
	    System.setIn(ts);

		contentPane.add(panel);
	}

}