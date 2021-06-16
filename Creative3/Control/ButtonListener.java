package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import Model.Player;
import Model.Paper;
import Model.Rock;
import Model.Scissors;
import View.OneOpponentPanel;
import View.OneOpponentPanel.GameState;

public class ButtonListener implements ActionListener {

	private OneOpponentPanel panel;
	private Player uT = new Player();
	private Player cT = new Player();
	private Rock rock = new Rock("rock");
	private Paper paper = new Paper("paper");
	private Scissors scissors = new Scissors("scissors");
	private Random rand = new Random();

	public ButtonListener(OneOpponentPanel panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		JButton button = (JButton) e.getSource();
		if(button == panel.getStartButton()){
			panel.enableOptions();
			panel.setGameState(GameState.PLAYING);
			panel.disableStart();
			panel.getCanvas().repaint();
		}else if( button == panel.getRockButton()){
			panel.disableOptions();
			panel.setGameState(GameState.INTERMISSION);
			panel.enableStart();
			uT.setSign(rock);
			panel.setUser(uT);
			int x = rand.nextInt(3);
			if(x == 0){
				cT.setSign(rock);
			}else if(x == 1){
				cT.setSign(paper);
			}else{
				cT.setSign(scissors);
			}
			panel.setComputer(cT);
			if(uT.getSign().beatsOpponent(cT.getSign().getName()) & ! cT.getSign().beatsOpponent(uT.getSign().getName())){
				panel.getCanvas().incrementPlayerW();
				panel.setOutcome("Win!");
			}else if(cT.getSign().beatsOpponent(uT.getSign().getName()) & ! uT.getSign().beatsOpponent(cT.getSign().getName())){
				panel.getCanvas().incrementComputerW();
				panel.setOutcome("Loss!");
			}else{
				panel.setOutcome("Draw");
			}
			if(panel.getCanvas().getComputerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("lose");
			}if(panel.getCanvas().getPlayerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("won");
			}
			panel.getCanvas().repaint();
		}else if( button == panel.getPaperButton()){
			panel.disableOptions();
			panel.setGameState(GameState.INTERMISSION);
			panel.enableStart();
			uT.setSign(paper);
			panel.setUser(uT);
			int x = rand.nextInt(3);
			if(x == 0){
				cT.setSign(rock);
			}else if(x == 1){
				cT.setSign(paper);
			}else{
				cT.setSign(scissors);
			}
			panel.setComputer(cT);
			if(uT.getSign().beatsOpponent(cT.getSign().getName()) & ! cT.getSign().beatsOpponent(uT.getSign().getName())){
				panel.getCanvas().incrementPlayerW();
				panel.setOutcome("Win!");
			}else if(cT.getSign().beatsOpponent(uT.getSign().getName()) & ! uT.getSign().beatsOpponent(cT.getSign().getName())){
				panel.getCanvas().incrementComputerW();
				panel.setOutcome("Loss!");
			}else{
				panel.setOutcome("Draw");
			}

			if(panel.getCanvas().getComputerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("lose");
			}if(panel.getCanvas().getPlayerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("won");
			}
			panel.getCanvas().repaint();
		}else if( button == panel.getScissorsButton()){
			panel.disableOptions();
			panel.setGameState(GameState.INTERMISSION);
			panel.enableStart();
			uT.setSign(scissors);
			panel.setUser(uT);
			int x = rand.nextInt(3);
			if(x == 0){
				cT.setSign(rock);
			}else if(x == 1){
				cT.setSign(paper);
			}else{
				cT.setSign(scissors);
			}
			panel.setComputer(cT);
			if(uT.getSign().beatsOpponent(cT.getSign().getName()) & ! cT.getSign().beatsOpponent(uT.getSign().getName())){
				panel.getCanvas().incrementPlayerW();
				panel.setOutcome("Win!");
			}else if(cT.getSign().beatsOpponent(uT.getSign().getName()) & ! uT.getSign().beatsOpponent(cT.getSign().getName())){
				panel.getCanvas().incrementComputerW();
				panel.setOutcome("Loss!");
			}else{
				panel.setOutcome("Draw");
			}
			if(panel.getCanvas().getComputerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("lose");
			}if(panel.getCanvas().getPlayerW() == 3){
				panel.setGameState(GameState.GAMEOVER);
				panel.setOutcome("won");
			}
			panel.getCanvas().repaint();
		}
	}
	
}
