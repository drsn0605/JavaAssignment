package Fileio;

import java.io.File;

public class F008_FileClass {
	public static void main(String[] args) {
		
		File f = new File("D:\\Files\\home2");
		
//		System.out.println(f.exists());
		
//		try {
//			f.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		f.delete();
		
//		System.out.println(f.isFile());
//		System.out.println(f.isDirectory());
		f.mkdir();
		
		System.out.println("hgAVCAMC");
	}

}
