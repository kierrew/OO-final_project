package View;

import Model.IRender;
import View.ShooterGamePanel.GameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;


import java.util.ArrayList;

import javax.swing.JPanel;

public class ShooterCanvas extends JPanel{

	private ShooterGamePanel panel;
	private ArrayList<IRender> pics = new ArrayList<>();

	public ShooterCanvas(ShooterGamePanel panel){
		this.panel = panel;
		setPreferredSize(new Dimension(1200, 850));
		setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		ShooterGamePanel.GameState state = panel.getGameState();
		if(state == ShooterGamePanel.GameState.READY){
			if(panel.getRound() == 1){
				g2.setColor(Color.red);
				g2.setFont(new Font("couier", Font.BOLD, 50));
				g2.drawString("Press Start to begin.", 300, 300);
			}else{
				g2.setColor(Color.red);
				g2.setFont(new Font("couier", Font.BOLD, 50));
				g2.drawString("Round " + String.valueOf(panel.getRound()) + " press Start to begin.", 300, 300);
			}
		}else if(state == ShooterGamePanel.GameState.PLAYING){
			for(int i = 0; i < pics.size(); i++){
				IRender picture  = pics.get(i);
				picture.render(g2);
			}
		}else if(state == ShooterGamePanel.GameState.INTERMISSION){
			if(panel.getScore() >= panel.getPossibleTargets() / 2){
				panel.getStartButton().setEnabled(true);
				panel.setImageSpeed(panel.getImageSpeed() * .75);
				panel.setRound(panel.getRound() + 1);
				panel.setGameState(GameState.READY);
				panel.setScore(0);
				panel.setPossibleTargets(0);				
			}else if(panel.getScore() < panel.getPossibleTargets() / 2){
				g2.setColor(Color.red);
				g2.setFont(new Font("couier", Font.BOLD, 50));
				g2.drawString("Gameover press Start to try again.", 300, 300);
				panel.getStartButton().setEnabled(true);
				panel.getVillianBox().setEnabled(true);
				panel.setRound(1);
				panel.setImageSpeed(1500);
				panel.setScore(0);
				panel.setPossibleTargets(0);
				panel.setGameState(GameState.READY);
			}
		}


	}

	public ArrayList<IRender> getPics() {
		return pics;
	}	
	
}
