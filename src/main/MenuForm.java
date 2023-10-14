package main;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuForm extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JPanel menuPanel;
	private JPanel calculatePanel;
	private JButton btnCalculate;
	private JLabel lblCost;
	private IIngredient ourDrink;
	private IngredientButton btnAddCup;
	private IngredientButton btnAddCoffee;
	private IngredientButton btnAddWhiteChocolate;

	public MenuForm(String title) throws HeadlessException {
		super(title);

		
		this.ourDrink = new Cup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create my panel
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		add(this.panel);
		
		// create the menu
		this.menuPanel = new JPanel();
		this.menuPanel.setLayout(new GridLayout(0,2));
		this.panel.add(this.menuPanel);
		
		// creates the calculate panel
		this.calculatePanel = new JPanel();
		this.calculatePanel.setLayout(new BoxLayout(this.calculatePanel, BoxLayout.Y_AXIS));
		this.panel.add(this.calculatePanel);
		
		// creates the menu buttons
		this.btnAddCup = new IngredientButton("New Cup", this, "cup");
		this.btnAddCoffee = new IngredientButton("Add Coffee", this, "coffee");
		this.btnAddWhiteChocolate = new IngredientButton("Add White Chocolate", this, "white chocolate");
		
		
		this.menuPanel.add(btnAddCup);
		this.menuPanel.add(btnAddCoffee);
		this.menuPanel.add(btnAddWhiteChocolate);
		
		
		// creates the calculate buttons and labels
		// create the button
		this.btnCalculate = new JButton("Go");
		this.btnCalculate.setText("Calculate");
		this.btnCalculate.addActionListener(this);
		
		this.calculatePanel.add(btnCalculate);
		
		// create the cost label
		this.lblCost = new JLabel("Cost: $0.00");
		this.calculatePanel.add(lblCost);
		
		calculateCostAndUpdate();
		
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// access the label and update
		calculateCostAndUpdate();
	}
	
	public void calculateCostAndUpdate() {
		this.lblCost.setText("Cost: $" + this.ourDrink.CalculateCost());
	}

	public void addIngredient(String ingredientType) {
		if (ingredientType == "cup") {
			this.ourDrink = new Cup();
		} else if (ingredientType == "coffee") {
			this.ourDrink = new Coffee(this.ourDrink);
		} else if (ingredientType == "white chocolate") {
			this.ourDrink = new WhiteChocolate(this.ourDrink);
		} else {
			System.out.println("this option does not exist");
		}
		
		calculateCostAndUpdate();
	}

	
}
