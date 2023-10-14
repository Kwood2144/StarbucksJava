package main;

public abstract class IngredientDecorator implements IIngredient {
	
	private IIngredient DecoratedObject;
	protected double Cost;
	protected String Name;

	public IngredientDecorator(IIngredient ingredient) {
		this.DecoratedObject = ingredient;
	}
	
	@Override
	public double CalculateCost() {
		return this.Cost + this.DecoratedObject.CalculateCost();
	}

	@Override
	public String ToString() {
		return this.Name + " " + this.DecoratedObject.ToString();
	}


}
