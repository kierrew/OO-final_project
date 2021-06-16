package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.ButtonListener;
import Model.Player;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;


public class OneOpponentPanel {

	public enum GameState{
		READY, PLAYING, INTERMISSION, GAMEOVER
	}

	private JFrame window;
	private JButton startButton = new JButton("Start");
	private JButton rockButton = new JButton("rock");
	private JButton paperButton = new JButton("paper");
	private JButton scissorsButton = new JButton("scissors");
	private GameState gameState = GameState.READY;
	private Player user = new Player();
	private Player computer = new Player();
	private String outcome;
	private JPanel bottomPanel = new JPanel();

	
	
	private OneOpponentCanvas canvas;
	
	public OneOpponentPanel(JFrame window) {
		this.window = window;
	}

	public void init(){
		ButtonListener ButtonListener = new ButtonListener(this);
		Container cp = window.getContentPane();

		JPanel startPanel = new JPanel();
		startPanel.setLayout(new GridLayout(1, 1));

		startPanel.add(startButton);
		startButton.addActionListener(ButtonListener);

		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(1, 3));

		optionsPanel.add(rockButton);
		rockButton.setEnabled(false);
		
		
		optionsPanel.add(paperButton);
		paperButton.setEnabled(false);

		
		optionsPanel.add(scissorsButton);
		scissorsButton.setEnabled(false);

		rockButton.addActionListener(ButtonListener);
		paperButton.addActionListener(ButtonListener);
		scissorsButton.addActionListener(ButtonListener);

		bottomPanel.setLayout(new GridLayout(2,1));
		bottomPanel.setPreferredSize(new Dimension (400, 200));
		bottomPanel.add(startPanel);
		bottomPanel.add(optionsPanel);

		cp.add(BorderLayout.SOUTH, bottomPanel);

		canvas = new OneOpponentCanvas(this);
		cp.add(BorderLayout.NORTH, canvas);
	}
		
	public JButton getStartButton(){
		return startButton;
	}

	public void enableOptions(){
		rockButton.setEnabled(true);
		paperButton.setEnabled(true);
		scissorsButton.setEnabled(true);
	}

	public void disableOptions(){
		rockButton.setEnabled(false);
		paperButton.setEnabled(false);
		scissorsButton.setEnabled(false);
	}

	public void disableStart(){
		startButton.setEnabled(false);
	}

	public void enableStart(){
		startButton.setEnabled(true);
	}

	public OneOpponentCanvas getCanvas(){
		return canvas;
	}

	public GameState getGameState(){
		return gameState;
	}
	
	public void setGameState(GameState state){
		this.gameState = state;
	}

	public Player getComputer(){
		return computer;
	}

	public void setComputer(Player computer){
		this.computer = computer;
	}
	
	public Player getUser(){
		return user;
	}

	public void setUser(Player user){
		this.user = user;
	} 

	public JButton getPaperButton() {
		return paperButton;
	}
	public JButton getRockButton() {
		return rockButton;
	}
	public JButton getScissorsButton() {
		return scissorsButton;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
}
