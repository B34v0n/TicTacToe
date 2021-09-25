package main.java;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UserInterface extends Function implements ActionListener{
	
	JFrame f = new JFrame();
	JTextArea TA = new JTextArea();
	Canvas C = new Canvas();
	String path = getPath();
	final ImageIcon crossPicture = new ImageIcon(path + "Cross.png");
	final ImageIcon circlePicture = new ImageIcon(path + "Circle.png");
	final ImageIcon emptyPicture = new ImageIcon(path + "Empty.png");
	Field upperLeft = new Field(emptyPicture);
	Field upperMiddle = new Field(emptyPicture);
	Field upperRight = new Field(emptyPicture);
	Field middleLeft = new Field(emptyPicture);
	Field middleMiddle = new Field(emptyPicture);
	Field middleRight = new Field(emptyPicture);
	Field downLeft = new Field(emptyPicture);
	Field downMiddle = new Field(emptyPicture);
	Field downRight = new Field(emptyPicture);
	JButton resetButton = new JButton("reset");
	ArrayList<Field> allFields = new ArrayList<>();

	
	public UserInterface() {

		upperLeft.button.setBounds(50, 50, 100, 100);
		upperLeft.button.addActionListener(this);
		
		upperMiddle.button.setBounds(250, 50, 100, 100);
		upperMiddle.button.addActionListener(this);
		
		upperRight.button.setBounds(450, 50, 100, 100);
		upperRight.button.addActionListener(this);
		
		middleLeft.button.setBounds(50, 250, 100, 100);
		middleLeft.button.addActionListener(this);
		
		middleMiddle.button.setBounds(250, 250, 100, 100);
		middleMiddle.button.addActionListener(this);
		
		middleRight.button.setBounds(450, 250, 100, 100);
		middleRight.button.addActionListener(this);
		
		downLeft.button.setBounds(50, 450, 100, 100);
		downLeft.button.addActionListener(this);
		
		downMiddle.button.setBounds(250, 450, 100, 100);
		downMiddle.button.addActionListener(this);
		
		downRight.button.setBounds(450, 450, 100, 100);
		downRight.button.addActionListener(this);
		
		resetButton.setBounds(600,50,100,50);
		resetButton.addActionListener(this);
		
		f.add(upperLeft.button); f.add(upperMiddle.button); f.add(upperRight.button); 
		f.add(middleLeft.button); f.add(middleMiddle.button); f.add(middleRight.button); 
		f.add(downLeft.button); f.add(downMiddle.button); f.add(downRight.button);
		f.add(resetButton);

		f.setSize(800, 700);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		allFields.add(upperLeft); allFields.add(upperMiddle); allFields.add(upperRight); 
		allFields.add(middleLeft); allFields.add(middleMiddle); allFields.add(middleRight); 
		allFields.add(downLeft); allFields.add(downMiddle); allFields.add(downRight);
	}
	
	private void setplayersRound(Field F) {
		int playersState = super.getPlayersState();
		if (F.unchanged) {
			switch(playersState){
			case 1:
				F.button.setIcon(crossPicture);
				break;
			case 2:
				F.button.setIcon(circlePicture);
				break;
			}
		super.changePlayersState();
		F.unchanged = false;
		F.ownState = playersState;
		super.checkForWin(1);
		super.checkForWin(2);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.upperLeft.button) {
			setplayersRound(upperLeft);
		}
		else if (e.getSource() == this.upperMiddle.button) {
			setplayersRound(upperMiddle);
		}
		else if (e.getSource() == this.upperRight.button) {
			setplayersRound(upperRight);
		}
		else if (e.getSource() == this.middleLeft.button) {
			setplayersRound(middleLeft);
		}
		else if (e.getSource() == this.middleMiddle.button) {
			setplayersRound(middleMiddle);
		}
		else if (e.getSource() == this.middleRight.button) {
			setplayersRound(middleRight);
		}
		else if (e.getSource() == this.downLeft.button) {
			setplayersRound(downLeft);
		}
		else if (e.getSource() == this.downMiddle.button) {
			setplayersRound(downMiddle);
		}
		else if (e.getSource() == this.downRight.button) {
			setplayersRound(downRight);
		}
		else if (e.getSource() == this.resetButton) {
			reset();
		}
	}
	
	public void reset() {
		for(Field f : allFields) {
			f.button.setIcon(emptyPicture);
			f.ownState = 0;
			f.unchanged = true;
			super.playersState = 1;
		}
		setButtonsEnable(true);
	}
	
	private String getPath() {
		try{
			Path p = Paths.get(UserInterface.class.getResource("..").toURI());
			p = p.getParent();
			p = p.getParent();
			p = p.getParent();
			String picturePath = p.toString() + "\\src\\main\\resources\\pictures\\";
			return picturePath;
		} catch (Exception e) {
			System.err.print(e.toString());
			return null;
		}
	}
	
	public void setSpectatingMode() {
		setFieldsUnchanged(); 
		setButtonsEnable(false);
	}
	
	private void setButtonsEnable(boolean enable) {
		for(Field f : allFields) {
			f.button.setEnabled(enable);
		}
	}
	
	private void setFieldsUnchanged() {
		for(Field f : allFields) {
			f.unchanged = true;
		}
	}
}
