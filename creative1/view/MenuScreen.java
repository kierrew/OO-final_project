package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.ButtonClickListener;
import model.Order;

public class MenuScreen {

	private JFrame window;
	private JRadioButton[] sizeButtons;
	private JRadioButton[] crustButtons;
	private JRadioButton[] sauceButtons;
	private JCheckBox[] sidesCheckBox;
	private JCheckBox[] desCheckBox;
	private JCheckBox[] extrasCheckBox;
	private JCheckBox[] topCheckBox;
	private JLabel lblDrink = new JLabel("Number of drinks. You want it? We got it don't worry! $1.00/drink");
	private	JTextField txtDrink = new JTextField("Enter drink amount. Must enter amount");
	private	JButton orderButton = new JButton("Place order");
	public Order o1 = new Order();

	public MenuScreen(JFrame window){
		this.window = window;
		window.setTitle("Pizza Order Screen");
	}
	
	public void init(){
		Container cp = window.getContentPane();
		JPanel pizzaPanel = new JPanel();
		JPanel xtraPanel = new JPanel();
		JPanel drinkPanel = new JPanel();
		drinkPanel.setLayout(new GridLayout(2, 2));
		

		//sets up the size panel
		sizeButtons = new JRadioButton[5];
		sizeButtons[0] = new JRadioButton("Personal(6 in.) \n $5.99");
		sizeButtons[1] = new JRadioButton("Small(10 in.) \n $7.99");
		sizeButtons[1].setSelected(true);
		sizeButtons[2] = new JRadioButton("Medium(12 in.) \n $11.99");
		sizeButtons[3] = new JRadioButton("Large(16 in.) \n $13.99");
		sizeButtons[4] = new JRadioButton("Colossal 24 in. \n 25.99");

		JPanel sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(5,1));
		sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
		ButtonGroup sizeGroup = new ButtonGroup();
		for(var b: sizeButtons){
			sizePanel.add(b);
			sizeGroup.add(b);
		}
		pizzaPanel.add(sizePanel);

		//sets up crust type
		crustButtons = new JRadioButton[3];
		crustButtons[0] = new JRadioButton("Thin");
		crustButtons[1] = new JRadioButton("Pan");
		crustButtons[1].setSelected(true);
		crustButtons[2] = new JRadioButton("Deep dish + $1.00 \n avalible for small - large pizzas");

		JPanel crustPanel = new JPanel();
		crustPanel.setLayout(new GridLayout(3,1));
		crustPanel.setBorder(BorderFactory.createTitledBorder("Crust"));
		ButtonGroup crustGroup = new ButtonGroup();
		for(var b: crustButtons){
			crustPanel.add(b);
			crustGroup.add(b);
		}
		pizzaPanel.add(crustPanel);

		//sets up sauce panel
		sauceButtons = new JRadioButton[3];
		sauceButtons[0] = new JRadioButton("Alfredo");
		sauceButtons[1] = new JRadioButton("Traditonal");
		sauceButtons[1].setSelected(true);
		sauceButtons[2] = new JRadioButton("BBQ");

		JPanel saucePanel = new JPanel();
		saucePanel.setLayout(new GridLayout(3,1));
		saucePanel.setBorder(BorderFactory.createTitledBorder("Sauce"));
		ButtonGroup sauceGroup = new ButtonGroup();
		for(var b: sauceButtons){
			saucePanel.add(b);
			sauceGroup.add(b);
		}
		pizzaPanel.add(saucePanel);

		//sets ups toppings pannel
		topCheckBox = new JCheckBox[10];
		topCheckBox[0] = new JCheckBox("Peperoni");
		topCheckBox[1] = new JCheckBox("Sausage");
		topCheckBox[2] = new JCheckBox("Hamburger");
		topCheckBox[3] = new JCheckBox("Ham");
		topCheckBox[4] = new JCheckBox("Chicken");
		topCheckBox[5] = new JCheckBox("Onions");
		topCheckBox[6] = new JCheckBox("Spinach");
		topCheckBox[7] = new JCheckBox("pineapple");
		topCheckBox[8] = new JCheckBox("Peppers");
		topCheckBox[9] = new JCheckBox("Olives");

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4,1));
		topPanel.setBorder(BorderFactory.createTitledBorder("Toppings $0.50 each"));
		for(var b: topCheckBox){
			topPanel.add(b);
		}
		pizzaPanel.add(topPanel);

		// sets up sides panel
		sidesCheckBox = new JCheckBox[4];
		sidesCheckBox[0] = new JCheckBox("BreadSticks $2.00");
		sidesCheckBox[1] = new JCheckBox("Wings $5.99");
		sidesCheckBox[2] = new JCheckBox("Cheesy Bread $2.00");
		sidesCheckBox[3] = new JCheckBox("Side Salad $ 1.00");

		JPanel sidesPanel = new JPanel();
		sidesPanel.setLayout(new GridLayout(4,1));
		sidesPanel.setBorder(BorderFactory.createTitledBorder("Sides"));
		for(var b: sidesCheckBox){
			sidesPanel.add(b);
		}
		xtraPanel.add(sidesPanel);

		//sets up desserts panel
		desCheckBox = new JCheckBox[2];
		desCheckBox[0] = new JCheckBox("Cookies $2.00");
		desCheckBox[1] = new JCheckBox("Dessert Stixs $2.00");

		JPanel desPanel = new JPanel();
		desPanel.setLayout(new GridLayout(4,1));
		desPanel.setBorder(BorderFactory.createTitledBorder("Desserts"));
		for(var b: desCheckBox){
			desPanel.add(b);
		}
		xtraPanel.add(desPanel);

		//sets up extras panel
		extrasCheckBox = new JCheckBox[4];
		extrasCheckBox[0] = new JCheckBox("Garlic Sauce $0.50");
		extrasCheckBox[1] = new JCheckBox("Ranch $0.50");
		extrasCheckBox[2] = new JCheckBox("Bleu Cheese $0.50");
		extrasCheckBox[3] = new JCheckBox("Parmesan and peppers (free)");

		JPanel extrasPanel = new JPanel();
		extrasPanel.setLayout(new GridLayout(4,1));
		extrasPanel.setBorder(BorderFactory.createTitledBorder("Extras"));
		for(var b: extrasCheckBox){
			extrasPanel.add(b);
		}
		xtraPanel.add(extrasPanel);

		
		drinkPanel.add(lblDrink);
		drinkPanel.add(txtDrink);
		drinkPanel.add(orderButton);

		cp.add(BorderLayout.CENTER, xtraPanel);
		cp.add(BorderLayout.NORTH, pizzaPanel);
		cp.add(BorderLayout.SOUTH, drinkPanel);
		orderButton.addActionListener(new ButtonClickListener(this));
	}

	public JButton getOrderButton(){
		return orderButton;
	}

	public JCheckBox[] getToppingsButtons(){
		return topCheckBox;
	}

	public JCheckBox[] getExtrasButtons(){
		return extrasCheckBox;
	}

	public JCheckBox[] getSidesButtons(){
		return sidesCheckBox;
	}

	public JCheckBox[] getDessertButtons(){
		return desCheckBox;
	}

	public JTextField getDrinks(){
		return txtDrink;
	}

	public JFrame getWindow(){
		return window;
	}

	public void determSize(){
		String[][] size = o1.getSize();
		int i = 0;
		for(var b : sizeButtons){
			if(b.isSelected()){
				o1.orderTotal += Double.parseDouble(size[i][1]);
				o1.description = "Pizza description: " + size[i][0];
				break;
			}
			i++;
		}
	}

	public void determCrust (){
		String[][] crust = o1.getCrust();
		int i = 0;
		for(var b : crustButtons){
			if(b.isSelected()){
				o1.orderTotal += Double.parseDouble(crust[i][1]);
				o1.description += crust[i][0];
				break;
			}
			i++;
		}
	}

	public void determSauce(){
		String[] sauce = o1.getSauce();
		int i = 0;
		for(var b : sauceButtons){
			if(b.isSelected()){
				o1.description += sauce[i];
				break;
			}
			i++;
		}
		o1.description += "\n" + "Toppings: ";
	}

	public void determToppings(){
		String[] toppings = o1.getToppings();
		int i = 0;
		for(var b : topCheckBox){
			if(b.isSelected()){
				o1.description += toppings[i];
				o1.orderTotal += 0.50; 
			}
			i++;
		}
	}

	public void determExtras (){
		o1.description += "\n" + "Extras: ";
		String[][] extras = o1.getExtras();
		int i = 0;
		for(var b : extrasCheckBox){
			if(b.isSelected()){
				o1.description += extras[i][0];
				o1.orderTotal += Double.parseDouble(extras[i][1]); 
			}
			i++;
		}
	}

		public void determSides (){
			o1.description += "\n" + "Sides: ";
			String[][] sides = o1.getSides();
			int i = 0;
			for(var b : sidesCheckBox){
				if(b.isSelected()){
					o1.description += sides[i][0];
					o1.orderTotal += Double.parseDouble(sides[i][1]); 
				}
				i++;
			}
		}
		
		public void determDessert (){
			o1.description += "\n" + "Desserts ";
			String[][] dessert = o1.getDessert();
			int i = 0;
			for(var b : desCheckBox){
				if(b.isSelected()){
					o1.description += dessert[i][0];
					o1.orderTotal += Double.parseDouble(dessert[i][1]); 
				}
				i++;
			}
		}

		public void determDrinks(){
			double numDrinks = Integer.parseInt(txtDrink.getText());
			o1.orderTotal += numDrinks;
			o1.description += "and " + (txtDrink.getText()) + " Drinks";
		}
		
		public String getDescription(){
			return o1.description;
		}
	
		public String getPrice(){
			o1.orderTotal = (o1.orderTotal * 100) / 100;
			String price = "The Total is $" + String.valueOf(o1.orderTotal);
			return price;
		}
}