package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.MenuScreen;

public class ButtonClickListener implements ActionListener {

	private MenuScreen panel;

	public ButtonClickListener(MenuScreen panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		var button = e.getSource();
		if(button == panel.getOrderButton()){
			panel.determSize();
			panel.determCrust();
			panel.determSauce();
			panel.determToppings();
			panel.determExtras();
			panel.determSides();
			panel.determDessert();
			panel.determDrinks();
			JOptionPane.showMessageDialog(null, panel.getDescription()
			 + "\n" + panel.getPrice(), "Order Information", JOptionPane.PLAIN_MESSAGE);
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.init();
			window.pack();
			window.revalidate();
		}
	}
}


