package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class PowerUp extends GameElement {

	public static final int Size = 10;
	public static final double UNIT_MOVE = 2.5;
	private Random rand;
	private int power;
	private String text;

	public PowerUp(int x, int y){
		super(x, y, Color.orange, true, Size, Size);
		rand = new Random();
		power = rand.nextInt(3);
		switch(power){
			case 0:
			text = "B";
			break;
			case 1:
			text = "S";
			break;
			case 2:
			text = "U";
			break;
		}
	}

	@Override
	public void render(Graphics2D g2) {
		g2.setColor(color);
		g2.setFont(new Font("Courier", Font.BOLD, Size * 2));
		g2.drawString(text, x, y);
	}

	@Override
	public void animate() {
		super.y += UNIT_MOVE;
	}

	public String getText() {
		return text;
	}
	
}
