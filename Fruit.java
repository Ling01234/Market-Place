package assignment1;

public class Fruit extends MarketProduct{
	

	private double weight;
	private int price;
	

	
	
	
	public Fruit(String name, double weight, int price) {
		super(name);
		
		this.weight = weight;
		this.price = price;
	}
	
	public int getCost() {		
		return (int) (this.weight * this.price);
		
	}
	
	public boolean equals(Object o) {
		if (o instanceof Fruit) {
			Fruit f = (Fruit) o;
			
			boolean a = this.getName().equals(f.getName());
			boolean b = this.weight == f.weight;
			boolean c = this.price == f.price;
			
			return a && b && c;
		}
		else {
		return false;
		}
	}
}
