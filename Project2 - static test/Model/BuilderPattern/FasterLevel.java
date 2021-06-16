package Model.BuilderPattern;

import View.GameBoard;

public class FasterLevel  extends LevelBuilder{

	@Override
	public void buildSpeed() {
		GameBoard.DELAY -= 5;

	}

	@Override
	public void buildEnemyRows() {	}

	@Override
	public void buildEnemySize() {	}

	@Override
	public void buildEnemyHp() {	}
	
}
