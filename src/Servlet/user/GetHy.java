package Servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbConnect.user_con;

/**
 * Servlet implementation class GetHy
 */
@WebServlet(name = "/GetHy",urlPatterns = "/GetHy")
public class GetHy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
		user_con con=new user_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			if(con.GetHy(Integer.valueOf(username).intValue()).equals("��Ա"))
			{
				
	    		String jsonStr = "{\"info\":\"true\"}";
	    		System.out.println(jsonStr);
	    		PrintWriter out = null;
	    		try {
	    		    out = response.getWriter();
	    		    out.write(jsonStr);
	    		}catch(Exception e)
	    		{
	    			
	    		}
	    		out.flush();
	    		out.close();
			}
			else {
				PrintWriter out = null;
				String jsonStr = "{\"info\":\"false\"}";
				System.out.println(jsonStr);
	    		try {
	    		    out = response.getWriter();
	    		    out.write(jsonStr);
	    		}catch(Exception e)
	    		{
	    			
	    		}
	    		out.flush();
	    		out.close();
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
