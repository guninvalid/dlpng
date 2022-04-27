package src.gui;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.dlpng.Image;

public class ComparatorWindow extends JFrame {
	
	private GridLayout layout;
	
	public ComparatorWindow() {
		
		super("Comparator");
		setSize(1200, 1200);
		layout = new GridLayout(3, 2);
		setLayout(layout);
		add(new JPanel());
		add(new JLabel("Comparator"));
		add(new JPanel());
		add(new JLabel("Comparator"));
		add(new EntryPanel());
		add(new QuitButton());
		setVisible(true);
		
	}
	
	public void display(List<Image> list, int i) {
		
		
		
	}
	
	public void display(Image image, int i) {
		
		
		
	}
	
}