package assignment1;

public class Customer {
	private String name;
	private int balance;
	private Basket b;
	
	
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.b = new Basket();
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public Basket getBasket() {
		return this.b;
	}
	
	public int addFunds(int i) {
		if (i < 0) {
			throw new IllegalArgumentException ("The entered input is negative.");
		}
		
		this.balance = this.balance + i;
		
		return this.balance;
		
	}
	
	public void addToBasket(MarketProduct m) {
		this.b.add(m);
	}
	
	public boolean removeFromBasket(MarketProduct m) {
		return this.b.remove(m);
	}
	
	public String checkOut() {
		if (this.balance < this.b.getTotalCost()) {
			throw new IllegalStateException ("Your balance is not enough to cover the total cost.");
		}
		else {
			this.balance -= this.b.getTotalCost();
			String receipt = this.b.toString();
			this.b.clear();
			return receipt;
		}
	}
	
	
	
}
