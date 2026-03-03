package impClasses;

public class StringBufferBuilder {
	public static void main(String[] args) {

		// sync - slow (Buffer) StringBuffer is Mutable.
		double startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer("Hello");
		for (int i = 1; i <= 1000000; i++) {
			sb.append("Python");
		}
		double endTime = System.currentTimeMillis();

		// async - fast (Builder) StringBuilder is also Mutable.
		double startTime1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder("Hello");
		for (int i = 1; i <= 1000000; i++) {
			sb1.append("Python");
		}
		double endTime1 = System.currentTimeMillis();

		System.out.println("time taken by buffer : " + (endTime - startTime));
		System.out.println("time taken by builder : " + (endTime1 - startTime1));
		
		//If we used String instead of StringBuffer, like this:
//		String s = "Hello";
//		for (int i = 1; i <= 1000000; i++) {
//		    s = s + "Python";
//		}
		//It would be much slower, because String is Immutable — every time you do s + "Python", it creates a New object.
		
	}

}
