package controller;

import java.io.IOException;

import dao.UserDao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User4;

@WebServlet("/reg4")
public class RegController4 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String lang[] = req.getParameterValues("lang");
		
		String lng = "";
		for(String l : lang) {
			lng = lng + l + ",";
		}
		
		User4 user = new User4();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(pass);
		user.setLang(lng);
		
		UserDao4 dao = new UserDao4();
		if(dao.isEmailExist(email)) {
			
			req.setAttribute("msg4", "Email already exist!!");
			req.getRequestDispatcher("reg4.jsp").forward(req, resp);
		}
		else {
			int j = dao.addUser(user);
			
			if(j>0) {
				req.setAttribute("msg4", "Register successfully");
				req.getRequestDispatcher("reg4.jsp").forward(req, resp);
			}
		}
	}
}
