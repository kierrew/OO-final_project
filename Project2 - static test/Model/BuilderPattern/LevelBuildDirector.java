package Model.BuilderPattern;

public class LevelBuildDirector {

	private LevelBuilder builder;
	
	public void setBuilder(LevelBuilder builder) {
		this.builder = builder;
	}

	public Level getLevel(){
		return builder.getLevel();
	}

	public void createLevel(){
		builder.buildSpeed();
		builder.buildEnemyRows();
		builder.buildEnemySize();
		builder.buildEnemyHp();
	}
	
}
