import javax.swing.JFrame;

import View.GuessingGameScreen;

public class Main {
	
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(400, 100);

		// add contents in body of the windows
		var menu = new GuessingGameScreen(window);
		menu.init();

		window.pack();
		window.setVisible(true);

	}
}
