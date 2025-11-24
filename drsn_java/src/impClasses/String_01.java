package impClasses;

public class String_01 {
	public static void main(String[] args) {
//		//string literal 
//		String s = "hello";
//		String s2 = s.concat("moto"); //concatenation
//				
//	    //string object - using new keyword
//	    String s1 = new String("Hello");
//		
//		System.out.println(s1);
//		System.out.println(s2);
		
		String s1 = "Java"; //in string literal 
		String s2 = "php";
		String s3 = "Java";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1 == s3); //it returns true bcoz-- both refer to the [same object] in the String Pool.  
		
		System.out.println("******************");
		
		String str1 = new String("Java");
		String str2 = new String("php");
		String str3 = new String("Java");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1 == str3); //it returns false bcoz-- Each new keyword creates a [different object].
		
		//for more info. check string001.xlsx file
		
	}

}
