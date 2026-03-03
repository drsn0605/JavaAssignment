package collection;

public class Product {
	int id;
	String name;
	int prize;
	int quantity;
	public Product(int id, String name, int prize, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.quantity = quantity;
	}
	
	public void display() {
		System.out.println(id+" "+name+" "+prize+" "+quantity);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", prize=" + prize + ", quantity=" + quantity + "]";
	}
	
	

}
