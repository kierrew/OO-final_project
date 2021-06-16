package Model;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;



public abstract class Target implements IRender {

	private int x;
	private int y;
	private BufferedImage image;
	private boolean positivePoints;

	public Target(int x, int y, boolean positivePoints){
		this.x = x;
		this.y = y;
		this.positivePoints = positivePoints;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getPositivePoints(){
		return positivePoints;
	}

	@Override
	public Rectangle GetBoundingBox(){
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
}
