package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window){
		this.window = window;
		window.setTitle("Menu Screen");

	}

	public void init(){
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 800));
		panel.setLayout(new GridLayout(1,1));

		JButton HangManButton = new JButton("Play Hangman");
		panel.add(HangManButton);
		cp.add(BorderLayout.CENTER, panel);

		HangManButton.addActionListener(e ->{
			window.getContentPane().removeAll();
			var hang = new HangManSimulator(window);
			hang.init();
			window.pack();
			window.revalidate();
		});
	}
	
}
