package model;

public class Order {

	String[][] size = new String[][]{{"Personal, ", "5.99"}, {"Small, ", "7.99"}, {"Medium, ", "11.99"},
	{"Large, ", "13.99"}, {"Colossal, ", "25.99"}};//done
	String[][] crust = new String[][]{{"Thin, ", "0.00"}, {"Pan, ", "0.00"}, {"Deep, ", "1.00"}};//done
	String[] sauce= new String[]{"Alfredo, ", "Traditional, ", "BBQ "};//done
	String[] toppings= new String[]{"Peperoni, ", "Sausage, ", "Hamburger, ", "Ham, " , "Chicken, ",
	"Onions, ", "Spinach, ", "Pineapple, ", "Peppers, ", "Olives, "};//done
	String[][] sides= new String[][]{{"Breadsticks, ", "2.00"}, {"Wings, ", "5.99"}, 
	{"Cheesy Bread, ", "2.00"}, {"Side Salad, ", "1.00"}};
	String[][] dessert= new String[][]{{"Cookies, ", "2.00"}, {"Desserts Stix, ", "2.00"}};
	String[][] extras= new String[][]{{"Garlic Sauce, ", "0.50"}, {"Ranch, ", "0.50"}, 
	{"Bleu CHeese, ", "0.50"}, {"Pamesean and Peppers, ", "0.00"}};//done
	int numDrinks;
	public double orderTotal;
	public String description;

	public Order(){

	}

	public String[][] getSize(){
		return size;
	}

	public String[][] getCrust(){
		return crust;
	}

	public String[] getSauce(){
		return sauce;
	}

	public String[] getToppings(){
		return toppings;
	}

	public String[][] getExtras (){
		return extras;
	}

	public String[][] getSides (){
		return sides;
	}

	public String[][] getDessert (){
		return dessert;
	}
}