package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.awt.Color;



public class GuessingGameCanvas extends JPanel{

	public static int WIDTH = 500;
	public static int HEIGHT = 500;

	private int healthBars;

	private GuessingGameScreen panel;

	public GuessingGameCanvas(GuessingGameScreen panel, int health){
		this.panel = panel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		healthBars = health;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		GuessingGameScreen.GameState state = panel.getGameState();
		if (state ==  GuessingGameScreen.GameState.READY){
			g2.setColor(Color.BLUE);
			g2.setFont(new Font("Courier New", Font.BOLD, 30));
			g2.drawString("Press <New> to Start", 200, 150);
		}else if(state == GuessingGameScreen.GameState.PLAYING){
			g2.setColor(Color.BLUE);
			g2.setFont(new Font("Courier New", Font.BOLD, 50));
			g2.drawString("Health Level", 50, 50);
			for (int i = 0; i < healthBars; i++){
				g2.fillRect(i * 60 + 50, 80, 50, 50);
			}
		}else{
			if( healthBars == 0){
				g2.setColor(Color.RED);
				g2.setFont(new Font("Courier New", Font.BOLD, 50));
				g2.drawString("YOU LOST !!!", 100, 150);
				g2.setColor(Color.BLUE);
				g2.drawString("Press <New> to Start", 100, 200);
			}else{
				g2.setColor(Color.RED);
				g2.setFont(new Font("Courier New", Font.BOLD, 30));
				g2.drawString("YOU WON !!!", 100, 150);
				g2.setColor(Color.BLUE);
				g2.drawString("Press <New> to Start", 100, 200);
			}
		}
	}

	public void setHealthBarsCount(int bars){
		this.healthBars = bars;
	}

	public int getHealthBarsCount(){
		return healthBars;
	}
	
}
