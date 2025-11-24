package Exception;

class InsufficentFundAmount extends Exception {

	double d;

	public InsufficentFundAmount(double d) {
		super(String.format("Your account need more : %s", d));
		this.d = d;
	}
}

class Bank {
	double balance;

	public void checkBalance() {
		System.out.println("Current balance is :" + balance);
	}

	public void deposite(double amt) {
		balance += amt;
	}

	public void withdraw(double amt) throws InsufficentFundAmount {
		if (amt > balance) {
			throw new InsufficentFundAmount(amt - balance);
		} else {
			balance -= amt;
		}
	}
}

public class CustomException {
	public static void main(String[] args) {
		Bank b = new Bank();
		b.checkBalance();
		b.deposite(5000);
		b.checkBalance();
		b.deposite(2000);
		try {
			b.withdraw(8000);
		} catch (InsufficentFundAmount e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.checkBalance();
	}

}
