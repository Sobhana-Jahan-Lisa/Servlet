import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String p=request.getParameter("userPass");
		if(p.equals("lisa12")){
			RequestDispatcher rd=request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
			
		}
		else{
			out.print("Sorry username or password error!");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	}

}
