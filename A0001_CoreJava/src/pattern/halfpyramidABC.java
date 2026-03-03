package pattern;

public class halfpyramidABC {
	public static void main(String[] args) {
		
//		A 
//		B C 
//		D E F 
//		G H I J 
//		K L M N O 
		
		int n = 5;
		char count = 'A';
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(count+" ");
				count++;
			}
			System.out.println();
		}
	}

}
