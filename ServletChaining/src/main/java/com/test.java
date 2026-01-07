package com;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class test extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Set some data in request
        request.setAttribute("name", "Deep");

        // 2. Get RequestDispatcher object
        RequestDispatcher rd = request.getRequestDispatcher("test.jsp");

        // 3. Forward request and response
        rd.forward(request, response);
    }
}



