package Model;

import java.awt.Color;
import java.awt.Graphics2D;

import Model.StrategyPattern.BulletAnimateStrategy;
import Model.StrategyPattern.BulletVertAnimateStrategy;

public class Bullet extends GameElement {

	public static final int WIDTH = 5;
	private int  sign = 0;

	private BulletAnimateStrategy moveStrategy;

	public Bullet(int x, int y){
		super(x, y, Color.red, true, WIDTH, WIDTH * 3);
		this.moveStrategy = new BulletVertAnimateStrategy(this);
	}


	@Override
	public void render(Graphics2D g2) {
		g2.setColor(color);
		if(filled)
			g2.fillRect(x, y, width, height);
		else
		g2.drawRect(x, y, width, height);
	}

	@Override
	public void animate() {
		this.moveStrategy.animateAlgorithim();
	}

	public void setMoveStartegy(BulletAnimateStrategy moveStrategy){
		this.moveStrategy = moveStrategy;

	}

	public BulletAnimateStrategy getMoveStrategy() {
		return moveStrategy;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getSign() {
		return sign;
	}
	
}
