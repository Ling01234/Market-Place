package assignment1;

public class Egg extends MarketProduct {
	
	private int numOfEggs;
	private int pricePerDozen;
	
	public Egg(String name, int num, int pricePerDozen) {
		super(name);
		
		
		
		this.numOfEggs = num;
		this.pricePerDozen = pricePerDozen;
		
	}
	
	public int getCost() {
		return (int) Math.floor(this.numOfEggs * this.pricePerDozen/12);
	}
	
	public boolean equals(Object o) {
		
		
		
		if (o instanceof Egg) {
			
			Egg e = (Egg) o;
			
			boolean a = this.getName().equals(e.getName());
			boolean b = this.numOfEggs == e.numOfEggs;
			boolean c = this.pricePerDozen == e.pricePerDozen;
			
			return a && b && c;
		}
		else {
			return false;
		}
		
		
		
		
		
	}
	
	
}
