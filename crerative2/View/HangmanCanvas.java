package View;

import javax.swing.JPanel;

import Model.Circle;
import Model.Limbs;
import Model.Stand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HangmanCanvas extends JPanel {

	private HangManSimulator panel;
	private int pieces;

	public HangmanCanvas(HangManSimulator panel){
		this.panel = panel;
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.BLACK);

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Stand s1 = new Stand();
		s1.render(g2);

		Circle c1 = new Circle();
		c1.render(g2);

		Limbs l1 = new Limbs();
		l1.renderBody(g2);
		l1.renderLL(g2);
		l1.renderRL(g2);
		l1.renderLA(g2);
		l1.renderRA(g2);

	}
	
	
}
