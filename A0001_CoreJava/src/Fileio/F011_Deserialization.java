package Fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class F011_Deserialization {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		ObjectInputStream os = null;
		
		try {
			fis = new FileInputStream("D:\\Files\\demo.ser");
			os = new ObjectInputStream(fis);
			
			F009_Student st = (F009_Student) os.readObject();
			st.display();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
