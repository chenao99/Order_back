package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Data.ALLMenu;
import Data.Dishes;
import DbConnect.dishes_con;

/**
 * Servlet implementation class adddishes
 */
@WebServlet("/adddishes")
public class adddishes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adddishes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("newid");
        String name =request.getParameter("newname");
        double price =Double.valueOf(request.getParameter("newprice")).doubleValue();
        int kinds=Integer.valueOf(request.getParameter("newdishes_kindid")).intValue();
        int sum=Integer.valueOf(request.getParameter("newnum")).intValue();
        
        String note =request.getParameter("note");
        String evaluate=request.getParameter("evaluate");
        String url=request.getParameter("url");
        Dishes dishes=new Dishes(id,name,price,note,evaluate,kinds,sum,url);
		dishes_con con=new dishes_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr="";
		try {
			ALLMenu customer=con.getMenu();
			if(con.addDisher(dishes)==1)
			{
				customer=con.getMenu();
				customer.seterror("0");
				
			}
			else {
				customer=con.getMenu();
				customer.seterror("1");
			}
			con.conClose();
			Gson gson=new Gson();
			String json=gson.toJson(customer);
			System.out.println(json);
			request.setAttribute("data", json);
			request.getRequestDispatcher("dishes.jsp").forward(request, response);
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
