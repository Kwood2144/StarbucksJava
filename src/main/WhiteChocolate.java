package main;

public class WhiteChocolate extends IngredientDecorator {

	public WhiteChocolate(IIngredient ingredient) {
		super(ingredient);
		this.Cost = 0.1;
		this.Name = "White Chocolate";
	}

}
