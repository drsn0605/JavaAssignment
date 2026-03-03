package Fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class F010_Serialization {
	public static void main(String[] args) {
		
		F009_Student st = new F009_Student();
		
		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		
		try {
			fos = new FileOutputStream("D:\\Files\\demo.ser");
			os = new ObjectOutputStream(fos);
			
			os.writeObject(st);
			System.out.println("done");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
