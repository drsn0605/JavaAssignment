package Fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class F003_NameEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
        String name = sc.nextLine(); // read string input
        
        System.out.print("Enter your Email : ");
        String email = sc.nextLine();
        
        FileOutputStream fos = null;
        try {
			fos = new FileOutputStream("D:\\Files\\" + name + ".txt3");
			String str = email;
			byte b[] = str.getBytes();
			fos.write(b); // Add exception to existing catch cause
			System.out.println("done");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
        	try {
				fos.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}

}
