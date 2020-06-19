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
 * Servlet implementation class changeorder
 */
@WebServlet("/changeorder")
public class changeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String table_id=request.getParameter("table_id");     //订单id
		double priceall=Double.valueOf(request.getParameter("priceall")).doubleValue();     //新增总价
		String[] dishes=request.getParameter("dishes").split(",");  //菜名列表
        String[] numstr=request.getParameter("num").split(",");     //菜数量列表
        System.out.println(priceall);
        int[] num=new int[numstr.length];
        for(int i=0;i<numstr.length;i++) {
        	num[i]=Integer.valueOf(numstr[i]).intValue();
        }
        order_con con=new order_con();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			con.changeorder(table_id,priceall, dishes, num);
			String jsonStr = "{\"info\":\"1\"}";
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
