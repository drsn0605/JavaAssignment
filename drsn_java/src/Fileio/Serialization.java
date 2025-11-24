package Fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) {
		product pd = new product();
		
		
		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		try {
			fos = new FileOutputStream("D:\\Files\\demo1.ser");  //write data to file
			os = new ObjectOutputStream(fos);   //converting to byte stream 
			
			os.writeObject(pd);  //write the specified object to ObjectOutputStream.
			System.out.println("done");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
