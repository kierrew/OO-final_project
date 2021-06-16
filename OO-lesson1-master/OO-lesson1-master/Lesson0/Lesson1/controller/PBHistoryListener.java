package Lesson1.controller;

import Lesson1.model.Coin;
import Lesson1.model.PiggyBank;
import Lesson1.view.PiggyBankSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PBHistoryListener implements ActionListener {

	private PiggyBankSimulator panel;

	public PBHistoryListener(PiggyBankSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Coin> history = panel.getPiggyBank().getCoinHistory();
		int index = 0;
		String exsistingMessage = panel.getDisplay().getText();
		String m = "";
		if (history.size() > 0){
			for(var coin: history){
				m += ++index + ". " +coin + "\n";
			}
			panel.getDisplay().setText(exsistingMessage + "\nCoin Insert History\n" + m);
		} else{
			panel.getDisplay().setText(exsistingMessage + "\n" + "No coin insert history");
		}

	}
	
}