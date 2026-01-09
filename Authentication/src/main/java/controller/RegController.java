package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String lang[] = req.getParameter("lang");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		
	}
}
