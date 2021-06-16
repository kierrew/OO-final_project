package Model.StrategyPattern;

import Model.Bullet;

public class BulletRightDAnimateStrategy implements BulletAnimateStrategy {

	private Bullet bullet;
	public static final int UNIT_MOVE = 10;

	public BulletRightDAnimateStrategy(Bullet bullet){
		this.bullet = bullet;
	}

	@Override
	public void animateAlgorithim() {
		bullet.x += UNIT_MOVE;
		bullet.y -= UNIT_MOVE;
		bullet.setSign(2);

	}
	
	
}
