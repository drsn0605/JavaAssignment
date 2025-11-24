package myPractice;

class T1 extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("T1 : "+i);
		}
	}
}

class T2 extends Thread {
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("T2 : "+i);
		}
	}
}

public class Tthread {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();

		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
        System.out.println("Execution time1: " + executionTime + " milliseconds");
        
//      long startTime1 = System.currentTimeMillis();
//		long endTime1 = System.currentTimeMillis();
//		long executionTime1 = endTime1 - startTime1;
//      System.out.println("Execution time2: " + executionTime1 + " milliseconds");
        
//		t2.run();
	}

}
