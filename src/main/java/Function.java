package main.java;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Function {
	
	int playersState = 1;
	static UserInterface uI;
	private ArrayList<ArrayList<Field>> winningRows;
	private boolean emptyWinningRows = true;
	
	public Function() {
	}

	public static void main (String[] args) {
		 uI = new UserInterface();
	}
	
	public void checkForWin(int player) {
		if(threeInARow(player)) {
			if(player==1) {
				JOptionPane.showMessageDialog(uI.f, "The Winner is X!",
						"Congrats!", JOptionPane.PLAIN_MESSAGE);
				uI.setSpectatingMode();
			}
			if(player==2) {
				JOptionPane.showMessageDialog(uI.f, "The Winner is O!",
						"Congrats!", JOptionPane.PLAIN_MESSAGE);
				uI.setSpectatingMode();
			}
		}
		if(areAllFieldsChanged()) {
			JOptionPane.showMessageDialog(uI.f, "This is a Tie!",
					"Oh No!", JOptionPane.WARNING_MESSAGE);
			uI.setSpectatingMode();
		}
	}
	
	public void changePlayersState() {
		if(playersState == 1) {
			playersState = 2;
		}
		else if (playersState == 2) {
			playersState = 1;
		}
	}
	
	public int getPlayersState() {
		return playersState;
	}
	
	public boolean threeInARow(int i) {
		for(ArrayList<Field> winningRow : getWinningRows()) {
			if(winningRow.get(0).ownState == i && winningRow.get(1).ownState == i && winningRow.get(2).ownState == i) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<ArrayList<Field>> getWinningRows(){
		if(emptyWinningRows) {
			setWinningRows();
			emptyWinningRows = false;
		}
		return winningRows;
	}
	
	private void setWinningRows() {
		winningRows = new ArrayList<>();
		ArrayList<Field> first = new ArrayList<Field>();
        	first.add(uI.upperLeft);
            first.add(uI.upperMiddle);
            first.add(uI.upperRight);
        ArrayList<Field> second = new ArrayList<Field>();
            second.add(uI.middleLeft);
            second.add(uI.middleMiddle);
            second.add(uI.middleRight);
        ArrayList<Field> third = new ArrayList<Field>();
            third.add(uI.downLeft);
            third.add(uI.downMiddle);
            third.add(uI.downRight);
        ArrayList<Field> fourth = new ArrayList<Field>();
            fourth.add(uI.upperLeft);
            fourth.add(uI.middleLeft);
            fourth.add(uI.downLeft);
        ArrayList<Field> fifth = new ArrayList<Field>();
        	fifth.add(uI.upperMiddle);
        	fifth.add(uI.middleMiddle);
        	fifth.add(uI.downMiddle);
        ArrayList<Field> sixth = new ArrayList<Field>();
        	sixth.add(uI.upperRight);
        	sixth.add(uI.middleRight);
        	sixth.add(uI.downRight);
        ArrayList<Field> seventh = new ArrayList<Field>();
        	seventh.add(uI.upperLeft);
        	seventh.add(uI.middleMiddle);
        	seventh.add(uI.downRight);
        ArrayList<Field> eighth = new ArrayList<Field>();
        	eighth.add(uI.upperRight);
        	eighth.add(uI.middleMiddle);
        	eighth.add(uI.downLeft);
		winningRows.add(first); winningRows.add(second); winningRows.add(third); 
		winningRows.add(fourth); winningRows.add(fifth); winningRows.add(sixth); 
		winningRows.add(seventh); winningRows.add(eighth);
		
	}
	
	private boolean areAllFieldsChanged() {
		for(Field f : uI.allFields) {
			if(f.unchanged) {
				return false;
			}
		}
		return true;
	}

}
