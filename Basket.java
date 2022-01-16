package assignment1;


public class Basket {
	
	public static void main(String[] args) {
		Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("kiwi", 2.0, 100));
        
        /*
		 Basket myBasket = new Basket();
	        myBasket.add(new Egg("organic Eggs",5,380));
	        myBasket.add(new Fruit("Blue Berry",1.5,380));
	        myBasket.add(new Fruit("Green Berry",1.5,380));
	        myBasket.add(new Fruit("red Berry",1.5,380));
	        myBasket.add(new Fruit("Random fruit",1.1,340));
	        Boolean a = myBasket.remove(new Fruit("Random fruit",1.1,340));
	        Boolean b = myBasket.remove(new Egg("Green Berry",3,350));
	        System.out.print(myBasket.toString());
	        
	        */
	        System.out.print(basket.toString());

	}
	
	private MarketProduct[] products;
	
	public Basket() {
		this.products = new MarketProduct[0];
	}
	
	public MarketProduct[] getProducts() {	
		return this.products.clone();
	}
	
	public void add(MarketProduct m) {
		
		int length = this.products.length;
		
		
		if (length == 0) {
			MarketProduct[] temp = new MarketProduct[1];
			temp[0] = m;
			
			this.products = temp;
		}
		else {
			MarketProduct[] temp = new MarketProduct[length+1];
			for (int i = 0; i<this.products.length;i++) {
				temp[i] = this.products[i];
			}
			
			temp[length] = m;
			this.products = temp;
		}
		

	}
	
	private void shift(int j) {
		for (int i = 0;i<this.products.length;i++) {
			
			if(j == this.getNumOfProducts()-1) {
				this.products[j] = null;
			}
			
			else if (i<=j) {
				continue;
			}
			
			else if(i == this.getNumOfProducts()-1) {
				this.products[i-1] = this.products[i];
				this.products[i] = null;
				
			}

			else {
				this.products[i-1] = this.products[i];
			}
			
		}
	}
	
	
	
	
	public boolean remove(MarketProduct m) {
		
		
		for (int i =0; i<this.products.length;i++) {
			if (this.products[i] != null && this.products[i].equals(m)) {
				shift(i);
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	public void clear() {
		this.products = new MarketProduct[0];
	}
	
	public int getNumOfProducts() {
		int counter = 0;
		for (int i = 0;i<this.products.length;i++) {
			if (this.products[i] instanceof MarketProduct) {
				counter++;
			}
			else {
				continue;
			}
		}
		return counter;
	}
	
	public int getSubTotal() {
		
		int total = 0;
		
		for (int i = 0; i<this.products.length; i++) {
			if (this.products[i] != null) {
			total += this.products[i].getCost();
		}}
		

		
		return total;
	}
	
	public int getTotalTax() {
		double total = 0;
		
		for (int i = 0; i<this.products.length;i++) {
			if (this.products[i] instanceof Jam) {
				total += this.products[i].getCost()*0.15;
			}
			else {
				continue;
			}
		}
		return (int) total;
		
	}
	
	public int getTotalCost() {
		return getTotalTax() + getSubTotal();
	}
	
	
	
	public String toString(){
		

		
		String info = "";
		
		for (int i = 0; i<this.products.length;i++) {
			
			if (this.products[i] != null && this.products[i].getCost() <= 0) {
				info += this.products[i].getName() + "\t - \n";
			}
			else if (this.products[i] == null) {
				continue;
			}
			else {
			info += this.products[i].getName() + "\t" + String.format("%.2f",(double)this.products[i].getCost()/100) + "\n";
			}
		}

		info += "\n";
		
		if (getSubTotal() == 0) {
			info += "Subtotal \t-\n";
		}
		else {
			info += "Subtotal \t" + String.format("%.2f",(double)getSubTotal()/100) + "\n";
		}
		
		if (getTotalTax() == 0) {
			info += "Total Tax \t-\n\n";
		}
		else {
			info += "Total Tax \t" + String.format("%.2f",(double)getTotalTax()/100) + "\n\n";
		}
		
		if (getTotalCost() == 0) {
			info += "Total Cost \t-\n";
		}
		else {
			info += "Total Cost \t" + String.format("%.2f",(double)getTotalCost()/100);
		}
		
		return info;
	}
	
	
	
	
	
}
