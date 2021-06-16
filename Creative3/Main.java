import javax.swing.JFrame;

import View.RPSStartScreen;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(400, 100);
		window.setTitle("Rock, Paper, Scissors.");

		var menu = new RPSStartScreen(window);
		menu.init();

		window.pack();;
		window.setVisible(true);
	}
	
}