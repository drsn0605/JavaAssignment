package dao;    //model class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDao {
	
	Connection cn = null;  //make it global
	
	public StudentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","drsn@1028");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addStudent(Student st) {   
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2, st.getName());
			ps.setString(3, st.getEmail());
			ps.setString(4, st.getPhone());
			
			i = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	} 
	
	public ArrayList<Student> viewStudents() {    //1st   + 8th(we have to change return type- void to ArrayList<Student>)
		
		ArrayList<Student> al = new ArrayList<Student>();  //6th
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student");   //2nd 
			
			ResultSet rs = ps.executeQuery();   //3rd
			while(rs.next()) {   //4th 
				Student st = new Student();   //5th
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setPhone(rs.getString(4));
				
				al.add(st);    //7th
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
			PreparedStatement ps = cn.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;  //jo i return hoga wo hame DeleteController pe milega.
		
	}
	
	//hame student ka data chahiye isliye hame method banana padega.
	public Student getStudentById(int eid) {
		//->yeha hame Student ko return karna hai, 
		//for that hum Student class ka ek object banayenge.
		
		Student st = new Student();   //ab hum Student ko return kar sakte hai (So, null ki jagah pe st likhenge)
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where id=?");    //here table name must be same. Student != student....
			ps.setInt(1, eid);   //means id ka sara data ayega- pr kaha ayega ? -> ResultSet me.
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//ResultSet se agar no.1 ka data aaya, to use ham kaha pr add karenge ?? -> st me. So....
//				st.setId(eid);  //ye eid kaha se aayega?  ->re.getInt(1); se 
				
				st.setId(rs.getInt(1));   //means column 1 se jo bhi [id] aayega use ham st me store karenge. lly...
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setPhone(rs.getString(4));
				//or st me jo data store hoga wo ham return kar denge. by {return st;}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	public int updateStudent(Student st) {
		int i = 0;
		
		try {
			PreparedStatement ps = cn.prepareStatement("update student set name=?, email=?, phone=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getPhone());
			ps.setInt(4, st.getId());    //dont forget to get id. Bcoz, id hamne set kiya hai, So idhar get bhi karna padega.
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
