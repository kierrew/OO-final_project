package Model.BuilderPattern;

import Model.EnemyComposite;

public class ExtraHpLevel extends LevelBuilder{

	@Override
	public void buildEnemyHp() {
		EnemyComposite.hp++;
	}

	@Override
	public void buildSpeed() {	}

	@Override
	public void buildEnemyRows() {	}

	@Override
	public void buildEnemySize() {	}
	
}
