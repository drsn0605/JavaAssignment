package logical;

public class BTO {

	public static void main(String[] args) {
		int num = 1111001;
		int sum = 0;
		int count = 0;
		
		while(num!=0) {
			int rem = num%10;
			sum = (int)(sum + (rem*Math.pow(8, count)));
//			System.out.println(rem);
			num = num/10;
			count = count + 1;
		}
		System.out.println(sum);

	}

}
