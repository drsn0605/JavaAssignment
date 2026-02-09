package controller;

import java.io.IOException;

import dao.UserDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User2;

@WebServlet("/reg2")
public class RegController2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String lang[] = req.getParameterValues("lang");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		String lng ="";
		for(String l : lang) {
			lng = lng + l + ",";
		}
		
		User2 user = new User2();
//		user.setId(0);  //not mandatory to set ID over here. 
		user.setName(name);
		user.setEmail(email);
		user.setPass(pass);
		user.setGender(gender);
		user.setLang(lng);
		user.setCountry(country);
		user.setAddress(address);
		
		UserDao2 dao = new UserDao2();
		if(dao.isEmailExist(email)) {
			
			req.setAttribute("msg", "Email already exist");
			req.getRequestDispatcher("reg2.jsp").forward(req, resp);
		}
		else{
			
			int i = dao.addUser(user);
			
			if(i>0) {
				req.setAttribute("msg", "Register successfully");
				req.getRequestDispatcher("reg2.jsp").forward(req, resp);
			}
		
		}
		
	}
}
