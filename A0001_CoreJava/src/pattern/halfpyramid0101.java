package pattern;

public class halfpyramid0101 {
	public static void main(String[] args) {
		
//		0
//		10
//		010
//		1010
//		01010
		
//		int n = 5;
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=i;j++) {
//				System.out.print((i+j)%2);
//			}
//			System.out.println();
//		}
		
		int starcount = 1;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=starcount;j++) {
				System.out.print((i+j)%2);
			}
			System.out.println();
			starcount++;
		}
		
	}

}
