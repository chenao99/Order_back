package Servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Data.order;
import Data.Dishes_num;
import DbConnect.order_con;;

/**
 * Servlet implementation class addorder
 */
@WebServlet("/addorder")
public class addorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		String order_id=df.format(new Date());     //订单id
		System.out.println(order_id);
		String cus_id=request.getParameter("cus_id");        //客户id
		int table_id=Integer.valueOf(request.getParameter("table_id")).intValue();   //桌号
		String state=request.getParameter("state");         //订单状态
		double priceall=Double.valueOf(request.getParameter("priceall")).doubleValue();    //总价
		String evaluate=request.getParameter("evaluate");          //评价
		String[] dishes=request.getParameter("dishes").split(",");  //菜名列表
        String[] numstr=request.getParameter("num").split(",");     //菜数量列表
        int[] num=new int[numstr.length];
        order order=new order(order_id, cus_id, table_id, state, priceall, evaluate);
        for(int i=0;i<numstr.length;i++) {
        	num[i]=Integer.valueOf(numstr[i]).intValue();
        	System.out.println(num[i]);
        	Dishes_num dish=new Dishes_num(dishes[i],num[i]);
        	order.dishes.add(dish);
        }
        
        order_con con=new order_con();
        String jsonStr="";
		try {
			if(con.addorder(order)==0)
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
        
        Gson gson=new Gson();
		String json=gson.toJson(dishes);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
