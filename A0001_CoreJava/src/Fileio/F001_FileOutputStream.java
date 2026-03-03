package Fileio;

import java.io.FileOutputStream;
import java.io.IOException;

public class F001_FileOutputStream {
	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("D:\\Files\\Test.txt");
			
			String s = "this is my first io practicle..";
			byte b[] = s.getBytes(); //to convert char to bytes
			fos.write(b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}