package main.java;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Field {

	public boolean unchanged = true;
	public JButton button;
	public int ownState;
	
	public Field(ImageIcon I) { 
		button = new JButton(I);
		
	}

}
