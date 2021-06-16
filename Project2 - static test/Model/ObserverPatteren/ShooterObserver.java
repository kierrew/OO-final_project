package Model.ObserverPatteren;

import java.awt.Color;
import java.util.Random;

import Model.EnemyComposite;
import Model.Shooter;
import Model.BuilderPattern.BaseLevel;
import Model.BuilderPattern.ExtraHpLevel;
import Model.BuilderPattern.ExtraRowLevel;
import Model.BuilderPattern.FasterLevel;
import Model.BuilderPattern.Level;
import Model.BuilderPattern.LevelBuildDirector;
import Model.BuilderPattern.LevelBuilder;
import Model.BuilderPattern.SmallerEnemiesLevel;
import View.GameBoard;
import View.TextDraw;

public class ShooterObserver implements Observer {

	private GameBoard gameBoard;
	private Random random;
	private LevelBuildDirector director;
	private LevelBuilder builder;
	private Level level;

	public ShooterObserver(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	@Override
	public void shooterDestroyed() {
		gameBoard.getTimer().stop();
		gameBoard.getCanvas().getGameElements().clear();
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Game over. Your score is " + GameBoard.getScore(),
				100, 100, Color.red, 30));
		gameBoard.reset();
		gameBoard.getStartButton().setEnabled(true);
		gameBoard.setRound(1);
		Shooter.bounceBullets = 0;
		Shooter.scatBullets = 0;
		Shooter.unlimBullets = 0;
	}

	@Override
	public void enemiesReachBottom() {
		gameBoard.getTimer().stop();
		gameBoard.getCanvas().getGameElements().clear();
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Game over. Your score is " + GameBoard.getScore(),
				100, 100, Color.red, 30));
		gameBoard.reset();
		gameBoard.getStartButton().setEnabled(true);
		gameBoard.setRound(1);
		Shooter.bounceBullets = 0;
		Shooter.scatBullets = 0;
		Shooter.unlimBullets = 0;
	}

	@Override
	public void enemiesDefeated() {
		gameBoard.getTimer().stop();
		lvlShuffle();
		gameBoard.getCanvas().getGameElements().clear();
		gameBoard.nextRound();
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Your score is : " + GameBoard.getScore(), 100,
				100, Color.red, 30));
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Level " + gameBoard.getRound(), 100, 140, Color.red, 30));
		gameBoard.getCanvas().getGameElements().add(new TextDraw(" Press next to begin.", 100, 180, Color.red, 30));
		gameBoard.getNextButton().setEnabled(true);
	}

	public void lvlShuffle(){
		director = new LevelBuildDirector();
		builder = new BaseLevel(); 
		director.setBuilder(builder);
		director.createLevel();
		level = director.getLevel();
		random = new Random();
		int diff = random.nextInt(4);
		System.out.println(diff);
		switch(diff){
			case 0:
			if(gameBoard.getDELAY() >20){
				builder = new FasterLevel();
				director.setBuilder(builder);
				director.createLevel();
				level = director.getLevel();
			}else{
				lvlShuffle();
			}
			break;
			case 1:
			if(EnemyComposite.getyMax() <= 140){
				builder = new ExtraRowLevel();
				director.setBuilder(builder);
				director.createLevel();
				level = director.getLevel();
			}else{
				lvlShuffle();
			}
			break;
			case 2:
			if(EnemyComposite.getEnemySize() > 6){
				builder = new SmallerEnemiesLevel();
				director.setBuilder(builder);
				director.createLevel();
				level = director.getLevel();
			}else{
				lvlShuffle();
			}
			break;
			case 3:
			builder = new ExtraHpLevel();
				director.setBuilder(builder);
				director.createLevel();
				level = director.getLevel();
			break;
			}
	}

	public Level getLevel() {
		return level;
	}

	@Override
	public void bulletHitEnemy() {	}

	@Override
	public void bulletHitBomb() {	}
	
}
