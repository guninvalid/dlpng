package src.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QuitButton extends JButton {
	
	public QuitButton(String text) {
		
		super(text);
		addActionListener(new QuitOnClick());
		
	}
	
	public QuitButton() {
		
		this("Quit");
		
	}
	
	public static class QuitOnClick implements ActionListener {
		
		@Override public void actionPerformed(ActionEvent arg0) {
			
			System.exit(0);
			
		}
		
	}
	
}