package Servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Dishes;
import DbConnect.dishes_con;

/**
 * Servlet implementation class changedishes
 */
@WebServlet("/changedishes")
public class changedishes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changedishes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
        String name =request.getParameter("name");
        double price =Double.valueOf(request.getParameter("price")==null?"-100":request.getParameter("price")).doubleValue();
        String note =request.getParameter("note");
        String evaluate=request.getParameter("evaluate");
        int kinds=Integer.valueOf(request.getParameter("kind")==null?"-100":request.getParameter("kind")).intValue();
        int sum=Integer.valueOf(request.getParameter("sum")==null?"-100":request.getParameter("sum")).intValue();
        String url=request.getParameter("url");
        Dishes dishes=new Dishes(id,name,price,note,evaluate,kinds,sum,url);
		dishes_con con=new dishes_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr="";
		try {
			if(con.changeDisher(dishes)==0)
			{
	    		jsonStr = "{\"info\":\"0\"}";
			}
			else {
				jsonStr = "{\"info\":\"1\"}";
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
