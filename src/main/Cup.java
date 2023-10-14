package main;

public class Cup implements IIngredient {
	
	protected double Cost;
	protected String Name;
	
	public Cup() {
		this.Cost = 0.5;
		this.Name = "Cup";
	}

	@Override
	public double CalculateCost() {
		return this.Cost;
	}

	@Override
	public String ToString() {
		return this.Name;
	}

}
