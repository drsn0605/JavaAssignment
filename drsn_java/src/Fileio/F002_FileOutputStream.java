package Fileio;

import java.io.FileOutputStream;
import java.io.IOException;

public class F002_FileOutputStream {
	public static void main(String[] args) {

		FileOutputStream fos = null; // global
		try {
			fos = new FileOutputStream("D:\\Files\\Test.txt2");
			String str = "this is my first io practical";
			byte b[] = str.getBytes();
			fos.write(b); // Add exception to existing catch cause
			System.out.println("done");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); // it gives the info about exception
			}
		}
	}

}
