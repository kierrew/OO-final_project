package Model.StrategyPattern;

import Model.Bullet;

public class BulletBounceStrategy implements BulletAnimateStrategy {

	private Bullet bullet;
	public static final int UNIT_MOVE = 10;

	public BulletBounceStrategy (Bullet bullet){
		this.bullet = bullet;
	}

	@Override
	public void animateAlgorithim() {
		bullet.y += UNIT_MOVE;

	}
	
}
