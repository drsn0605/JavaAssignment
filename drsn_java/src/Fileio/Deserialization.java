package Fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
	public static void main(String[] args) {
		
		
		FileInputStream fis = null;
		ObjectInputStream os = null;
	
		try {
			fis = new FileInputStream("D:\\Files\\demo1.ser");
			os = new ObjectInputStream(fis);
			
			product pd = (product) os.readObject();   //to read file
			pd.display();			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
