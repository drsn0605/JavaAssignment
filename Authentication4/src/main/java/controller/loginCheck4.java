package controller;

import java.io.IOException;

import dao.UserDao4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User4;

@WebServlet("/login4")
public class loginCheck4 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User4 user = new User4();
		user.setEmail(email);
		user.setPassword(pass);
		
		UserDao4 dao = new UserDao4();
		User4 fuser = dao.loginCheck(user);     //ye method kya return karega ? ->Agar user hoga to user return karega/ else- null return karega.
		
		if(fuser==null) {
			req.setAttribute("err", "Invalid Credentials !!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else {
			
			HttpSession session = req.getSession();
			session.setAttribute("userAttr", fuser);  //yaha hamne pura fuser userAttr me set kar diya. Ab hame home4.jsp ko ristrict karna hai.. So, in home4.jsp-
			
			req.setAttribute("msg",fuser.getName());
			req.getRequestDispatcher("home4.jsp").forward(req, resp);
		}
	}
}
