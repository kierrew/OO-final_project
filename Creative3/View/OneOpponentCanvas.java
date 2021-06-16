package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class OneOpponentCanvas extends JPanel {

	private int playerW = 0;
	private int computerW = 0;

	public OneOpponentPanel panel;
	
	public OneOpponentCanvas(OneOpponentPanel panel){
		this.panel = panel;
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		OneOpponentPanel.GameState state = panel.getGameState();
		if (state ==  OneOpponentPanel.GameState.READY){
		g2.setColor(Color.red);
		g2.setFont(new Font("couier", Font.BOLD, 50));
		g2.drawString("Ready?", 300, 300);
		}else if(state == OneOpponentPanel.GameState.PLAYING){
			g2.setColor(Color.red);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
			g2.drawString("ROCK", 200, 150);
			g2.drawString("PAPER", 200, 250);
			g2.drawString("SCISSORS", 200, 350);
			g2.drawString("SHOOT!!", 200, 450);
		}else if(state == OneOpponentPanel.GameState.INTERMISSION){
			g2.setColor(Color.red);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			g2.drawString("Player's Wins:", 20, 30);
			int x = playerW;
			for (int i = 0; i < 3; i++){
				if(x > 0){
					g2.fillOval(i * 20 + 60, 40, 10, 10);
				}else{
					g2.drawOval(i * 20 + 60, 40, 10, 10);
				}
				x--;
			}
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			g2.drawString("Computer's Wins:", 400, 30);
			x = computerW;
			for (int i = 0; i < 3; i++){
				if(x > 0){
					g2.fillOval(i * 20 + 450, 40, 10, 10);
				}else{
					g2.drawOval(i * 20 + 450, 40, 10, 10);
				}
				x--;
			}
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
			g2.drawString(panel.getUser().getSign().getName(), 100, 300);
			g2.drawString(panel.getComputer().getSign().getName(), 500, 300);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			g2.drawString(panel.getOutcome(), 300, 500);
		}else if(state == OneOpponentPanel.GameState.GAMEOVER){
			g2.setColor(Color.red);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			g2.drawString("Player's Wins:", 20, 30);
			int x = playerW;
			for (int i = 0; i < 3; i++){
				if(x > 0){
					g2.fillOval(i * 20 + 60, 40, 10, 10);
				}else{
					g2.drawOval(i * 20 + 60, 40, 10, 10);
				}
				x--;
			}
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			g2.drawString("Computer's Wins:", 400, 30);
			x = computerW;
			for (int i = 0; i < 3; i++){
				if(x > 0){
					g2.fillOval(i * 20 + 450, 40, 10, 10);
				}else{
					g2.drawOval(i * 20 + 450, 40, 10, 10);
				}
				x--;
			}
			g2.setColor(Color.red);
			g2.setFont(new Font("couier", Font.BOLD, 50));
			g2.drawString("You " + panel.getOutcome() + " play again?", 150, 300);
			playerW = 0;
			computerW = 0;
		}
	}
	
	public int getPlayerW() {
		return playerW;
	}
	
	public void incrementPlayerW(){
		playerW++;
	}

	public void incrementComputerW(){
		computerW++;
	}

	public int getComputerW() {
		return computerW;
	}

	public void setComputerW(int computerW) {
		this.computerW = computerW;
	}

	public void setPlayerW(int playerW) {
		this.playerW = playerW;
	}
}
