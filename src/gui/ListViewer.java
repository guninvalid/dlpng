package src.gui;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ListViewer<E> extends JPanel {
	
	private JList<E> list;
	private JLabel info;
	
	public ListViewer(String pinfo) {
		
		setLayout(new GridLayout(1, 2));
		list = new JList<E>();
		info = new JLabel(pinfo);
		add(list);
		add(info);
		
	}
	
	public ListViewer() {
		
		this("");
		
	}
	
	public void setListData(E[] listData) {
		
		list.setListData(listData);
		
	}
	
	public void setListData(Vector<? extends E> listData) {
		
		list.setListData(listData);
		
	}
	
}