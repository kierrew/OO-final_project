package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.IDemoEventListener;
import Model.idemo.Airplane;
import Model.idemo.Bird;
import Model.idemo.Car;
import Model.idemo.Dog;
import Model.idemo.IRender;
import Model.images.ImageStore;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class IDemoPanel {

	private JFrame window;
	private JButton quitButton = new JButton("Quit");
	private IDemoCanvas canvas;

	public IDemoPanel(JFrame window){
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();

		canvas = new IDemoCanvas(this);

		JPanel southPanel = new JPanel();
		southPanel.add(quitButton);

		cp.add(BorderLayout.CENTER, canvas);
		cp.add(BorderLayout.SOUTH, southPanel);

		populatePictures();

		IDemoEventListener listener = new IDemoEventListener(this);
		canvas.addMouseListener(listener);
		canvas.addKeyListener(listener);
		canvas.requestFocusInWindow();
		canvas.setFocusable(true);

		//setFoucusable config
		quitButton.setFocusable(false);

		quitButton.addActionListener(listener);
	}

	private void populatePictures(){
		ArrayList<IRender> pics = canvas.getPictures();
		Car c1 = new Car(50, 50, "Ford", 9000, "SUV");
		pics.add(c1);
		c1.setImage(ImageStore.car);
		Airplane v2 = new Airplane(150, 50, "Boeing", 1200000, 350);
		pics.add(v2);
		v2.setImage(ImageStore.airplane);
		var v3 = new Bird(150, 150, "Eagle", 5, 10);
		pics.add(v3);
		v3.setImage(ImageStore.bird);
		var v4 = new Dog(50, 150, "Bulldog", 3, "white");
		pics.add(v4);
		v4.setImage(ImageStore.dog);;
	}

	public IDemoCanvas getCanvas() {
		return canvas;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public JFrame getWindow() {
		return window;
	}
	
}
