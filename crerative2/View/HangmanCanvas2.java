package View;

import javax.swing.JPanel;

import Model.Circle;
import Model.Limbs;
import Model.Stand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HangmanCanvas2 extends JPanel{

	private HangManSimulator panel;

	public HangmanCanvas2(HangManSimulator panel){
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

	}
	
	
}
