package Control;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

import View.HangManSimulator;
import View.HangmanCanvas;
import View.MenuScreen;

public class ButtonCLickListener implements ActionListener, MouseListener {

	private HangManSimulator panel;
	private HangmanCanvas canvas;
	private int clicks;

	public ButtonCLickListener(HangManSimulator panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();
		if (button == panel.getGuessButton()) {
			int place = 0;
			int found = 0;
			for (var b : panel.getAlphabetButtons()) {
				if (b.isSelected()) {
					String letterGuess = b.getText();
					for (var x : panel.getKeywordTextFields()) {
						String letterKey = x.getText();
						if (letterGuess.equals(letterKey)) {
							panel.showLetter(place);
							place++;
							found++;
							panel.addCorrectLetters();
							panel.letterDissapear(b);
						} else {
							place++;
						}
					}
					panel.letterDissapear(b);
				}
			}
			if (panel.getCorrectLetters() == panel.getSize()) {
				JOptionPane.showMessageDialog(null, "Congratulations you've won!!", "WINNER",
						JOptionPane.INFORMATION_MESSAGE);
				JFrame window = panel.getWindow();
				window.getContentPane().removeAll();
				var menu = new MenuScreen(window);
				menu.init();
				window.pack();
				window.revalidate();
			}
			if (found == 0) {
				panel.getHangMan().addToWrongGuesses();
			}
			int wrong = panel.getHangMan().getWrongGuesses();
			if (wrong == 6) {
				JOptionPane.showMessageDialog(null, "You have run out of guesses please try again!", "GAME OVER",
						JOptionPane.INFORMATION_MESSAGE);
				JFrame window = panel.getWindow();
				window.getContentPane().removeAll();
				var menu = new MenuScreen(window);
				menu.init();
				window.pack();
				window.revalidate();
			}
		} else if (button == panel.getExitButton()) {
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.init();
			window.pack();
			window.revalidate();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*clicks++;
		switch (clicks)
			case 1:
				canvas = new HangmanCanvas(panel);
		*/		
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}
