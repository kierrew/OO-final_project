package Model;

import java.awt.Graphics2D;



public class HostageTarget extends Target{

	//private boolean positivePoints = false;
	private int pointValue = -1;


	public HostageTarget(int x, int y, boolean positivePoints){
		super(x, y, positivePoints);
		if(positivePoints){
			this.pointValue = 1;
		}
		else{
			this.pointValue = -1;
		}
	}

	public int getPointValue() {
		return pointValue;
	}

	@Override
	public void render(Graphics2D g2){
		g2.drawImage(getImage(), null, getX(), getY());
	}
	
}
