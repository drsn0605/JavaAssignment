package oops;

interface I1
{
	public static final int a = 10;
	void display();
}

interface I2
{
	public void display();
}

class Interimpl implements I1,I2
{

	@Override
	public void display() {
		System.out.println("display calling...");
		
	}
	
}

public class Interface {
	public static void main(String[] args) {
		
		Interimpl i = new Interimpl();
		i.display();
		
	}

}
