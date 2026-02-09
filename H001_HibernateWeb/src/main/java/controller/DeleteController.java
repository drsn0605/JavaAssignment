package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//first req.getParameter("sid");   //1st - get id through, req.getParameter
		//second String id = req.getParameter("sid");  //2nd - store id in one variable(String id).
		//third Integer.parseInt(id);
		//forth Integer.parseInt(req.getParameter("sid"));
		int id = Integer.parseInt(req.getParameter("sid"));
		
		StudentDao dao = new StudentDao();
		int i = dao.deleteStudent(id);
		if(i>0) {   //agar i 0 se bada hoga (means 1 hoga -> id delete hogi) to delete hone ke bad hame kaha jana hai ? 
			//@wapas display page pe hi jana hai. So.... 
			//req.getRequestDispatcher("display.jsp").forward(req, resp);   //yaha hum display.jsp pe nahi jayenge - kyuki display page kaha Display-Servlet se open hota hai.So hame data Display-Servlet pe leke jana padega.
			// Display-Servlet data delete karne ke baad, upadated data(latest data) show karega.
			req.getRequestDispatcher("display").forward(req, resp);
		}
		
		//we want to delete this id - so we create a delete method inside dao.
	}

}

