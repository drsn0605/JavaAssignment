package FileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//What Happens Internally

//JVM opens the file at D:\Files\Test.txt.

//Creates a byte stream channel between your program and the file.

//You use fos.write(...) to send bytes through this channel.

//The OS writes those bytes into the file.


//Finally, fos.close() closes the channel to prevent data loss.

public class NameEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter your email : ");
		String email = sc.nextLine();
		
		FileOutputStream fos = null;  //make fos global
		try {
			fos = new FileOutputStream("D:\\Files\\"+ name + ".txt");
			String str = email;
			byte[] b = str.getBytes();
			fos.write(b);
			System.out.println("done");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.close();
		}
		
	}

}
