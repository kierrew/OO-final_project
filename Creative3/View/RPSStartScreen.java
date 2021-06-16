package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RPSStartScreen {


	private JFrame window;
	//private RPSGameCanvas canvas;
	JButton oneOpponentButton = new JButton("play Rock, Paper, Scissors");

	public RPSStartScreen(JFrame window){
		this.window = window;
		window.setTitle("Lets Play Rock, Paper, Scissors!");

	}

	public void init(){
		Container cp = window.getContentPane();
		cp.setPreferredSize(new Dimension(800, 800));

		JLabel startText = new JLabel("<html>Click the play button to start the game.<br/>Clicking the start button will allow you to select your hand sign.<br/>To win you have to beat the computer three times before the computer beats you three times.<br/>Good luch and have fun!</html>");
		JPanel questionPanel= new JPanel();
		questionPanel.setPreferredSize(new Dimension(400, 600));
		questionPanel.add(startText);

		cp.add(BorderLayout.NORTH, questionPanel);

		JPanel GameModePanel = new JPanel();
		GameModePanel.setLayout(new GridLayout(1, 2));
		GameModePanel.setPreferredSize(new Dimension(400, 200));
		GameModePanel.add(oneOpponentButton);

		cp.add(BorderLayout.SOUTH, GameModePanel);

		oneOpponentButton.addActionListener(event -> {
			window.getContentPane().removeAll();
			var panel = new OneOpponentPanel(window);
			panel.init();
			window.pack();
			window.revalidate();
		});

		
	}


	
}
