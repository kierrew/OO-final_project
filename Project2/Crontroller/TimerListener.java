package Crontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Color;

import Model.Bullet;
import Model.EnemyComposite;
import Model.Shooter;
import Model.ShooterBody;
import Model.Shooter.Event;
import Model.StrategyPattern.BulletLeftDAnimateStrategy;
import Model.StrategyPattern.BulletRightDAnimateStrategy;
import View.GameBoard;
import View.TextDraw;

public class TimerListener implements ActionListener{

	public enum EventType {
		KEY_RIGHT, KEY_LEFT, KEY_SPACE
	}

	private GameBoard gameBoard;
	private LinkedList<EventType> eventQueue;
	private final int BOMB_DROP_FREQ = 20;
	private int  framecounter = 0;
	private Random random = new Random();

	public TimerListener(GameBoard gameBoard){
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
						if(shooter.scatBullets >0){
							if(shooter.getBounceBullets() > 0){
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
							if(shooter.scatBullets <= 0 && shooter.unlimBullets <= 0){
								shooter.setMAX_BULLETS(9);
							}
						}
						//shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));

						//unlimited bullets
						if(shooter.getUnlimBullets() > 0){
							if(shooter.scatBullets <= 0){
								if(shooter.getBounceBullets() > 0){
									shooter.decreaseBounceBullets();
								}
								shooter.getWeapons().add(new Bullet(shooter.x + (ShooterBody.SIZE / 3), shooter.y - (ShooterBody.SIZE / 2)));
							}
							shooter.decreaseUnlimBullets();
							if(shooter.getUnlimBullets() <= 0 && shooter.scatBullets <= 0){
								shooter.setMAX_BULLETS(3);
							}
							if(shooter.unlimBullets <= 0 && shooter.scatBullets > 0){
								shooter.setMAX_BULLETS(9);
							}
						}
						if(shooter.scatBullets <= 0 && shooter.unlimBullets <=0){
							if(shooter.getBounceBullets() > 0){
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
				if (e.y + enemyComposite.enemySize == gameBoard.HEIGHT){
					gameBoard.getShooter().notifyShooterObservers(Event.EnemiesReachBottom);
				}
			}
		}
	}

	private Object getEnemyComposite() {
		return null;
	}

	public LinkedList<EventType> getEventQueue() {
		return eventQueue;
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
			if(EnemyComposite.getyMax() <= 160){
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
	
}
