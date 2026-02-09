package controller;

import java.io.IOException;

import dao.UserDao2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User2;

@WebServlet("/login2")
public class LoginControlller2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User2 u = new User2();
		u.setEmail(email);
		u.setPass(pass);
		
		UserDao2 dao = new UserDao2();
		User2 user = dao.loginCheck(u);
		
		if(user==null) {
			req.setAttribute("err", "Invalid Credential!!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else {
			
			HttpSession session = req.getSession();
			session.setAttribute("loguser", user);
			req.setAttribute("msg", user.getName());
			req.getRequestDispatcher("home2.jsp").forward(req, resp);
		}
	}
}
