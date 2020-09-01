package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MenuScreen {

	private JFrame window;
	private JRadioButton[] sizeButtons;
	private JRadioButton[] crustButtons;
	private JRadioButton[] sauceButtons;
	private JRadioButton[] fanButtons;
	private JCheckBox[] sidesCheckBox;
	private JCheckBox[] desCheckBox;
	private JCheckBox[] extrasCheckBox;
	private JCheckBox[] topCheckBox;

	public MenuScreen(JFrame window){
		this.window = window;
		window.setTitle("Pizza Order Screen");
	}
	
	public void init(){
		Container cp = window.getContentPane();
		JPanel pizzaPanel = new JPanel();
		JPanel xtraPanel = new JPanel();
		//panel.setPreferredSize(new Dimension(800, 400));

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
		sizeButtons[1].setSelected(true);
		crustButtons[2] = new JRadioButton("Deep dish + $1.00 \n avalible for small - large pizzas");

		JPanel crustPanel = new JPanel();
		crustPanel.setLayout(new GridLayout(3,1));
		crustPanel.setBorder(BorderFactory.createTitledBorder("Sauce"));
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
		sidesCheckBox = new JCheckBox[10];
		sidesCheckBox[0] = new JCheckBox("Peperoni");
		sidesCheckBox[1] = new JCheckBox("Sausage");
		sidesCheckBox[2] = new JCheckBox("Hamburger");
		sidesCheckBox[3] = new JCheckBox("Ham");
		sidesCheckBox[4] = new JCheckBox("Chicken");
		sidesCheckBox[5] = new JCheckBox("Onions");
		sidesCheckBox[6] = new JCheckBox("Spinach");
		sidesCheckBox[7] = new JCheckBox("pineapple");
		sidesCheckBox[8] = new JCheckBox("Peppers");
		sidesCheckBox[9] = new JCheckBox("Olives");

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4,1));
		topPanel.setBorder(BorderFactory.createTitledBorder("Toppings $0.50 each"));
		for(var b: sidesCheckBox){
			topPanel.add(b);
		}
		pizzaPanel.add(topPanel);

		//sets ups fan favorites panel
		fanButtons = new JRadioButton[5];
		fanButtons[0] = new JRadioButton("Meat Lovers");
		fanButtons[1] = new JRadioButton("Veggie");
		fanButtons[2] = new JRadioButton("Hawaiian");
		fanButtons[3] = new JRadioButton("CHicken Alfredo");
		fanButtons[4] = new JRadioButton("BBQ CHicken");

		JPanel fanPanel = new JPanel();
		fanPanel.setLayout(new GridLayout(5,1));
		fanPanel.setBorder(BorderFactory.createTitledBorder("Fan favorites"));
		ButtonGroup fanGroup = new ButtonGroup();
		for(var b: fanButtons){
			fanPanel.add(b);
			fanGroup.add(b);
		}
		xtraPanel.add(fanPanel);

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

		cp.add(BorderLayout.CENTER, xtraPanel);
		cp.add(BorderLayout.NORTH, pizzaPanel);


	}
}