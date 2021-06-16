package Model;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Model.ObserverPatteren.Observer;
import Model.ObserverPatteren.Subject;
import Model.StrategyPattern.BulletAnimateStrategy;
import Model.StrategyPattern.BulletBounceLeftDStrategy;
import Model.StrategyPattern.BulletBounceRightDStrategy;
import Model.StrategyPattern.BulletBounceStrategy;
import Model.StrategyPattern.BulletLeftDAnimateStrategy;
import Model.StrategyPattern.BulletRightDAnimateStrategy;
import View.GameBoard;

import java.awt.Color;

public class Shooter extends GameElement implements Subject {

	public static final int UNIT_MOVE = 10;
	public static int MAX_BULLETS = 3;
	public static int unlimBullets = 0;
	public static int scatBullets = 0;
	public static int bounceBullets = 0;

	public enum Event{
		ShooterDestroyed, EnemiesReachBottom, EnemiesDefeated
	}

	private ArrayList<GameElement> components = new ArrayList<>();
	private ArrayList<Bullet> weapons = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();


	public Shooter(int x, int y) {
		super(x, y, 0, 0);

		var size = ShooterBody.SIZE;
		var s1 = new ShooterBody(x, y, Color.white, true);
		var s2 = new ShooterNose(x + (size / 2), y - (size / 2), Color.white, true);
		var s3 = new ShooterLeftWing(x - size, y + size + (size / 2), Color.white, true);
		var s4 = new ShooterRightWing(x + size + size, y + size + (size / 2), Color.white, true);
		components.add(s1);
		components.add(s2);
		components.add(s3);
		components.add(s4);
	}

	public void moveRight() {
		int maxX = 0;
		for (var c : components) {
			if (c.x > maxX) {
				maxX = c.x;
			}
		}
		if (maxX < GameBoard.WIDTH) {
			super.x += UNIT_MOVE;
			for (var c : components) {
				c.x += UNIT_MOVE;
			}
		}
	}

	public void moveLeft() {
		int minX = 2000;
		for (var c : components) {
			if (c.x < minX) {
				minX = c.x;
			}
		}
		if (minX > 0) {
			super.x -= UNIT_MOVE;
			for (var c : components) {
				c.x -= UNIT_MOVE;
			}
		}
	}

	public boolean canFireMoreBullets() {
		return weapons.size() < MAX_BULLETS;
	}

	public void removeBulletsOutOFBounds() {
		var remove = new ArrayList<GameElement>();
		for (var w : weapons) {
			if(bounceBullets >0){
				//handles bounces off the top of screen
				if(w.y == 0){
					if(w.getSign() == 1){
						w.setMoveStartegy(new BulletBounceLeftDStrategy(w));
					}else if(w.getSign() == 2){
						w.setMoveStartegy(new BulletBounceRightDStrategy(w));
					}else 
					w.setMoveStartegy(new BulletBounceStrategy(w));
				}
				if(w.y > GameBoard.HEIGHT){
					remove.add(w);
				}
			}
			else if (w.y < 0 || w.x < 0 || w.x > GameBoard.WIDTH)
				remove.add(w);
		}
		weapons.removeAll(remove);
	}

	@Override
	public void render(Graphics2D g2) {
		for (var c : components) {
			c.render(g2);
		}

		for (var w : weapons) {
			w.render(g2);
		}
	}

	public ArrayList<Bullet> getWeapons() {
		return weapons;
	}

	@Override
	public void animate() {
		for (var w : weapons) {
			w.animate();
		}
	}

	public void processCollision(EnemyComposite enemy) {
		var removeBombs = new ArrayList<GameElement>();
		var removeShooterParts = new ArrayList<GameElement>();

		// shooter vs bombs
		for (var p : components) {
			for (var b : enemy.getBombs()) {
				if (p.collideWith(b)) {
					if (p == components.get(0)) {
						removeBombs.add(b);
						removeShooterParts.add(components.get(components.size() - 1));
					} else {
						removeBombs.add(b);
						removeShooterParts.add(p);
					}
				}
			}
		}
		enemy.getBombs().removeAll(removeBombs);
		components.removeAll(removeShooterParts);

		// remove power ups
		var removePowerUps = new ArrayList<GameElement>();

		for (var s : components) {
			for (var p : enemy.getPowerUps()) {
				if (s.collideWith(p)) {
					removePowerUps.add(p);
					if(p.getText().equals("U")){
						MAX_BULLETS = 100;
						unlimBullets = 40;
					}if(p.getText().equals("S")){
						if(MAX_BULLETS == 3){
							MAX_BULLETS = 9;
						}
						scatBullets = 15;
					}if(p.getText().equals("B")){
						bounceBullets = 15;
					}

				}
			}
		}
		enemy.getPowerUps().removeAll(removePowerUps);
	}

	public ArrayList<GameElement> getComponents() {
		return components;
	}

	public void decreaseUnlimBullets(){
		unlimBullets--;
	}

	public void decreaseScatBullets(){
		scatBullets--;
	}

	public void decreaseBounceBullets(){
		bounceBullets--;
	}

	public static int getUnlimBullets() {
		return unlimBullets;
	}

	public static int getBounceBullets() {
		return bounceBullets;
	}

	public static int getScatBullets() {
		return scatBullets;
	}

	public static void setMAX_BULLETS(int mAX_BULLETS) {
		MAX_BULLETS = mAX_BULLETS;
	}

	@Override
	public void addShooterListener(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeShooterListener(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyShooterObservers(Event event) {
		switch(event){
			case ShooterDestroyed:
				for(var o: observers)
				o.shooterDestroyed();
				break;
			case EnemiesDefeated:
				for(var o: observers)
				o.enemiesDefeated();
				break;
			case EnemiesReachBottom:
				for(var o: observers)
				o.enemiesReachBottom();
				break;
		}
	}

	@Override
	public void removeEnemyListener(Observer o) {	}

	@Override
	public void notifyEnemyObservers(Model.EnemyComposite.Event event) {	}

	@Override
	public void addEnemyListener(Observer o) {	}

	
}
