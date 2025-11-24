package oops;

abstract class Abs {
	public abstract void display();

	public void show() {
		System.out.println("running show.....");
	}
}

class AbsImpl extends Abs {

	@Override
	public void display() {
		System.out.println("display calling....");

	}

}

public class Absractioon {
	public static void main(String[] args) {
		
//		Abs abs = new Abs();
		

	}

}
