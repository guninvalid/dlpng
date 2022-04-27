package src.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DriverWindow extends JFrame {
	
	public DriverWindow() {
		
		super("dlpng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 1600);
		JPanel content = new JPanel();
		content.add(new JLabel("<html><u style = 'font-size: 400px;'>A</u></html>"));
		content.add(new QuitButton("Quit"));
		setContentPane(content);
		setVisible(true);
		
	}
	
}