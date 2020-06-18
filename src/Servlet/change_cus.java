package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbConnect.user_con;

/**
 * Servlet implementation class change_cus
 */
@WebServlet(name ="/change_cus",urlPatterns = "/change_cus")
public class change_cus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_cus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String c_id = request.getParameter("c_Id");
        String c_Name = request.getParameter("c_Name");
		String c_Psd = request.getParameter("c_Psd");
		String c_Sex = request.getParameter("c_Sex");
		String c_tel = request.getParameter("c_tel");
		user_con con=new user_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			if(con.change(Integer.valueOf(c_id).intValue(), c_Name, c_Psd, c_Sex, c_tel))
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
