package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Data.turnover;
import DbConnect.web_con;

/**
 * Servlet implementation class getturnover
 */
@WebServlet("/getturnover")
public class getturnover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getturnover() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		web_con con=new web_con();
		try {
			turnover turnover=con.getturnover();
			Gson gson=new Gson();
			String json=gson.toJson(turnover);
			System.out.println(json);
			PrintWriter out = null;
			request.setAttribute("data", json);
			request.getRequestDispatcher("sb.jsp").forward(request, response);
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
