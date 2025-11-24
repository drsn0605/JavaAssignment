package Fileio;

import java.io.FileWriter;
import java.io.IOException;

public class F006_FileWriter {
	public static void main(String[] args) {
		
		FileWriter fw = null;  //make fw global
		try {
			fw = new FileWriter("D:\\Files\\home.txt");
			
			String str = "hello java, hello tops";
			fw.write(str);
			fw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("done");
		
	}

}
