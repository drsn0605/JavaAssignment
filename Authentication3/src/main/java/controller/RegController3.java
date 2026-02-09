package controller;

import java.io.IOException;

import dao.UserDao3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User3;

@WebServlet("/reg3")
public class RegController3 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String lang[] = req.getParameterValues("lang");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		String lng = "";
		for(String l : lang) {
			lng = lng + l + ",";
		}
		
		User3 user = new User3();
		user.setName(name);
		user.setEmail(email);
		user.setPass(pass);
		user.setGender(gender);
		user.setLang(lng);
		user.setCountry(country);
		user.setAddress(address);
		
		UserDao3 dao = new UserDao3();
		if(dao.isEmailExist(email)) {
			
			req.setAttribute("msg", "Email already registered..");
			req.getRequestDispatcher("reg3.jsp").forward(req, resp);
			
		}
		else {
			int j = dao.addUser(user);
			
			if(j>0) {
				req.setAttribute("msg", "Register successfully");
				req.getRequestDispatcher("reg3.jsp").forward(req, resp);
			}
		}
	}
}
