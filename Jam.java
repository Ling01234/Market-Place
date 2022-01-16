package assignment1;

public class Jam extends MarketProduct{
	
	private int num;
	private int price;
	
	
	public Jam(String name, int num, int price) {
		super(name);
		this.num = num;
		this.price = price;
		
	}
	
	
	public int getCost(){
		return this.num*this.price;
	}
	
	public boolean equals(Object o) {
		
		if (o instanceof Jam) {
			Jam j = (Jam) o;
			
			boolean a = this.getName().equals(j.getName());
			boolean b = this.num == j.num;
			boolean c = this.price == j.price;
			
			return a && b && c;
			
		}
		else {
			return false;
		}
	}
}
