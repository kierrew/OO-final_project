package Model.idemo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Dog extends Animal {

	private String color;

	public Dog(int x, int y, String name, int age, String color) {
		super(x, y, name, age);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "[Dog] " + super.toString() + ", colo = " + color;
	}

	@Override
	public String getSound() {
		return "[Dog] woo ~~~~ fffff";
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), null, getX(), getY());
		g2.setColor(Color.yellow);
		g2.drawString("color = " + color, getX(), getY());
	}

	@Override
	public Rectangle GetBoundingBox(){
		return new Rectangle(super.getX(), super.getY(), super.getImage().getWidth(), super.getImage().getHeight());
	}
}
