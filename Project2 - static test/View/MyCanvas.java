package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.GameElement;

public class MyCanvas extends JPanel{

	private GameBoard gameBoard;
	private ArrayList<GameElement> gameElements = new ArrayList<>();

	public MyCanvas(GameBoard gameboard, int width, int height){
		this.gameBoard = gameboard;
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for(var e : gameElements) {
			e.render(g2);
		}
	}

	public ArrayList<GameElement> getGameElements() {
		return gameElements;
	}
	
}
