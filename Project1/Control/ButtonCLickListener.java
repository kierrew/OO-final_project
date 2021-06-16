package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.GuessingGame;
import View.GuessingGameScreen;
import View.GuessingGameScreen.GameState;

public class ButtonCLickListener implements ActionListener {

	private GuessingGameScreen panel;
	int correct = 0;
	int wrong = 5;

	public ButtonCLickListener(GuessingGameScreen panel) {
			this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button == panel.getNewButton()){
			var guess = new GuessingGame();
			panel.setGuessingGame(guess);
			panel.setGameState(GameState.PLAYING);
			panel.getCanvas().setHealthBarsCount(5);
			panel.getCanvas().setHealthBarsCount(5);
			correct = 0;
			wrong = 5;
			panel.setHealthBarsCount(5);
			panel.resetDots();
			panel.setDebugField();
			panel.setGuessfield();
			panel.setAlphabetButtons();
			panel.getCanvas().repaint();			
		}
		else{
			button.setEnabled(false);
			int health = panel.getHealthBarsCount();
			int found = 0;
			String letterGuess = button.getText();
			String answer = panel.getWord();
			for (int i = 0; i < answer.length(); i++) {
				char letterKey = answer.charAt(i);
				String letKey = String.valueOf(letterKey);
				if(letterGuess.equals(letKey)){
					found++;
					correct++;
					panel.revealLetter(i, letterKey);
					panel.setGameState(GameState.PLAYING);
					panel.getCanvas().repaint();
					if(correct == answer.length()){
						panel.disableAlphabetButtons();
						panel.setGameState(GameState.GAMEOVER);
						panel.getCanvas().repaint();			
					}			

				}
			}
				if(found == 0){
					health--;
					wrong--;
					panel.setHealthBarsCount(health);	
					panel.getCanvas().setHealthBarsCount(health);
					panel.getCanvas().repaint();
					if(wrong == 0){
						panel.disableAlphabetButtons();
						panel.setGameState(GameState.GAMEOVER);
						panel.getCanvas().repaint();
					}
				}
										
		}
	}
}
