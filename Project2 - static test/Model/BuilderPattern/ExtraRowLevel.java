package Model.BuilderPattern;

import Model.EnemyComposite;

public class ExtraRowLevel extends LevelBuilder{

	@Override
	public void buildEnemyRows() {
		EnemyComposite.yMax += 40;
	}

	@Override
	public void buildSpeed() {	}

	@Override
	public void buildEnemySize() {	}

	@Override
	public void buildEnemyHp() {	}
	
}
