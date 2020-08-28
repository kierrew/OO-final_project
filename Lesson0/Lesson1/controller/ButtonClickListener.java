package Lesson1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Lesson1.view.CalculatorSimulator;
import Lesson1.view.MenuScreen;

public class ButtonClickListener implements ActionListener {

	private CalculatorSimulator panel;

	public ButtonClickListener(CalculatorSimulator panel){
		this.panel = panel;


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();
		String m = panel.getDisplay().getText() + "\n";
		if (button == panel.getExitButton()){
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.init();
			window.pack();
			window.revalidate();
		}else if(button == panel.getEnterButton()){
			try{
				double value = Double.parseDouble(panel.getNumField().getText());
				panel.getCalculator().enter(value);
				panel.getDisplay().setText(m + value + " Entered");
				panel.getNumField().setText("");
			} catch (NumberFormatException xception){
				panel.getDisplay().setText(m + panel.getNumField().getText() + " ; Invalid number");
				panel.getNumField().setText("");
			}
		} else if (button == panel.getResultButton()){
			panel.getDisplay().setText(m + "Result = " + panel.getCalculator().getResult());
		} else if(button == panel.getAddButton()){
			panel.getCalculator().add();
			panel.getDisplay().setText(m + "Add operation performed");
		} else if(button == panel.getSubButton()){
			panel.getCalculator().subtract();
			panel.getDisplay().setText(m + "Subtraction operation performed");
		} else if(button == panel.getMulButton()){
			panel.getCalculator().multiply();
			panel.getDisplay().setText(m + "Multiply operation performed");
		} else if(button == panel.getDivButton()){
			panel.getCalculator().divide();
			panel.getDisplay().setText(m + "Divide operation performed");
		}

	}
	
}