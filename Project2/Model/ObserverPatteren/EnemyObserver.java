package Model.ObserverPatteren;

import java.util.ArrayList;
import java.util.Random;

import Model.EnemyComposite;
import Model.GameElement;
import Model.PowerUp;
import Model.Shooter;
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
