package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryOperation {
	
	Connection cn = null;
	public LibraryOperation() {    //constructor 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/28aug_2025_java";
			String user = "root";
			String password = "drsn@1028";
			
			cn = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void addbook() {
		
		System.out.println("Enter book name : ");
		String name = sc.next();
		System.out.println("Enter quantity : ");
		int qty = sc.nextInt();
		
		try {
			PreparedStatement ps1 = cn.prepareStatement("select * from book where name=?");
			ps1.setString(1, name);
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				System.out.println("Book already exist");
			}
			else {
				PreparedStatement ps = cn.prepareStatement("insert into book values(?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2,name);
				ps.setInt(3, qty);
				
				int i = ps.executeUpdate();
				if(i>0) {
					System.out.println("Book inserted");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewbook() {
		try {
			PreparedStatement ps = cn.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				
				System.out.println(id+". "+name+". "+qty+". ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletebook() {
		
		System.out.println("Enter book name : ");
		String name = sc.next();
		
		try {
			PreparedStatement ps1 = cn.prepareStatement("delete from book where name = ?");
			ps1.setString(1, name);
			
			int i = ps1.executeUpdate();
			
			if(i>0) {
				System.out.println("Book deleted");
			}
			else {
				System.out.println("Book not found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void issuebook() {
		System.out.println("Enter book name : ");
		String name = sc.next();
		
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from book where name = ?");
			ps.setString(1,name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int qty = rs.getInt(3);
				if(qty<=0) {
					System.out.println("Book is not available at the moment");
				}
				else {
					qty--;
					PreparedStatement ps1 = cn.prepareStatement("update book set qty = ? where name = ?");
					ps1.setInt(1,qty);
					ps1.setString(2, name);
					
					int i = ps1.executeUpdate();
					if(i>0) {     //i is greater
						System.out.println("Book issued");
					}
				}
			}
			else {
				System.out.println("Book is not available");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}





