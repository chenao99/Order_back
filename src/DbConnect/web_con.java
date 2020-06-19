package DbConnect;

import java.sql.*;
import Data.*;

public class web_con extends DBcon{        //连接数据库
	
	public web_con() {
		
	}
	//店家登陆
	public boolean login(int userID,String password) throws SQLException
	{
		String sql="SELECT * FROM  administrators where account=? and psw=?";
		this.ps = dbConn.prepareStatement(sql);
		ps.setLong(1, userID);
	    ps.setString(2, password);
	    rs = ps.executeQuery();
	    if(rs.next())
	       return true;
	    return false;
	}
	
	
	public String getaffiche() throws SQLException
	{
		String sql="SELECT * FROM  Affiche where date='1'";
		this.ps = dbConn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    if(rs.next())
	       return rs.getString("affiche");
	    return "无数据";
	}
	
	
	public turnover getturnover() throws SQLException
	{
		String sql="SELECT * FROM `order`";
		this.ps = dbConn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    String datetemp="";
	    Double price=0.0;
	    turnover affiche=new turnover();
	    if(rs.next()) {
	    	datetemp=rs.getString("order_id").substring(5, 10);
	    	price=Double.valueOf(rs.getString("priceall")).doubleValue();
	    }
	    while(rs.next()) {
	    	if(datetemp.equals(rs.getString("order_id").substring(5, 10))){
	    		price+=Double.valueOf(rs.getString("priceall")).doubleValue();
	    	}
	    	else {
	    		affiche.affiche.add(price);
	    		affiche.date.add(datetemp);
	    		datetemp=rs.getString("order_id").substring(5, 10);
	    		price=Double.valueOf(rs.getString("priceall")).doubleValue();
	    	}
	    }
	    //System.out.println(price);
	    //System.out.println(datetemp);
	    affiche.affiche.add(price);
		affiche.date.add(datetemp);
		return affiche;
	}
	
	public String addaffiche(String content) throws SQLException
	{
		String sql="UPDATE Affiche SET date='0'";
		ps = dbConn.prepareStatement(sql);
	    ps.executeUpdate();
	    sql="insert into Affiche(affiche,id,date) value(?,1,1)";
	    ps = dbConn.prepareStatement(sql);
	    ps.setString(1, content);
	    ps.execute();
	    return "插入成功";
	}
	

	
}