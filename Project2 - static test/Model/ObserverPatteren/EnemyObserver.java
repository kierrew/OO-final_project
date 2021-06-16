package Model.ObserverPatteren;

import View.GameBoard;

public class EnemyObserver implements Observer {

	private GameBoard gameBoard;

	public EnemyObserver(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	@Override
	public void bulletHitEnemy() {
		GameBoard.incrementScore();
	}

	@Override
	public void bulletHitBomb(){
		GameBoard.incrementScore();
	}

	@Override
	public void shooterDestroyed() {	}

	@Override
	public void enemiesReachBottom() {	}

	@Override
	public void enemiesDefeated() {	}
	
}
