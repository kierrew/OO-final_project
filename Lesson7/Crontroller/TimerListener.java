package Crontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Model.Bullet;
import Model.Shooter;
import View.GameBoard;

public class TimerListener implements ActionListener{

	public enum EventType {
		KEY_RIGHT, KEY_LEFT, KEY_SPACE
	}

	private GameBoard gameBoard;
	private LinkedList<EventType> eventQueue;
	private final int BOMB_DROP_FREQ = 20;
	private int  framecounter = 0;

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
					if(shooter.canFireMoreBullets())
						shooter.getWeapons().add(new Bullet(shooter.x, shooter.y));
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
		enemyComposite.processCollision(shooter);
		shooter.processCollision(enemyComposite);

	}

	public LinkedList<EventType> getEventQueue() {
		return eventQueue;
	}
	
}
