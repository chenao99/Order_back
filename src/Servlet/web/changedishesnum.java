package Servlet.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DbConnect.dishes_con;
import Data.*;

/**
 * Servlet implementation class changedishesnum
 */
@WebServlet("/changedishesnum")
public class changedishesnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changedishesnum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		dishes_con con=new dishes_con();
		try {
			ALLMenu allmenu=con.getMenu();
			ArrayList<Menu> menulist=allmenu.results;
			for(int i=0;i<menulist.size();i++) {
				ArrayList<Dishes> disheslist=menulist.get(i).dishes;
				for(int j=0;j<disheslist.size();j++) {
					//System.out.println(disheslist.get(j).getid()+":  "+request.getParameter(disheslist.get(j).getid()));
					disheslist.get(j).setsum(Integer.valueOf(request.getParameter(disheslist.get(j).getid())).intValue());
				}
				menulist.get(i).dishes=disheslist;
			}
			System.out.println(menulist.get(0).dishes.get(0).getsum());
			allmenu.results=menulist;
			if(con.changedishesnum(allmenu)==1) {
				Gson gson=new Gson();
				String json=gson.toJson(allmenu);
				request.setAttribute("data", json);
				request.getRequestDispatcher("dishes.jsp").forward(request, response); 
			}
			
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
