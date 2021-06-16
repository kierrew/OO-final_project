package Model.idemo;
import java.awt.Graphics2D;
import java.awt.Color;

public class Bird extends Animal {

	private int wingSpan;

	public Bird(int x, int y, String name, int age, int wingSpan) {
		super(x, y, name, age);
		this.wingSpan = wingSpan;
	}

	public int getWingSpan() {
		return wingSpan;
	}

	@Override
	public String toString() {
		return "[Bird] " + super.toString() + " wingSpan = " + wingSpan;
	}

	@Override
	public String getSound() {
		return "[Bird] chirrrrr r ~~~~~~ ing";
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), null, getX(), getY());
		g2.setColor(Color.yellow);
		g2.drawString("wingspan = " + wingSpan, getX(), getY());
	}
}
