package Fileio;

import java.io.FileInputStream;
import java.io.IOException;

public class F005_NameEmailRead {
	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\Files\\rahul.txt3");
			int i = fis.read();

			while (i != -1) {
				char ch = (char) i;
				System.out.print(ch);
				i = fis.read();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
