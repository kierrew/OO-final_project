package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Crontroller.KeyController;
import Crontroller.TimerListener;
import Model.EnemyComposite;
import Model.Shooter;
import Model.ShooterBody;
import Model.ObserverPatteren.EnemyObserver;
import Model.ObserverPatteren.ShooterObserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

public class GameBoard {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;
	
	private static int FPS = 20;
	public static int DELAY = 1000 / FPS;

	private JFrame window;
	private JButton startButton = new JButton("Start");
	private JButton nextButton = new JButton("Next");
	private JButton pauseButton = new JButton("Pause");
	private MyCanvas canvas;
	private Shooter shooter;
	private EnemyComposite enemyComposite;
	private Timer timer;
	private TimerListener timerListener;
	private static int score;
	private int round = 1;
	private EnemyObserver eObserver;
	private ShooterObserver sObserver;

	public GameBoard(JFrame window) {
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();

		canvas = new MyCanvas(this, WIDTH, HEIGHT);
		cp.add(BorderLayout.CENTER, canvas);
		canvas.addKeyListener(new KeyController(this));
		canvas.requestFocus();
		canvas.setFocusable(true);

		JButton quitButton = new JButton("Quit");
		startButton.setFocusable(false);
		quitButton.setFocusable(false);
		nextButton.setFocusable(false);
		pauseButton.setFocusable(false);

		JPanel southPanel = new JPanel();
		southPanel.add(startButton);
		southPanel.add(nextButton);
		southPanel.add(pauseButton);
		southPanel.add(quitButton);
		nextButton.setEnabled(false);
		cp.add(BorderLayout.SOUTH, southPanel);

		canvas.getGameElements().add(new TextDraw("Click Start to Play", 100, 100, Color.yellow, 30));
		timerListener = new TimerListener(this);
		

		startButton.addActionListener(event ->{
			timer = new Timer(DELAY, timerListener);
			shooter = new Shooter(GameBoard.WIDTH / 2 - (ShooterBody.SIZE / 2), GameBoard.HEIGHT - (ShooterBody.SIZE / 2) - ShooterBody.SIZE);
			enemyComposite = new EnemyComposite();
			canvas.getGameElements().clear();
			canvas.getGameElements().add(shooter);
			canvas.getGameElements().add(enemyComposite);
			timer.start();
			EnemyObserver eObserver = new EnemyObserver(this);
			enemyComposite.addEnemyListener(eObserver);
			ShooterObserver sObserver = new ShooterObserver(this);
			shooter.addShooterListener(sObserver);
			scoreReset();
			startButton.setEnabled(false);
		});

		nextButton.addActionListener(event ->{
			timer = new Timer((int) DELAY, timerListener);
			timer = new Timer((int) DELAY, timerListener);
			shooter = new Shooter(GameBoard.WIDTH / 2 - (ShooterBody.SIZE / 2), GameBoard.HEIGHT - (ShooterBody.SIZE / 2) - ShooterBody.SIZE);
			enemyComposite = new EnemyComposite();
			canvas.getGameElements().clear();
			canvas.getGameElements().add(shooter);
			canvas.getGameElements().add(enemyComposite);
			timer.start();
			eObserver = new EnemyObserver(this);
			enemyComposite.addEnemyListener(eObserver);
			sObserver = new ShooterObserver(this);
			shooter.addShooterListener(sObserver);
			nextButton.setEnabled(false);
		});

		pauseButton.addActionListener(event ->{
			String label = pauseButton.getText();
			if(label.equals("Pause")){
				pauseButton.setText("Resume");
				timer.stop();
			} else {
				pauseButton.setText("Pause");
				timer.start();
			}
		});

		quitButton.addActionListener(event -> System.exit(0));


	}

	public MyCanvas getCanvas() {
		return canvas;
	}

	public Timer getTimer() {
		return timer;
	}

	public TimerListener getTimerListener() {
		return timerListener;
	}
	public Shooter getShooter() {
		return shooter;
	}

	public EnemyComposite getEnemyComposite() {
		return enemyComposite;
	}

	public static void incrementScore(){
		score += 10;
	}

	public static int getScore() {
		return score;
	}

	public void increaseSpeed(){
		DELAY -= 5;
	}

	public void reset(){
		DELAY = 1000 / FPS;
		enemyComposite.resetEnemies();
	}
	public double getDELAY() {
		return DELAY;
	}

	public void nextRound(){
		round++;
	}

	public int getRound() {
		return round;
	}

	public JButton getStartButton(){
		return startButton;
	}

	public void scoreReset(){
		score = 0;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public JButton getNextButton() {
		return nextButton;
	}
	
}
