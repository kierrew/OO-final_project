package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Rectangle;


import View.ShooterGamePanel;
import View.ShooterGamePanel.GameState;

public class ShooterEventListener implements ActionListener, MouseListener{

	private ShooterGamePanel panel;

	public ShooterEventListener(ShooterGamePanel panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button == panel.getStartButton()){
			panel.setGameState(GameState.PLAYING);
			panel.getStartButton().setEnabled(false);
			panel.getVillianBox().setEnabled(false);
			panel.checkPositive();
			panel.populateImages();
			panel.setTime(20);
			panel.roundExecution();

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
			Rectangle r = panel.getTemp().GetBoundingBox();
			if (r.contains(e.getX(), e.getY())) {
				if(panel.getTemp().getPositivePoints() == true){
					panel.scoreIncrement();
					panel.setScoreDisplay();
				}else if (panel.getTemp().getPositivePoints() == false){
					panel.scoreDecrement();
					panel.setScoreDisplay();
				}
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

}
