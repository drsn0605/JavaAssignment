package Exception;

public class Finally {
	public static void main(String[] args) {
		int a[] = new int[5];
		
		System.out.println("hii");
		
		try {
			System.out.println(a[6]);
		} finally {
			System.out.println("i will run always");
		}
		System.out.println("byy");
	}

}
