package Servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Data.Allorder;
import DbConnect.order_con;

/**
 * Servlet implementation class FindOrderBystate
 */
@WebServlet("/FindOrderBystate")
public class FindOrderBystate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrderBystate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        String state = request.getParameter("state");
        String cus_id = request.getParameter("cus_id");
        String order_id = request.getParameter("order_id");
        if(cus_id.equals("")) System.out.println(state+cus_id+order_id);
		order_con con=new order_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			Allorder customer=con.findorderbystate(state,cus_id,order_id);
			con.conClose();
			Gson gson=new Gson();
			String json=gson.toJson(customer);
			System.out.println(json);
			PrintWriter out = null;
			request.setAttribute("data", json);
			request.getRequestDispatcher("searchorder.jsp").forward(request, response);
			out = response.getWriter();
		    out.write(json);
		    out.flush();
		    out.close();
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
