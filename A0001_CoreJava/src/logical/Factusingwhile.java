package logical;

public class Factusingwhile {

	public static void main(String[] args) {
		int num = 6;
		int fact = 1;
//		int i = 1;
//		while (i <= num) {
//			fact = fact * i;
//			i = i + 1;
//		}
//		System.out.println(fact);
		
		while(num!=0)
		{
			fact = fact*num;
			num--;
		}
		System.out.println(fact);

	}

}
