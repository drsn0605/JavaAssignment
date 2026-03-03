package OOPS_03;

class Test1 {
	static int count = 0;    //static variable
	
	Test1 (){
		count++;
		System.out.println("Count : "+count);
	}

}

public class WithStatic {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		Test1 t2 = new Test1();
		Test1 t3 = new Test1();
	}
}
