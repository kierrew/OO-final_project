package Model.BuilderPattern;

import Model.EnemyComposite;
import View.GameBoard;

public class Level {

	public int speed;
	public int rowSpace;
	public int enemySize;
	public int hp;

	public void setSpeed() {
		this.speed = GameBoard.DELAY;
	}

	public void setRowSpace() {
		this.rowSpace = EnemyComposite.yMax;
	}

	public void setEnemySize() {
		this.enemySize = EnemyComposite.enemySize;
	}
	public void setHp() {
		this.hp = EnemyComposite.hp;
	}
	
}
