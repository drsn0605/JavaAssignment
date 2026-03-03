package Thread;

class Account{
	double balance;
	
	Account(double balance){
		this.balance = balance;
	}
}

class Customer extends Thread{
	
}
public class BlockSync {
	public static void main(String[] args) {
		
		Account ac = new Account(5000);
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		
		c1.start();
		c2.start();
	}

}
