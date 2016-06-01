package me.mattgd.saywhat;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PhraseLengthOptionPane {

	public PhraseLengthOptionPane(JFrame frame) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {}

				JPanel panel = new JPanel();
				panel.add(new JLabel("Please select a difficulty:"));
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
				model.addElement("Easy (5 words)");
				model.addElement("Medium (7 words)");
				model.addElement("Hard (10 words)");
				JComboBox<String> comboBox = new JComboBox<String>(model);
				panel.add(comboBox);

				int result = JOptionPane.showConfirmDialog(null, panel, "Difficulty Selection",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.OK_OPTION) GameRunner.setDifficulty(comboBox.getSelectedIndex());
				frame.setVisible(true);
			}
		});
	}

}