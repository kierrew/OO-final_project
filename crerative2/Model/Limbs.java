package Model;

import java.awt.Graphics2D;


public class Limbs {

	public void renderBody(Graphics2D g2){
		g2.drawLine(350, 150, 350, 300);
	} 
	
	public void renderLL(Graphics2D g2){
		g2.drawLine(275, 375, 350, 300);
	}

	public void renderRL(Graphics2D g2){
		g2.drawLine(425, 375, 350, 300);
	}

	public void renderLA(Graphics2D g2){
		g2.drawLine(275, 175, 350, 225);
	}

	public void renderRA(Graphics2D g2){
		g2.drawLine(425, 175, 350, 225);
	}
}
