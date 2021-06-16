package Model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import Model.ObserverPatteren.Observer;
import Model.ObserverPatteren.Subject;
import View.GameBoard;

import java.awt.Color;

public class EnemyComposite extends GameElement implements Subject {

	public enum Event {
		BulletHitEnemy, BulletHitBomb
	}

	public static int yMax = 40;
	public static int xMax = 400;
	public static int hp = 1;
	public static int xInit = 20;
	public static int yInit = 20;
	public static int enemySize = 20;
	public static final int UNIT_MOVE = 5;

	private ArrayList<ArrayList<Enemy>> rows;
	private ArrayList<GameElement> bombs;
	private ArrayList<PowerUp> powerUps;
	private ArrayList<Observer> observers = new ArrayList<>();
	private boolean movingToRight = true;
	private Random random = new Random();

	public EnemyComposite() {
		rows = new ArrayList<>();
		bombs = new ArrayList<>();
		powerUps = new ArrayList<>();

		for (int r = yInit; r - enemySize <= yMax; r += enemySize * 2) {
			var oneRow = new ArrayList<Enemy>();
			rows.add(oneRow);
			for (int c = xInit; c - enemySize < xMax; c += enemySize * 2) {
				oneRow.add(new Enemy(c - enemySize, r - enemySize, enemySize, Color.yellow, true, hp));

			}
		}
	}

	@Override
	public void render(Graphics2D g2) {
		// render enemy array
		for (var r : rows) {
			for (var e : r) {
				e.render(g2);
			}
		}

		// render bombs
		for (var b : bombs) {
			b.render(g2);
		}

		for (var p : powerUps) {
			p.render(g2);
		}
	}

	@Override
	public void animate() {
		int dx = UNIT_MOVE;
		if (movingToRight) {
			if (rightEnd() >= GameBoard.WIDTH) {
				dx = -dx;
				for (var r : rows) {
					for (var e : r) {
						e.y += 20;
					}
				}
				movingToRight = false;
			}
		} else {
			dx = -dx;
			if (leftEnd() <= 0) {
				dx = -dx;
				for (var r : rows) {
					for (var e : r) {
						e.y += 20;
					}
				}
				movingToRight = true;
			}
		}

		// update location
		for (var row : rows) {
			for (var e : row) {
				e.x += dx;
			}
		}

		// animate bombs
		for (var b : bombs) {
			b.animate();
		}

		for (var p : powerUps) {
			p.animate();
		}
	}

	private int rightEnd() {
		int xEnd = -100;
		for (var row : rows) {
			if (row.size() == 0)
				continue;
			int x = row.get(row.size() - 1).x + enemySize;
			if (x > xEnd)
				xEnd = x;
		}
		return xEnd;
	}

	private int leftEnd() {
		int xEnd = 9000;
		for (var row : rows) {
			if (row.size() == 0)
				continue;
			int x = row.get(0).x;
			if (x < xEnd)
				xEnd = x;
		}
		return xEnd;
	}

	public void dropBombs() {
		for (var row : rows) {
			for (var e : row) {
				if (random.nextFloat() < 0.1F) {
					bombs.add(new Bomb(e.x, e.y));
				}
			}
		}
	}

	public void dropPowerUp() {
		for (var row : rows) {
			for (var e : row) {
				if (random.nextFloat() < 0.1F) {
					powerUps.add(new PowerUp(e.x, e.y));
				}
			}
		}
	}

	public void removePowerUpsOutOFBounds() {
		var remove = new ArrayList<GameElement>();
		for (var p : powerUps) {
			if (p.y > GameBoard.HEIGHT)
				remove.add(p);
		}
		powerUps.removeAll(remove);
	}

	public void removeBombsOutOFBounds() {
		var remove = new ArrayList<GameElement>();
		for (var b : bombs) {
			if (b.y > GameBoard.HEIGHT)
				remove.add(b);
		}
		bombs.removeAll(remove);
	}

	public void processCollision(Shooter shooter) {
		var removeBullets = new ArrayList<GameElement>();

		// bulletes vs enemies & power ups
		for (var row : rows) {
			var removeEnemies = new ArrayList<GameElement>();
			for (var e : row) {
				for (var bullet : shooter.getWeapons()) {
					if (e.collideWith(bullet)) {

						e.decreaseHp();
						removeBullets.add(bullet);
						notifyEnemyObservers(Event.BulletHitEnemy);
						if (e.getHp() == 0) {
							removeEnemies.add(e);
							if (random.nextFloat() < 0.1F) {
								powerUps.add(new PowerUp(e.x, e.y));
							}
						}
					}
				}
			}
			row.removeAll(removeEnemies);
		}
		shooter.getWeapons().removeAll(removeBullets);

		// bullets vs bombs
		var removeBombs = new ArrayList<GameElement>();
		removeBullets.clear();

		for (var b : bombs) {
			for (var bullet : shooter.getWeapons()) {
				if (b.collideWith(bullet)) {
					removeBombs.add(b);
					removeBullets.add(bullet);
					notifyEnemyObservers(Event.BulletHitBomb);

				}
			}
		}

		shooter.getWeapons().removeAll(removeBullets);
		bombs.removeAll(removeBombs);
	}

	public ArrayList<GameElement> getBombs() {
		return bombs;
	}

	public ArrayList<ArrayList<Enemy>> getRows() {
		return rows;
	}

	public ArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}

	public static void incrementRows() {
		yMax += 40;
	}

	public static void decreaseSize() {
		enemySize -= 2;
		xInit -= 2;
		yInit -= 2;
	}

	public void incrementHp() {
		hp++;
	}

	public int getHp() {
		return hp;
	}

	public void resetEnemies() {
		hp = 1;
		xInit = 20;
		yInit = 20;
		enemySize = 20;
		yMax = 40;

	}

	public static int getyMax() {
		return yMax;
	}

	public static int getEnemySize() {
		return enemySize;
	}

	@Override
	public void addEnemyListener(Observer o){
		observers.add(o);
	}

	@Override
	public void removeEnemyListener(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyEnemyObservers(Event event) {
		switch(event){
			case BulletHitEnemy:
				for(var o: observers)
				o.bulletHitEnemy();
				break;
			case BulletHitBomb:
				for(var o: observers)
				o.bulletHitBomb();
				break;
		}

	}

	@Override
	public void notifyShooterObservers(Shooter.Event event) {	}

	@Override
	public void addShooterListener(Observer o) {	}

	@Override
	public void removeShooterListener(Observer o) {	}

	
	
}
