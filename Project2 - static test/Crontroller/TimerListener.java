package Crontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import Model.Bullet;
import Model.EnemyComposite;
import Model.Shooter;
import Model.ShooterBody;
import Model.Shooter.Event;
import Model.StrategyPattern.BulletLeftDAnimateStrategy;
import Model.StrategyPattern.BulletRightDAnimateStrategy;
import View.GameBoard;

public class TimerListener implements ActionListener{

	public enum EventType {
		KEY_RIGHT, KEY_LEFT, KEY_SPACE
	}

	private GameBoard gameBoard;
	private LinkedList<EventType> eventQueue;
	private final int BOMB_DROP_FREQ = 20;
	private int  framecounter = 0;
	public TimerListener(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
		eventQueue = new LinkedList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		++framecounter;
		update();
		processEventQueue();
		processCollision();
		endGame();
		gameBoard.getCanvas().repaint();

	}

	private void update(){
		for(var e : gameBoard.getCanvas().getGameElements())
			e.animate();

	}

	private void processEventQueue(){
		while (!eventQueue.isEmpty()){
			var e = eventQueue.getFirst();
			eventQueue.removeFirst();
			Shooter shooter = gameBoard.getShooter();
			if(shooter == null) return;

			switch (e){
				case KEY_LEFT:
					shooter.moveLeft();
					break;
				case KEY_RIGHT:
					shooter.moveRight();
					break;
				case KEY_SPACE:
					if(shooter.canFireMoreBullets()){
						
						//code for scatter shot
						if(Shooter.scatBullets > 0) {
							if(Shooter.getBounceBullets() > 0) {
								shooter.decreaseBounceBullets();
							}
							Bullet temp = new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2));
							temp.setMoveStartegy(new BulletLeftDAnimateStrategy(temp));
							shooter.getWeapons().add(temp);
							temp = new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2));
							temp.setMoveStartegy(new BulletRightDAnimateStrategy(temp));
							shooter.getWeapons().add(temp);
							shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));
							shooter.decreaseScatBullets();
							if(Shooter.scatBullets <= 0 && Shooter.unlimBullets <= 0) {
								Shooter.setMAX_BULLETS(9);
							}
						}
						//shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));

						//unlimited bullets
						if(Shooter.getUnlimBullets() > 0) {
							if(Shooter.scatBullets <= 0) {
								if(Shooter.getBounceBullets() > 0) {
									shooter.decreaseBounceBullets();
								}
								shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));
							}
							shooter.decreaseUnlimBullets();
							if(Shooter.getUnlimBullets() <= 0 && Shooter.scatBullets <= 0) {
								Shooter.setMAX_BULLETS(3);
							}
							if(Shooter.unlimBullets <= 0 && Shooter.scatBullets > 0) {
								Shooter.setMAX_BULLETS(9);
							}
						}
						if(Shooter.scatBullets <= 0 && Shooter.unlimBullets <= 0) {
							if(Shooter.getBounceBullets() > 0) {
								shooter.decreaseBounceBullets();
							}
							shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));
						}
					}
					break;
			}

		}
		if(framecounter == BOMB_DROP_FREQ){
			gameBoard.getEnemyComposite().dropBombs();
			framecounter = 0;
		}
	}

	private void processCollision(){
		var shooter = gameBoard.getShooter();
		var enemyComposite = gameBoard.getEnemyComposite();

		shooter.removeBulletsOutOFBounds();
		enemyComposite.removeBombsOutOFBounds();
		enemyComposite.removePowerUpsOutOFBounds();
		enemyComposite.processCollision(shooter);
		shooter.processCollision(enemyComposite);
	}

	private void endGame(){
		var shooter = gameBoard.getShooter();
		var enemyComposite = gameBoard.getEnemyComposite();
		boolean empty = false;
		//checking to see if all enemies are destroyed
		for(var r : enemyComposite.getRows()){
			if(r.isEmpty()) empty = true;
			else{
				empty = false;
				break;
			}
		}if(empty){
			gameBoard.getShooter().notifyShooterObservers(Event.EnemiesDefeated);
		//checking to see if the shooter is dstroyed
		}if(shooter.getComponents().isEmpty()){
			gameBoard.getShooter().notifyShooterObservers(Event.ShooterDestroyed);
		//checking to see if enemies reach bottom
		}for(var row : enemyComposite.getRows()){
			for(var e : row){
				if (e.y + EnemyComposite.enemySize == GameBoard.HEIGHT) {
					gameBoard.getShooter().notifyShooterObservers(Event.EnemiesReachBottom);
				}
			}
		}
	}

	public LinkedList<EventType> getEventQueue() {
		return eventQueue;
	}
	
}
