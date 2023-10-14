package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IngredientButton extends JButton implements ActionListener {

	private MenuForm form;
	private String ingredientType;
	
	
	
	public IngredientButton(String title, MenuForm form, String ingredientType) {
		super(title);
		this.form = form;
		this.ingredientType = ingredientType;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("button works: " + ingredientType);
		form.addIngredient(ingredientType);
	}

}
