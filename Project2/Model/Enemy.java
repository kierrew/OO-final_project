package Model;

import java.awt.Graphics2D;

import java.awt.Color;

public class Enemy extends GameElement {

	private int hp;

	public Enemy(int x, int y, int size, Color color, boolean filled, int hp){
		super(x, y, color, filled, size, size);
		this.hp = hp;
	}

	@Override
	public void render(Graphics2D g2) {
		g2.setColor(color);
		if (filled)
			g2.fillRect(x, y, width, height);
		else
		g2.drawRect(x, y, width, height);
	}

	@Override
	public void animate() {
		// composite group of enemies

	}

	public void decreaseHp(){
		hp--;
	}

	public int getHp() {
		return hp;
	}



}
