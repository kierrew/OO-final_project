package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.ButtonCLickListener;
import Model.GuessingGame;


public class GuessingGameScreen {

	public enum GameState{
		READY, PLAYING, GAMEOVER
	}

	private JFrame window;
	private GuessingGameCanvas canvas;
	JButton newGame = new JButton("New");
	private JTextField debugField;
	private GuessingGame sampleGame;
	JTextField guessedField;
	String keyReveal;
	String key;
	private int healthBars = 5;
	public ArrayList<JButton> alphabet;
	private GameState gameState = GameState.READY;


	public GuessingGameScreen(JFrame window){
		this.window = window;
		window.setTitle("Project1: Word Guess Game");

	}

	public void init(){
		ButtonCLickListener ButtonCLickListener = new ButtonCLickListener(this);
		Container cp = window.getContentPane();
		cp.setPreferredSize(new Dimension(800, 800));
		sampleGame = new GuessingGame();
		char letter = 'a';

		//this section will set up the two fields that hold the answer
		key = sampleGame.getKeyword();
		debugField = new JTextField("");
		int keyLength = key.length();
		keyReveal = "";
		for(int i = 0; i < keyLength; i++){
			keyReveal += ".";
		}
		guessedField = new JTextField("");
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(2, 1));
		answerPanel.add(debugField);
		answerPanel.add(guessedField);
		cp.add(BorderLayout.NORTH, answerPanel);

		//this section will set up the buttons
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 7));
		alphabet = new ArrayList<>();
		for(int i = 0; i < 26; i++){
			alphabet.add(new JButton(String.valueOf(letter)));
			letter++;
			alphabet.get(i).setEnabled(false);
			alphabet.get(i).addActionListener(ButtonCLickListener);
			buttons.add(alphabet.get(i));
		}
		buttons.add(newGame);
		cp.add(BorderLayout.SOUTH, buttons);

		canvas = new GuessingGameCanvas(this, healthBars);
		cp.add(BorderLayout.CENTER, canvas);

		newGame.addActionListener(ButtonCLickListener);

	}

	public JButton getNewButton(){
		return newGame;
	}

	public ArrayList<JButton> getAlphaButtons(){
		return alphabet;
	}

	public String getDebugText(){
		return debugField.getText();
	}

	public void setDebugField(){
		debugField.setText(sampleGame.getKeyword());
		debugField.setEditable(false);
	}

	public void setGuessfield(){
		guessedField.setText(keyReveal);
		guessedField.setEditable(false);
	}

	public void setAlphabetButtons(){
		for (JButton jButton : alphabet) {
			jButton.setEnabled(true);
		}
	}

	public void disableAlphabetButtons(){
		for (JButton jButton : alphabet) {
			jButton.setEnabled(false);
		}
	}

	public String getWord(){
		return debugField.getText();
	}
	public void revealLetter(int i, char l){
		char[] temp = keyReveal.toCharArray();
		temp[i] = l;
		keyReveal = String.valueOf(temp);
		guessedField.setEditable(true);
		guessedField.setText(keyReveal);
		guessedField.setEditable(false);
	}

	public GuessingGame getGame(){
		return sampleGame;
	}

	public void setKeyReveal(String x){
		keyReveal = x;
	}

	public GameState getGameState(){
		return gameState;
	}
	
	public void setGameState(GameState state){
		this.gameState = state;
	}

	public GuessingGame getGuessingGame(){
		return sampleGame;
	}

	public void setGuessingGame(GuessingGame game){
		this.sampleGame = game;
	}

	public GuessingGameCanvas getCanvas(){
		return canvas;
	}

	public void setHealthBarsCount(int bars){
		this.healthBars = bars;
	}

	public int getHealthBarsCount(){
		return healthBars;
	}

	public void resetDots(){
		key = sampleGame.getKeyword();
		int keyLength = key.length();
		keyReveal = "";
		for(int i = 0; i < keyLength; i++){
			keyReveal += ".";
		}
	}
}
