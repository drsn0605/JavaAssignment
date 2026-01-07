package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student4;

public class Studentdao4 {
	Connection cn = null;
	public Studentdao4() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int addStudent4(Student4 st) {     //here first we are declaring return variable as void but, we have to checked i - so that we have to return i and for that we change return type as int.
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into stdhome values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getHometown());
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	public ArrayList<Student4> viewStudent() {
		
		ArrayList<Student4> al = new ArrayList<Student4>();
		
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from stdhome");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student4 st = new Student4();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setHometown(rs.getString(4));
				al.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	public int deleteStudent(int id) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("delete from stdhome where id=?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
