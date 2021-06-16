package Model;

import java.awt.Graphics2D;
import java.awt.Color;

public class ShooterLeftWing extends GameElement{

	public static final int SIZE = 20;

	public ShooterLeftWing(int x, int y, Color color, boolean filled){
		super(x, y, color, filled, SIZE, SIZE);
	}

	@Override
	public void render(Graphics2D g2) {
		g2.setColor(color);
		if(super.filled){
			g2.fillPolygon(new int[] {x, x + SIZE, x + SIZE}, new int[] {y, y - SIZE, y - (SIZE / 2)}, 3);
		} else{
			g2.drawPolygon(new int[] {x, x, x - SIZE}, new int[] {y + (SIZE / 2), y + SIZE, y + (SIZE / 2) + SIZE}, 3);
		}

	}

	@Override
	public void animate() {	}
	
}
