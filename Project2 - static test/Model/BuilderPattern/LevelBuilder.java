package Model.BuilderPattern;

public abstract class LevelBuilder {

	protected Level level;

	public Level getLevel() {
		return level;
	}

	public void createBomb(){
		level = new Level();
	}

	public abstract void buildSpeed();
	public abstract void buildEnemyRows();
	public abstract void buildEnemySize();
	public abstract void buildEnemyHp();
	
}
