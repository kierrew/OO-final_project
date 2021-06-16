package Model;

import java.awt.Graphics2D;

public class Stand {

	public void render(Graphics2D g2){
		g2.drawLine(450, 450, 50, 450);
		g2.drawLine(200, 450, 200, 50);
		g2.drawLine(200, 50, 350, 50);
		g2.drawLine(350, 50, 350, 100);
	}
}


