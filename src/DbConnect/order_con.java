package DbConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.order;
import Data.Table;
import Data.Allorder;
import Data.Dishes_num;
import Data.FreeTable;

public class order_con extends DBcon {

	public order_con() {
		// TODO 自动生成的构造函数存根
	}
	
	//插入提交订单
	public int addorder(order order) throws SQLException {
		String sql="update `table` set state=? where `table`=?";
		ps = dbConn.prepareStatement(sql);
		ps.setLong(1,1);
		ps.setLong(2,order.gettable_id());
		ps.executeUpdate();
		String sqlask="SELECT * FROM `order` where order_id = ?";
		ps = dbConn.prepareStatement(sqlask);
	    ps.setString(1, order.getorder_id());
	    rs = ps.executeQuery();
        if(rs.next()) {
        	return 0;       //订单号已存在
        }
        else {
        	sql="insert into `order`(order_id,customer_id,table_id,state,priceall,dishes_num,evaluate) value(?,?,?,?,?,?,?)";
    		ps = dbConn.prepareStatement(sql);
    	    ps.setString(1, order.getorder_id());
    	    ps.setString(2, order.getcus_id());
    	    ps.setLong(3, order.gettable_id());
    	    ps.setString(4, order.getstate());
    	    ps.setDouble(5, order.getpriceall());
    	    ps.setString(7, order.getevaluat());
    	    ps.execute();
    	    for(int i=0;i<order.dishes.size();i++) {
    	    	sql="insert into order_dishes(order_id,dishes_id,num) value(?,?,?)";
    	    	ps = dbConn.prepareStatement(sql);
        	    ps.setString(1, order.getorder_id());
        	    ps.setString(2, order.dishes.get(i).getname());
        	    ps.setLong(3, order.dishes.get(i).getnum());
        	    ps.execute();
    	    }
    	    
            return 1;    //插入成功
        }
	}
	
	
	//查找空闲桌子
	public FreeTable gettable() throws SQLException {
		String sql="SELECT * FROM `table` WHERE state=0";
		ps = dbConn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    FreeTable ft=new FreeTable("free");
	    while(rs.next()) {
	    	int id=Integer.valueOf(rs.getString("table")).intValue();
	    	int num=Integer.valueOf(rs.getString("num")).intValue();
	    	Table tt=new Table(id,num,0);
	    	ft.tablelist.add(tt);
	    }
	    return ft;
	}
	
	
	
	//修改订单
	public boolean changeorder(String order_id,String[] dishes_id,int[] num) throws SQLException {
		for(int i=0;i<dishes_id.length;i++) {
			String sql="SELECT * FROM order_dishes WHERE order_id=? AND dishes_id=?";
			ps = dbConn.prepareStatement(sql);
			ps.setString(1,order_id);
			ps.setString(2,dishes_id[i]);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql="update order_dishes set num=? where order_id=? AND dishes_id=?";
				ps = dbConn.prepareStatement(sql);
				ps.setLong(1,num[i]+Integer.valueOf(rs.getString("num")).intValue());
				ps.setString(3,dishes_id[i]);
				ps.setString(2,order_id);
				ps.executeUpdate();
			}
			else {
				sql="insert into order_dishes(order_id,dishes_id,num) value(?,?,?)";
				ps = dbConn.prepareStatement(sql);
				ps.setLong(3,num[i]);
				ps.setString(2,dishes_id[i]);
				ps.setString(1,order_id);
				ps.execute();
			}
		}
		return true;
	}
	
	
	//修订单状态
	public boolean changeorderstate(String id,String state) throws SQLException{
		String sql="SELECT table_id	FROM `order` where order_id=?";
		ps = dbConn.prepareStatement(sql);
		ps.setString(1,id);
		rs = ps.executeQuery();
		if(rs.next()&&state.equals("2")) {
			sql="update `table` set state=0 where `table`=?";
			ps = dbConn.prepareStatement(sql);
			ps.setString(1,rs.getString("table_id"));
			ps.executeUpdate();
		}
		sql="update `order` set state=? where `order_id`=?";
		ps = dbConn.prepareStatement(sql);
		ps.setString(1,state);
		ps.setString(2,id);
		int t=ps.executeUpdate();
        if(t>0)
        {
        	return true;
        }
		return false;
	}
	
	
	public Allorder findorderall(String id,String state) throws SQLException{
		String sql="SELECT order_id,priceall,dishes_num,table_id,over_time FROM `order` where customer_id=? AND state=?";
		ps = dbConn.prepareStatement(sql);
	    ps.setString(1, id);
	    ps.setString(2, state);
	    rs = ps.executeQuery();
	    Allorder allorder=new Allorder("false");
	    while(rs.next()) {
	    	allorder.inf="true";
	    	String order_id=rs.getString("order_id");
	    	sql="SELECT dishes.`name`,num \r\n" + 
	    			"FROM `order_dishes`,dishes\r\n" + 
	    			"where order_id=? AND order_dishes.dishes_id=dishes.id";
	    	ps = dbConn.prepareStatement(sql);
		    ps.setString(1, order_id);
		    ResultSet rs1;
		    rs1 = ps.executeQuery();
		    order order=new order(order_id, Double.valueOf(rs.getString("priceall")).doubleValue(), Integer.valueOf(rs.getString("dishes_num")).intValue(),Integer.valueOf(rs.getString("table_id")).intValue(),rs.getString("over_time"));
		    while(rs1.next()) {
		    	Dishes_num dishes=new Dishes_num(rs1.getString("name"),Integer.valueOf(rs1.getString("num")).intValue());
		    	System.out.println(rs1.getString("name")+" "+Integer.valueOf(rs1.getString("num")));
		    	order.dishes.add(dishes);
		    }
		    
		    allorder.orderList.add(order);
	    }
	    return allorder;
	}
	
	public Allorder findorderbystate(String state) throws SQLException{
		String sql="SELECT order_id,priceall,dishes_num,table_id,over_time FROM `order` where state=?";
		ps = dbConn.prepareStatement(sql);
	    ps.setString(1, state);
	    rs = ps.executeQuery();
	    Allorder allorder=new Allorder("false");
	    while(rs.next()) {
	    	allorder.inf="true";
	    	String order_id=rs.getString("order_id");
	    	sql="SELECT dishes.`name`,num \r\n" + 
	    			"FROM `order_dishes`,dishes\r\n" + 
	    			"where order_id=? AND order_dishes.dishes_id=dishes.id";
	    	ps = dbConn.prepareStatement(sql);
		    ps.setString(1, order_id);
		    ResultSet rs1;
		    rs1 = ps.executeQuery();
		    order order=new order(order_id, Double.valueOf(rs.getString("priceall")).doubleValue(), Integer.valueOf(rs.getString("dishes_num")).intValue(),Integer.valueOf(rs.getString("table_id")).intValue(),rs.getString("over_time"));
		    while(rs1.next()) {
		    	Dishes_num dishes=new Dishes_num(rs1.getString("name"),Integer.valueOf(rs1.getString("num")).intValue());
		    	System.out.println(rs1.getString("name")+" "+Integer.valueOf(rs1.getString("num")));
		    	order.dishes.add(dishes);
		    }
		    
		    allorder.orderList.add(order);
	    }
	    return allorder;
	}
	
}
