package main;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Feld {

	public boolean unchanged = true;
	public JButton button;
	public int eigenerWert;
	
	public Feld(ImageIcon I) { 
		button = new JButton(I);
		
	}

}
