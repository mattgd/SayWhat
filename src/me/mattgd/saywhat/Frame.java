package me.mattgd.saywhat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;

	private JTextArea textArea;
	public static JTextField textField;
	private JButton submitButton;

	public Frame() {
		setTitle("Say What");
		setSize(WIDTH, HEIGHT);
		setLocation(10, 200);

		Container contentPane = getContentPane();
		//contentPane.setLayout(new FlowLayout());

		// Setup JPanel
		JPanel panel = new Panel();
		panel.setLayout(null);
		
		//k.setBounds(200, 50, 10, 10);
		//Button a = new Button("HI");

		textArea = new JTextArea();
		textArea.setBounds(10, 30, WIDTH - 36, HEIGHT - 120);
		textArea.setEditable(false);
		panel.add(textArea);
		
		PrintStream con = new PrintStream(new TextAreaOutputStream(textArea));
		System.setOut(con);
		System.setErr(con);
		
		textField = new JTextField("", 10);
		textField.setBounds(10, HEIGHT - 80, WIDTH - 100, 30);
	    TextFieldStreamer ts = new TextFieldStreamer(textField);
	    textField.addActionListener(ts);
	    panel.add(textField);
	    System.setIn(ts);
		
		submitButton = new JButton(">");
		submitButton.setBounds(WIDTH - 85, HEIGHT - 80, 59, 30);
		panel.add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	GameRunner.parseInput(textField.getText());
		    	textField.setText("");
		    }
		});

		contentPane.add(panel);
	}

}