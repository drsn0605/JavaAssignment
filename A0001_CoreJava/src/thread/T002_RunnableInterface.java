package thread;

//there are 2 ways to create thread 1.using thread class(extends Thread) 2.using Runnable interface(implements Runnable) 
//what is the actual use of runnable - Hence, in runnable also we are creating Thread..
//if we want to do both work inheritance and threading we use Runnable.
//because multiple inheritance is not possible in java
//we cannot extends two class.

class Sample {

}

class Th1 extends Sample implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			
			try {    
				Thread.sleep(1000);     //sleep method
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} // Add unimplemented methods

}

public class T002_RunnableInterface {
	public static void main(String[] args) {

		Th1 t1 = new Th1();
		Th1 t2 = new Th1();

		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);

		th1.setName("a");
		th2.setName("b");

		th1.start();
		th2.start();

	}

}
