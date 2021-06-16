package Test;

import java.util.ArrayList;

import Model.idemo.Airplane;
import Model.idemo.Bird;
import Model.idemo.Car;
import Model.idemo.Dog;
import Model.idemo.ISound;

public class ISoundTest {

	public static void main(String[] args){
		ArrayList<ISound> sounds = new ArrayList<>();
		sounds.add(new Dog(50, 50, "Bulldog", 3, "white"));
		sounds.add(new Bird(100, 100, "Eagle", 5, 10));
		sounds.add(new Dog(150, 150, "Poodle", 3, "brown"));
		sounds.add(new Bird(200, 200, "Sparrow", 1, 2));
		sounds.add(new Car(4, 10, "Ford", 9000, "Sedan"));
		sounds.add(new Airplane(100, 100, "Boeing", 500000, 350));
		sounds.add(new Car(40, 60, "GM", 8500, "SUV"));
		sounds.add(new Airplane(500, 700, "Airbus", 700000, 250));

		for(var s : sounds){
			String msound = s.getSound();
			if (s instanceof Dog){
				assert msound.contains("Dog");
			}else if(s instanceof Bird){
				assert msound.contains("Bird");
			}else if(s instanceof Car){
				assert msound.contains("Car");
			}else if(s instanceof Airplane){
				assert msound.contains("Airplane");
			}
		}



	}
	
}
