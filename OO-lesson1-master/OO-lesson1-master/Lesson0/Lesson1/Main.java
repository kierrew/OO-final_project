package Lesson1;

import javax.swing.JFrame;

import Lesson1.view.MenuScreen;

public class Main {

	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(400, 100);

		// add contents in body of the windows
		var menu = new MenuScreen(window);
		menu.init();

		window.pack();
		window.setVisible(true);

	}
}