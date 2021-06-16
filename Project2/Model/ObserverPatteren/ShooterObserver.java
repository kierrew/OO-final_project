package Model.ObserverPatteren;

import java.awt.Color;
import java.util.Random;

import Model.EnemyComposite;
import View.GameBoard;
import View.TextDraw;

public class ShooterObserver implements Observer {

	private GameBoard gameBoard;
	private Random random;

	public ShooterObserver(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	@Override
	public void shooterDestroyed() {
		gameBoard.getTimer().stop();
		gameBoard.getCanvas().getGameElements().clear();
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Game over. Your score is " + gameBoard.getScore(), 100, 100, Color.red, 30));
		gameBoard.reset();
		gameBoard.getStartButton().setEnabled(true);
		gameBoard.setRound(1);
	}

	@Override
	public void enemiesReachBottom() {
		gameBoard.getTimer().stop();
		gameBoard.getCanvas().getGameElements().clear();
		gameBoard.getCanvas().getGameElements().add(new TextDraw("Game over. Your score is " + gameBoard.getScore(), 100, 100, Color.red, 30));
		gameBoard.reset();
		gameBoard.getStartButton().setEnabled(true);
		gameBoard.setRound(1);
	}

	@Override
	public void enemiesDefeated() {
		gameBoard.getTimer().stop();
		lvlShuffle();
			//if(gameBoard.getDELAY() <= 20 && gameBoard.getEnemyComposite().getyMax() >= 140 && gameBoard.getEnemyComposite().getEnemySize() <= 6){
			//	gameBoard.getEnemyComposite().incrementHp();
			//}else{
			//	gameBoard.getTimerListener().lvlShuffle();
			//}
			gameBoard.getCanvas().getGameElements().clear();
			gameBoard.nextRound();
			gameBoard.getCanvas().getGameElements().add(new TextDraw("Your score is : " + gameBoard.getScore(), 100, 100, Color.red, 30));
			gameBoard.getCanvas().getGameElements().add(new TextDraw("Level " + gameBoard.getRound(), 100, 140, Color.red, 30));
			gameBoard.getCanvas().getGameElements().add(new TextDraw(" Press start to begin.", 100, 180, Color.red, 30));
			gameBoard.getStartButton().setEnabled(true);
	}

	public void lvlShuffle(){
		random = new Random();
		int diff = random.nextInt(4);
		System.out.println(diff);
		switch(diff){
			case 0:
			if(gameBoard.getDELAY() >20){
				gameBoard.increaseSpeed();
			}else{
				lvlShuffle();
			}
			break;
			case 1:
			if(EnemyComposite.getyMax() <= 140){
				gameBoard.getEnemyComposite().incrementRows();
			}else{
				lvlShuffle();
			}
			break;
			case 2:
			if(EnemyComposite.getEnemySize() > 6){
			gameBoard.getEnemyComposite().decreaseSize();
			}else{
				lvlShuffle();
			}
			break;
			case 3:
			gameBoard.getEnemyComposite().incrementHp();
			break;
			}
	}

	@Override
	public void bulletHitEnemy() {	}

	@Override
	public void bulletHitBomb() {	}
	
}
