package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbConnect.web_con;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "/loginweb",urlPatterns = "/loginweb")
public class loginweb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginweb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		web_con con=new web_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			String json;
			if(con.login(Integer.valueOf(username).intValue(), password))
			{
				json="true";
				request.setAttribute("data", json);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			else {
				json="µÇÂ½Ê§°Ü";
				request.setAttribute("data", json);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
			con.conClose();
	    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
