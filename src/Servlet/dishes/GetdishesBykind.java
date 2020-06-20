package Servlet.dishes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DbConnect.dishes_con;
import Data.Dishes;

/**
 * Servlet implementation class GetdishesBykind
 */
@WebServlet(name = "/GetdishesBykind",urlPatterns="/GetdishesBykind")
public class GetdishesBykind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetdishesBykind() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int kindid =Integer.valueOf(request.getParameter("kindid")).intValue();
		dishes_con con=new dishes_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			List<Dishes> dishes=con.getDisherBykind(kindid);
			con.conClose();
			Gson gson=new Gson();
			String json=gson.toJson(dishes);
			System.out.println(json);
			PrintWriter out = null;
			out = response.getWriter();
		    out.write(json);
		    out.flush();
		    out.close();
			con.conClose();
		}catch (Exception e) {
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
