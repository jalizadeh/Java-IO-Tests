package Examples;

public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	
	//factory method
	static Item newItem(String[] elements) {
		String name = elements[0];
		Double price = Double.parseDouble(elements[1]);
		
		return  new Item(name, price);
	}
	
}
