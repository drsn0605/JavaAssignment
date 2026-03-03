package impClasses;

import java.util.Date;
import java.util.Random;

public class Maths01 {
	public static void main(String[] args) {
		
//		System.out.println(Math.PI);
//		System.out.println(Math.sqrt(24));
//		System.out.println(Math.floor(56.3));
//		System.out.println(Math.ceil(56.3));
//		System.out.println(Math.round(56.3));
//		System.out.println(Math.pow(5, 2));
//		System.out.println(Math.tan(90));
//		
//		System.out.println("**************");
//		
		Date date = new Date();
//		System.out.println(date);
//		System.out.println(date.getDate());
//		System.out.println(date.getYear());
//		System.out.println(date.getHours());
		System.out.println(date.getTime());  //current time
		
		System.out.println("**************");
//		
//		Random r = new Random();
//		int num = r.nextInt();
//		System.out.println(num);
//		
//		System.out.println("**************");
//		
//		Random r1 = new Random();
//		int num1 = r1.nextInt(100,999);
//		System.out.println(num1);
		
		Date d1 = new Date(1760091617292l);   //must put l after 1760091617292
		System.out.println(d1);
		
		System.out.println("**************");
		
		Date d2 = new Date(1);  //1760091617292 this calculation is started from - Thu Jan 01 05:30:00 IST 1970
		System.out.println(d2);
	}

}
