package thread;

class T1 extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				sleep(1000);   //sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T1 : " + i);
		}
	}
}

class T2 extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			
			try {
				sleep(1000);  //sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T2 : " + i);
		}
	}
}

public class T001_ThreadDemo {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		
		System.out.println(t1.getId());
		System.out.println(t2.getId());

		t1.setName("A");
		t2.setName("B");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		t1.start();
		t2.start();
	}

}
