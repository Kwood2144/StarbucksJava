package main;

public class Coffee extends IngredientDecorator {

	public Coffee(IIngredient ingredient) {
		super(ingredient);
		this.Cost = 0.25;
		this.Name = "Coffee";
	}

}
