package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import Control.ButtonCLickListener;
import Model.HangMan;

public class HangManSimulator {
	
	private HangMan hangManGame = new HangMan();
	private JFrame window;
	JPanel drawingPanel = new JPanel();
	private JLabel[] keyWordTextFields;
	private JButton guessButton = new JButton("Guess");
	private JButton exitButton = new JButton("Exit");
	private JRadioButton[] alphabetButtons;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
	int correctLetters = 0;
	int size = hangManGame.getKeywordLength();
	private HangmanCanvas canvas;
	private HangmanCanvas2 hCanvas;
	private Container cp;


	public HangManSimulator(JFrame window){
		this.window = window;
		window.setTitle("Lets Play Hangman!!");
	}

	public void init(){
		cp = window.getContentPane();

		//sets up the panel that contains the word being guessed
		String key = hangManGame.getKeyword();
		keyWordTextFields = new JLabel[size];
		for(int i = 0; i < size; i++){
			String temp = String.valueOf(key.charAt(i));
			keyWordTextFields[i] = new JLabel(temp);
			keyWordTextFields[i].setBorder(border);
			keyWordTextFields[i].setVisible(false);
		}

		JPanel guessWordPanel = new JPanel();
		guessWordPanel.setLayout(new GridLayout(1, size));
		for(var b: keyWordTextFields){
			guessWordPanel.add(b);

		}

		alphabetButtons = new JRadioButton[26];
		alphabetButtons[0] = new JRadioButton("a");
		alphabetButtons[1] = new JRadioButton("b");
		alphabetButtons[2] = new JRadioButton("c");
		alphabetButtons[3] = new JRadioButton("d");
		alphabetButtons[4] = new JRadioButton("e");
		alphabetButtons[5] = new JRadioButton("f");
		alphabetButtons[6] = new JRadioButton("g");
		alphabetButtons[7] = new JRadioButton("h");
		alphabetButtons[8] = new JRadioButton("i");
		alphabetButtons[9] = new JRadioButton("j");
		alphabetButtons[10] = new JRadioButton("k");
		alphabetButtons[11] = new JRadioButton("l");
		alphabetButtons[12] = new JRadioButton("m");
		alphabetButtons[13] = new JRadioButton("n");
		alphabetButtons[14] = new JRadioButton("o");
		alphabetButtons[15] = new JRadioButton("p");
		alphabetButtons[16] = new JRadioButton("q");
		alphabetButtons[17] = new JRadioButton("r");
		alphabetButtons[18] = new JRadioButton("s");
		alphabetButtons[19] = new JRadioButton("t");
		alphabetButtons[20] = new JRadioButton("u");
		alphabetButtons[21] = new JRadioButton("v");
		alphabetButtons[22] = new JRadioButton("w");
		alphabetButtons[23] = new JRadioButton("x");
		alphabetButtons[24] = new JRadioButton("y");
		alphabetButtons[25] = new JRadioButton("z");

		JPanel alphabetPanel = new JPanel();
		alphabetPanel.setLayout(new GridLayout(6,5));
		ButtonGroup alphaGroup = new ButtonGroup();
		for(var b: alphabetButtons){
			alphabetPanel.add(b);
			alphaGroup.add(b);
		}
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.add(alphabetPanel);
		buttonsPanel.add(guessButton);
		buttonsPanel.add(exitButton);

		drawingPanel.setLayout(new GridLayout(1, 1));
		canvas = new HangmanCanvas(this);

		drawingPanel.add(canvas);


		cp.add(BorderLayout.NORTH, guessWordPanel);
		cp.add(BorderLayout.SOUTH, buttonsPanel);
		cp.add(BorderLayout.CENTER, drawingPanel);

		ButtonCLickListener ButtonCLickListener = new ButtonCLickListener(this);
		guessButton.addActionListener(ButtonCLickListener);
		exitButton.addActionListener(ButtonCLickListener);
		//canvas.addMouseListener(listener);
	}

	public JButton getGuessButton(){
		return guessButton;
	}

	public JButton getExitButton(){
		return exitButton;
	}

	public JRadioButton[] getAlphabetButtons(){
		return alphabetButtons;
	}

	public JLabel[] getKeywordTextFields(){
		return keyWordTextFields;
	}

	public HangMan getHangMan(){
		return hangManGame;
	}

	public JFrame getWindow(){
		return window;
	}

	public void showLetter(int i){
		keyWordTextFields[i].setVisible(true);
	}

	public void addCorrectLetters(){
		correctLetters++;
	}

	public int getCorrectLetters(){
		return correctLetters;
	}

	public int getSize(){
		return size;
	}

	public void letterDissapear(JRadioButton b){
		b.setVisible(false);
	}

	public HangmanCanvas getCanvas(){
		return canvas;
	}

	public Container getcontainer(){
		return cp;
	}

	public JPanel getDrawingPanel(){
		return drawingPanel;
	}

	public void redraw(){
		cp.remove(drawingPanel);
		drawingPanel.remove(canvas);

		if(getHangMan().getWrongGuesses() == 1){
			drawingPanel.add(hCanvas);
			cp.add(drawingPanel);/*
		}
		if(panel.getHangMan().getWrongGuesses() == 2){
			l1.renderBody(g2);
		}
		if(panel.getHangMan().getWrongGuesses() == 3){
			l1.renderLL();
		}
		if(panel.getHangMan().getWrongGuesses() == 4){
			l1.renderRL();
		}
		if(panel.getHangMan().getWrongGuesses() == 5){
			l1.renderLA();
		}
		if(panel.getHangMan().getWrongGuesses() == 6){
			l1.renderRA();*/
		}

	}

}
