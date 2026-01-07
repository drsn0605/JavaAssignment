 package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/edit")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//jo bhi update.jsp pe hum upadate karenge wo sara data yaha pr aa jayega. Or usko hame Get karna padega. So...
		//Hum RegServlet pe post method me jo bhi tha use copy kar lenge. + hame ek id bhi chahiye.. ki kis id pe update karna hai..So...
		//So ab hame update.jsp me ek field lena padega [ <input type="text" name="id" value="${student123.id}"> ]..
		//abhi ham get karenge.
		int eid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		Student st = new Student();
		st.setId(eid);    //here id hamne set kiya hai, to prepareStatement me bhi id ko get karna padega. means, 0 ke badle st.getId() karna padega. So...[ ps.setInt(4, st.getId()); ]
		st.setName(name);
		st.setEmail(email);
		st.setPhone(phone);
		
		StudentDao dao = new StudentDao();
		int i = dao.updateStudent(st);
		
		while(i>0) {
			
			req.setAttribute("msg", "update successfully");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//very first hame eid ko get karna padega + save karna padega (id String me ayegi isliye hame usko int me cast karna padega.
		int eid = Integer.parseInt(req.getParameter("eid"));
		
		//now we have to get data of this eid from DB - via Dao (StudentDao me hum ek method banayenge)
//		System.out.println("done");
		StudentDao dao = new StudentDao();   //method ko use karne ke liye hum uska ek object banayenge..
		dao.getStudentById(eid);    //this how we can use that method to get eid Data. 
		 
		Student st = dao.getStudentById(eid);   //yaha jo bhi eid hum pass karenge wo id ka data(Student) hame mill jayega.
//		System.out.println("done");
		
		//abhi studentDao me return null hai- jabki hame ek Student(including Student data) return me chahiye, So.....move to StudentDao->
//		System.out.println("done ");
		
//		//ye jo st me data hai use ham update.jsp pe leke jayenge.
//		req.getRequestDispatcher("update.jsp").forward(req, resp);
//		//aur kya leke jayenge - student naam ke attribute ke under st lekr jayenge.(means student[which is table name] & st means real world entity - student data.)So,.....
//		req.setAttribute("student", st);
		
		req.setAttribute("student123", st);     
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
	

}
