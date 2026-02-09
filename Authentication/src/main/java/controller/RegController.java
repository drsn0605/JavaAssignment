package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String lang[] = req.getParameterValues("lang");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		//Array to String conversation
		String lng="";
		for(String l:lang) {
			lng = lng + l + ",";
		}
		
		User user = new User();
//		user.setId(0);  //yeah pe ye set karna jaruri nahi hai. Kyuki ye auto increment hai.. Jab DB me store karenge waha pr set kar denge.
		user.setName(name);
		user.setEmail(email);
		user.setPass(pass);
		user.setGender(gender);
		user.setLang(lng);
		user.setCountry(country);
		user.setAddress(address);
			
		UserDao dao = new UserDao();
		if(dao.isEmailExist(email)) {   //if dao.isEmailExist ye function true[if - matlab true hi hoga]  return karega(means email already exist hai)
			
			req.setAttribute("msg", "User already exist");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}
		else {   //if agar false [false matlb email DB me exist nahi hai] return karega to hi hame user ko add karna hai.
		
			int i = dao.addUser(user); 
			if(i>0) {
				req.setAttribute("msg", "Register Successfully");
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
			}
		}
	}
}
