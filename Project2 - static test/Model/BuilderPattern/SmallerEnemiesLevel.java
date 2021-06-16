package Model.BuilderPattern;

import Model.EnemyComposite;

public class SmallerEnemiesLevel extends LevelBuilder{

	@Override
	public void buildEnemySize() {
		EnemyComposite.enemySize -= 2;
	}

	@Override
	public void buildSpeed() {	}

	@Override
	public void buildEnemyRows() {	}

	@Override
	public void buildEnemyHp() {	}
	
}
