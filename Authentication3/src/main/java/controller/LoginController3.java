package controller;

import java.io.IOException;

import dao.UserDao3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User3;

@WebServlet("/login3")
public class LoginController3 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User3 user = new User3();
		user.setEmail(email);
		user.setPass(pass);
		
		UserDao3 dao = new UserDao3();
		User3 g = dao.loginCheck(user);
		
		if(g==null) {
			req.setAttribute("err", "Invalid Credential !!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else {
			
			HttpSession session = req.getSession();
			session.setAttribute("duser", g);
			
			req.setAttribute("msg", g.getName());
			req.getRequestDispatcher("home3.jsp").forward(req, resp);
		}
	}
}
