package main;

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

public class Oberflaeche extends Funktion implements ActionListener{
	

	JFrame f = new JFrame();
	JTextArea TA = new JTextArea();
	Canvas C = new Canvas();
	String path = getPath();
	final ImageIcon KreuzBild = new ImageIcon(path + "Kreuz.png");
	final ImageIcon KreisBild = new ImageIcon(path + "Kreis.png");
	final ImageIcon LeerBild = new ImageIcon(path + "Leer.png");
	Feld ol = new Feld(LeerBild);
	Feld om = new Feld(LeerBild);
	Feld or = new Feld(LeerBild);
	Feld ml = new Feld(LeerBild);
	Feld mm = new Feld(LeerBild);
	Feld mr = new Feld(LeerBild);
	Feld ul = new Feld(LeerBild);
	Feld um = new Feld(LeerBild);
	Feld ur = new Feld(LeerBild);
	JButton neu = new JButton("reset");
	ArrayList<Feld> alleFelder = new ArrayList<>();

	
	public Oberflaeche() {

		ol.button.setBounds(50, 50, 100, 100);
		ol.button.addActionListener(this);
		
		om.button.setBounds(250, 50, 100, 100);
		om.button.addActionListener(this);
		
		or.button.setBounds(450, 50, 100, 100);
		or.button.addActionListener(this);
		
		ml.button.setBounds(50, 250, 100, 100);
		ml.button.addActionListener(this);
		
		mm.button.setBounds(250, 250, 100, 100);
		mm.button.addActionListener(this);
		
		mr.button.setBounds(450, 250, 100, 100);
		mr.button.addActionListener(this);
		
		ul.button.setBounds(50, 450, 100, 100);
		ul.button.addActionListener(this);
		
		um.button.setBounds(250, 450, 100, 100);
		um.button.addActionListener(this);
		
		ur.button.setBounds(450, 450, 100, 100);
		ur.button.addActionListener(this);
		
		neu.setBounds(600,50,100,50);
		neu.addActionListener(this);
		
		f.add(ol.button); f.add(om.button); f.add(or.button); f.add(ml.button); f.add(mm.button); f.add(mr.button); f.add(ul.button); f.add(um.button); f.add(ur.button);
		f.add(neu);

		f.setSize(800, 700);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		alleFelder.add(ol); alleFelder.add(om); alleFelder.add(or); alleFelder.add(ml); alleFelder.add(mm); alleFelder.add(mr); alleFelder.add(ul); alleFelder.add(um); alleFelder.add(ur);
	}
	
	private void setWert(Feld F) {
		int wert = super.gibWert();
		if (F.unchanged) {
			switch(wert){
			case 1:
				F.button.setIcon(KreuzBild);
				break;
			case 2:
				F.button.setIcon(KreisBild);
				break;
			case 0:
				F.button.setIcon(LeerBild);
				break;
			}
		super.changeWert();
		F.unchanged = false;
		F.eigenerWert = wert;
		super.checkForWin(1);
		super.checkForWin(2);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ol.button) {
			setWert(ol);
		}
		else if (e.getSource() == this.om.button) {
			setWert(om);
		}
		else if (e.getSource() == this.or.button) {
			setWert(or);
		}
		else if (e.getSource() == this.ml.button) {
			setWert(ml);
		}
		else if (e.getSource() == this.mm.button) {
			setWert(mm);
		}
		else if (e.getSource() == this.mr.button) {
			setWert(mr);
		}
		else if (e.getSource() == this.ul.button) {
			setWert(ul);
		}
		else if (e.getSource() == this.um.button) {
			setWert(um);
		}
		else if (e.getSource() == this.ur.button) {
			setWert(ur);
		}
		else if (e.getSource() == this.neu) {
			reset();
		}
	}
	
	public void reset() {
		for(Feld f : alleFelder) {
			f.button.setIcon(LeerBild);
			f.eigenerWert = 0;
			f.unchanged = true;
			super.wert = 1;
		}
	}
	
	String getPath() {
		try{
			Path p = Paths.get(Oberflaeche.class.getResource("..").toURI());
			p = p.getParent();
			p = p.getParent();
			String picturePath = p.toString() + "\\src\\Bilder\\";
			return picturePath;
		} catch (Exception e) {
			System.err.print(e.toString());
			return null;
		}
			
		
	}
}
