package Fileio;

import java.io.FileInputStream;
import java.io.IOException;

public class F004_FileInputStream {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\Files\\Test.txt");
			int i = fis.read();
			
			while(i!=-1) {
				
//				System.out.print(i);  //read only ascii value
//				i = fis.read();
				
				char ch = (char) i;
				System.out.print(ch);
				i = fis.read();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
