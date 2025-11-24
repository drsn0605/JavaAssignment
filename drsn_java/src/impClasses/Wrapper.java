package impClasses;

public class Wrapper {
	public static void main(String[] args) {
		
		int i = 10;
		
		//primitive to objective(wrapper)
		//boxing 
		Integer i1 = new Integer(i);
		
		//auto boxing
		Integer i2 = i;
		
		Integer a = 20;
		
		//unboxing
		int p = a.intValue();
		
		//auto unboxing
		int q = a;
		
		int d = 842879123;
		
		Integer d1 = d; //This line converts the primitive int to an Integer object (a wrapper class).
		int e = d1.toString().length();  //d1.toString() → Converts the integer 842879123 into a String, i.e. "842879123".
		//.length() → Returns the number of characters in the string "842879123"
		
		//d1.toString() = "842879123"
		//"842879123".length() = 9
		
		//there for e = 9
		
		System.out.println(e);
		
		
	}

}
