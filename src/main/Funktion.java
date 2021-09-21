package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Funktion {
	
	int wert = 1;
	static Oberflaeche O;
	
	public Funktion() {
		
	}
	
	public static void main (String[] args) {
		 O = new Oberflaeche();
		 System.out.println(O.path);
	}
	
	public void changeWert() {
		if(wert == 1) {
			wert = 2;
		}
		else if (wert == 2) {
			wert = 1;
		}
	}
	
	public int gibWert() {
		return wert;
	}
	
	public void checkForWin(int i) {
		if(dreiInEinerReihe(i)) {
			if(i==1) {
				JOptionPane.showMessageDialog(O.f, "The Winner is X!",
						"Congrats!", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(O.f, "The Board will reset itself now.", "Reset!",
					    JOptionPane.WARNING_MESSAGE);
				O.reset();
			}
			if(i==2) {
				JOptionPane.showMessageDialog(O.f, "The Winner is O!",
						"Congrats!", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(O.f, "The Board will reset itself now.", "Reset!",
					    JOptionPane.WARNING_MESSAGE);
				O.reset();
			}
		}
		if(alleBelegt()) {
			JOptionPane.showMessageDialog(O.f, "This is a Tie!",
					"Oh No!", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(O.f, "The Board will reset itself now.", "Reset!",
				    JOptionPane.WARNING_MESSAGE);
			O.reset();
		}
	}
	
	public boolean dreiInEinerReihe(int i) {
		for(ArrayList<Feld> Reihe : gibReihen()) {
			if(Reihe.get(0).eigenerWert == i && Reihe.get(1).eigenerWert == i && Reihe.get(2).eigenerWert == i) {
				return true;
			}
		}
		return false;
	}
	
	ArrayList<ArrayList<Feld>> gibReihen(){
		ArrayList<ArrayList<Feld>> Reihen = new ArrayList<>();
		ArrayList<Feld> eins = new ArrayList<Feld>();
        	eins.add(O.ol);
            eins.add(O.om);
            eins.add(O.or);
        ArrayList<Feld> zwei = new ArrayList<Feld>();
            zwei.add(O.ml);
            zwei.add(O.mm);
            zwei.add(O.mr);
        ArrayList<Feld> drei = new ArrayList<Feld>();
            drei.add(O.ul);
            drei.add(O.um);
            drei.add(O.ur);
        ArrayList<Feld> vier = new ArrayList<Feld>();
            vier.add(O.ol);
            vier.add(O.ml);
            vier.add(O.ul);
        ArrayList<Feld> fünf = new ArrayList<Feld>();
        	fünf.add(O.om);
        	fünf.add(O.mm);
        	fünf.add(O.um);
        ArrayList<Feld> sechs = new ArrayList<Feld>();
        	sechs.add(O.or);
        	sechs.add(O.mr);
        	sechs.add(O.ur);
        ArrayList<Feld> sieben = new ArrayList<Feld>();
        	sieben.add(O.ol);
        	sieben.add(O.mm);
        	sieben.add(O.ur);
        ArrayList<Feld> acht = new ArrayList<Feld>();
        	acht.add(O.or);
        	acht.add(O.mm);
        	acht.add(O.ul);
		Reihen.add(eins); Reihen.add(zwei); Reihen.add(drei); Reihen.add(vier); Reihen.add(fünf); Reihen.add(sechs); Reihen.add(sieben); Reihen.add(acht);
		return Reihen;
	}
	
	boolean alleBelegt() {
		for(Feld f : O.alleFelder) {
			if(f.unchanged) {
				return false;
			}
		}
		return true;
	}

}
