package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class StartScreen {

	private JFrame window;
	private JButton sideButton = new JButton("Choose side");

	public StartScreen(JFrame window){
		this.window = window;

	}

	public void init(){
		Container cp = window.getContentPane();

		JLabel startText = new JLabel("<html> Ready to start? Checking the Villan<br/> Mode box will allow you to play as the bad guy.<br/>just remember don't shoot your hostages!!<br/> also targets will always give you points.");
		startText.setFont(new Font("courier", Font.BOLD, 20));
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(500, 250));
		infoPanel.add(startText);

		cp.add(BorderLayout.CENTER, infoPanel);

		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(500, 100));
		southPanel.setLayout(new GridLayout(1, 2));

		southPanel.add(sideButton);

		cp.add(BorderLayout.SOUTH, southPanel);

		sideButton.addActionListener(event ->{
			window .getContentPane().removeAll();
			var menu = new ShooterGamePanel(window);
			menu.init();

			window.pack();
			window.revalidate();
		});
	}	
}
