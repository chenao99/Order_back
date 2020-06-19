package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbConnect.order_con;

/**
 * Servlet implementation class changeorderstate
 */
@WebServlet("/changeorderstate")
public class changeorderstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeorderstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        String id = request.getParameter("order_id");
        String state = request.getParameter("state");
        order_con con=new order_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr="";
		try {
			if(con.changeorderstate(id,state))
			{
	    		jsonStr = "{\"info\":\"1\"}";
			}
			else {
				jsonStr = "{\"info\":\"0\"}";
			}
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
			con.psClose();
	    		
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
