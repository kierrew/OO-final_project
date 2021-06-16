package View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.ShooterEventListener;
import Model.BadTarget;
import Model.GoodTarget;
import Model.HostageTarget;
import Model.IRender;
import Model.NeutralTarget;
import Model.Target;
import Model.Images.ImageStore;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ShooterGamePanel {

	public enum GameState{
		READY, PLAYING, INTERMISSION
	}

	private GameState gameState = GameState.READY;
	private JFrame window;
	private JButton startButton = new JButton("Start");
	private JCheckBox villianBox = new JCheckBox("Villan Mode");
	JPanel statsPanel = new JPanel();
	private double imageSpeed = 1500;
	private int score = 0;
	private double time = 20;
	private int possibleTargets = 0;
	private JTextField timeLeft = new JTextField("Time left: " + String.valueOf(time));
	private JTextField scoreNow = new JTextField("Score: " + String.valueOf(score));
	private ShooterCanvas canvas;
	private Random rand = new Random();
	private Target temp;
	private boolean positive;
	private int round = 1;

	private ArrayList<IRender> pictures;

	private Timer timer = new Timer();
	private TimerTask populate;
	private TimerTask countDown;
	private TimerTask removePic;
	private TimerTask changeState;


	public ShooterGamePanel(JFrame window) {
		this.window = window;
	}

	public void init() {
		Container cp = window.getContentPane();
		cp.setLocation(200, 25);

		canvas = new ShooterCanvas(this);

		JPanel startPanel = new JPanel();
		startPanel.add(startButton);
		startPanel.add(villianBox);

		
		statsPanel.add(timeLeft);
		statsPanel.add(scoreNow);

		cp.add(BorderLayout.NORTH, statsPanel);

		cp.add(BorderLayout.CENTER, canvas);

		cp.add(BorderLayout.SOUTH, startPanel);

		pictures = canvas.getPics();
		GoodTarget g1 = new GoodTarget(2000, 2000, positive);
		pictures.add(g1);
		g1.setImage(ImageStore.cop1);
		GoodTarget g2 = new GoodTarget(2000, 2000, positive);
		pictures.add(g2);
		g2.setImage(ImageStore.cop2);
		HostageTarget h1 = new HostageTarget(2000, 2000, false);
		pictures.add(h1);
		h1.setImage(ImageStore.innocent1);
		HostageTarget h2 = new HostageTarget(2000, 2000, false);
		pictures.add(h2);
		h2.setImage(ImageStore.innocent2);
		HostageTarget h3 = new HostageTarget(2000, 2000, false);
		pictures.add(h3);
		h3.setImage(ImageStore.innocent3);
		BadTarget b1 = new BadTarget(2000, 2000, !positive);
		pictures.add(b1);
		b1.setImage(ImageStore.robber1);
		BadTarget b2 = new BadTarget(2000, 2000, !positive);
		pictures.add(b2);
		b2.setImage(ImageStore.robber2);
		BadTarget b3 = new BadTarget(2000, 2000, !positive);
		pictures.add(b3);
		b3.setImage(ImageStore.robber3);
		NeutralTarget n1 = new NeutralTarget(2000, 2000, true);
		pictures.add(n1);
		n1.setImage(ImageStore.target1);
		NeutralTarget n2 = new NeutralTarget(2000, 2000, true);
		pictures.add(n2);
		n2.setImage(ImageStore.target2);


		ShooterEventListener listener = new ShooterEventListener(this);
		startButton.addActionListener(listener);
		canvas.addMouseListener(listener);

	}

	public void grabPic(){
		int picselect = rand.nextInt(pictures.size());
		temp = (Target) pictures.get(picselect);
		int xLoc = rand.nextInt(1100 - 100);
		int yLoc = rand.nextInt(600);
		temp.setX(xLoc);
		temp.setY(yLoc);
		canvas.repaint();
	}

	public void removePicture(){
		temp.setX(2000);
		temp.setY(2000);
		canvas.repaint();
	}

	public JButton getStartButton() {
		return startButton;
	}

	public Timer getTimer() {
		return timer;
	}

	public TimerTask getCountDown() {
		return countDown;
	}

	public TimerTask getPopulate() {
		return populate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getImageSpeed() {
		return imageSpeed;
	}

	public void setImageSpeed(double imageSpeed) {
		this.imageSpeed = imageSpeed;
	}

	public TimerTask getRemovePic() {
		return removePic;
	}

	public ShooterCanvas getCanvas() {
		return canvas;
	}

	public void scoreIncrement(){
		score++;
	}

	public void setScoreDisplay(){
		scoreNow.setText("Score: " + String.valueOf(score));
	}

	public Target getTemp() {
		return temp;
	}

	public void scoreDecrement(){
		score--;
	}

	public void populateImages(){
		pictures.clear();
		pictures = canvas.getPics();
		GoodTarget g1 = new GoodTarget(2000, 2000, positive);
		pictures.add(g1);
		g1.setImage(ImageStore.cop1);
		GoodTarget g2 = new GoodTarget(2000, 2000, positive);
		pictures.add(g2);
		g2.setImage(ImageStore.cop2);
		HostageTarget h1 = new HostageTarget(2000, 2000, false);
		pictures.add(h1);
		h1.setImage(ImageStore.innocent1);
		HostageTarget h2 = new HostageTarget(2000, 2000, false);
		pictures.add(h2);
		h2.setImage(ImageStore.innocent2);
		HostageTarget h3 = new HostageTarget(2000, 2000, false);
		pictures.add(h3);
		h3.setImage(ImageStore.innocent3);
		BadTarget b1 = new BadTarget(2000, 2000, !positive);
		pictures.add(b1);
		b1.setImage(ImageStore.robber1);
		BadTarget b2 = new BadTarget(2000, 2000, !positive);
		pictures.add(b2);
		b2.setImage(ImageStore.robber2);
		BadTarget b3 = new BadTarget(2000, 2000, !positive);
		pictures.add(b3);
		b3.setImage(ImageStore.robber3);
		NeutralTarget n1 = new NeutralTarget(2000, 2000, true);
		pictures.add(n1);
		n1.setImage(ImageStore.target1);
		NeutralTarget n2 = new NeutralTarget(2000, 2000, true);
		pictures.add(n2);
		n2.setImage(ImageStore.target2);
	}

	public void checkPositive(){
		positive = villianBox.isSelected();
	}

	public int getPossibleTargets() {
		return possibleTargets;
	}

	public int getScore() {
		return score;
	}

	public JCheckBox getVillianBox() {
		return villianBox;
	}

	public static void pause(int time){
		try{
			Thread.sleep(time * 1000);
		} catch (Exception e) {}
	}

	public GameState getGameState(){
		return gameState;
	}
	
	public void setGameState(GameState state){
		this.gameState = state;
	} 

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public TimerTask getChangeState() {
		return changeState;
	}

	public void roundExecution(){
		timer.cancel();
		timer = new Timer();
		countDown = new TimerTask(){
			public void run(){
				if(time > -1){
					time--;
					timeLeft.setText("Time left: " + String.valueOf(time));
				}
			}
		};
		timer.scheduleAtFixedRate(getCountDown(), 1000, 1000);
		populate = new TimerTask(){
			public void run() {
				if(time > 0){
					grabPic();
					if(temp.getPositivePoints()){
						possibleTargets++;
					}
				}
			}
		};
		timer.scheduleAtFixedRate(getPopulate(), 0, (int) getImageSpeed());
		removePic = new TimerTask(){
			public void run(){
				if(time >= -1){
					removePicture();
				}
			}
		};
		timer.scheduleAtFixedRate(getRemovePic(), (int) getImageSpeed()-10, (int) getImageSpeed());
		changeState = new TimerTask(){
			public void run(){
				gameState = GameState.INTERMISSION;
			}
		};
		timer.schedule(getChangeState(), (long) getTime() * 1000);
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setPossibleTargets(int possibleTargets) {
		this.possibleTargets = possibleTargets;
	}
	
}
