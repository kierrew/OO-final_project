package Model.Images;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageStore {

	public static BufferedImage cop1;
	public static BufferedImage cop2;
	public static BufferedImage innocent1;
	public static BufferedImage innocent2;
	public static BufferedImage innocent3;
	public static BufferedImage robber1;
	public static BufferedImage robber2;
	public static BufferedImage robber3;
	public static BufferedImage target1;
	public static BufferedImage target2;

	static {
		cop1 = readImage("Model/Images/cop1.jfif", 70, 90);
		cop2 = readImage("Model/Images/cop2.jfif", 120, 160);
		innocent1 = readImage("Model/Images/innocent1.jpg", 50, 60);
		innocent2 = readImage("Model/Images/innocent2.jpg", 70, 80);
		innocent3 = readImage("Model/Images/innocent3.png", 120, 160);
		robber1 = readImage("Model/Images/robber1.png", 70, 90);
		robber2 = readImage("Model/Images/robber2.png", 90, 110);
		robber3 = readImage("Model/Images/robber3.png", 110, 130);
		target1 = readImage("Model/Images/target1.png", 50, 60);
		target2 = readImage("Model/Images/target2.png", 110, 130);
	}

	public static BufferedImage readImage(String path, int width, int height){
		try {
			BufferedImage originalImage = ImageIO.read(new File(path));
			Image temp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImage.createGraphics();
			g2.drawImage(temp, 0, 0, null);
			g2.dispose();
			return resizedImage;
		} catch (Exception e) {
			System.out.println("Image file load error");
		}
		return null;
	}
	
}
